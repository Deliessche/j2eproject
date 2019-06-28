package com.al2.ddk.jee.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.al2.ddk.jee.security.JwtTokenUtil;
import com.al2.ddk.jee.security.LoginUser;
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginUser.getUsername(),
						loginUser.getPassword()
						)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		com.al2.ddk.jee.domain.User user = userService.getUser(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(token);
	}
}
