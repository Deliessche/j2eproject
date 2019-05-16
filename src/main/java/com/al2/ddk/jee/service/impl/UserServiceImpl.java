package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.exception.NetflischException;
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
	public void createUser(User user) throws Exception {
		if (user.getIdU() != null) {
			throw new Exception("Erreur, l'ID doit être null");
		} else {
			userRepository.save(user);
		}
	}

	/******/
	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	/******/
	@Override
	public boolean setPassword(int id, String password) {
		User user = getUser(id);
		if(user!=null) {
			user.setPasswordU(password);
			userRepository.save(user);
			return true;
		}
		return false;
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
	public boolean isEmailExist(String email) {
		if(getUser(email)!=null) {
			return true;
		}
		return false;
	}
}
