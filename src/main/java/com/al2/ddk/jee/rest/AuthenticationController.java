package com.al2.ddk.jee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.al2.ddk.jee.exception.NetflischException;
import com.al2.ddk.jee.security.auth.JwtTokenUtil;
import com.al2.ddk.jee.security.auth.LoginUser;
import com.al2.ddk.jee.service.UserService;

@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Object> register(@RequestBody LoginUser loginUser) throws NetflischException {

		try {
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginUser.getUsername(),
							loginUser.getPassword()
							)
					);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		} catch (AuthenticationException e) {
			throw new NetflischException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Une erreur est survenue : "+e.getMessage());
		}

		com.al2.ddk.jee.domain.User user = userService.getUser(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(token);
	}
}
