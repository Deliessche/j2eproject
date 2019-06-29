package com.al2.ddk.jee.security.auth;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.al2.ddk.jee.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenUtil implements Serializable {

//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }

//    public  T getClaimFromToken(String token, Function claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }

//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey("devglan123r")
//                .parseClaimsJws(token)
//                .getBody();
//    }
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    
    public String generateToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity;
            validity = new Date(now + " 5*60*60");

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("AUTHORITY", authorities)
                .signWith(SignatureAlgorithm.HS512, "devglan123r")
                .setExpiration(validity)
                .compact();
    }


//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }

    public String generateToken(User user) {
        return doGenerateToken(user.getEmailU());
    }
    

    private String doGenerateToken(String subject) {

        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://devglan.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 5*60*60 *1000))
                .signWith(SignatureAlgorithm.HS256, "devglan123r")
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaim(token);

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("AUTHORITY").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        org.springframework.security.core.userdetails.User principal = new org.springframework.security.core.userdetails.User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }


	public Claims getClaim(String token) {
		Claims claims = Jwts.parser()
                .setSigningKey( "devglan123r")
                .parseClaimsJws(token)
                .getBody();
		return claims;
	}

    
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (
              username.equals(userDetails.getUsername())
                    && !isTokenExpired(token));
    }
    
    public String getUsernameFromToken(String token) {
    	   return Jwts.parser()
                   .setSigningKey( "devglan123r")
                   .parseClaimsJws(token)
                   .getBody().getSubject();
    }
    
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    public Date getExpirationDateFromToken(String token) {
        return Jwts.parser()
                .setSigningKey( "devglan123r")
                .parseClaimsJws(token)
                .getBody().getExpiration();
    }

}
