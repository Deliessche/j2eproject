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
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	/******/
	@Override
	public boolean isValidAccount(String email, String password) {
		if(userRepository.findByEmailAndPassword(email, password)!= null) {
			return true;
		} else return false;
	}

	/******/
	@Override
	public void setPassword(int id, String password) {
		User user = getUser(id);
		user.setPasswordU(password);
		userRepository.save(user);
	}

	/******/
	@Override
	public void createUser(String firstName, String lastName, String email, String password) {
		User user = new User();
		user.setFirstNameU(firstName);
		user.setLastNameU(lastName);
		user.setEmailU(email);
		user.setPasswordU(password);
		userRepository.save(user);
	}
}
