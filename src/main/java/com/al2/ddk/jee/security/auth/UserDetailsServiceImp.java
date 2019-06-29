package com.al2.ddk.jee.security.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.repository.UserRepository;

@Component
public class UserDetailsServiceImp implements UserDetailsService {

	/***/
	private final UserRepository userRepository;
	/***/
	@Autowired
	public UserDetailsServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User "+email+" was not found.");
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(user.getEmailU(), user.getPasswordU(), grantedAuthorities);
	}
}
