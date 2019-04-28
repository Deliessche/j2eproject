package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.repository.UserRepository;
import com.al2.ddk.jee.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	/***/
	private final UserRepository userRepository;
	/***/
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/******/
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	/******/
	@Override
	public User getUser(int id) {
		return userRepository.findById(id);
	}

	/******/
	@Override
	public void setPassword(int id, String password) {
		
		User user = getUser(id);
		user.setPasswordU(password);
		userRepository.save(user);
	}
}
