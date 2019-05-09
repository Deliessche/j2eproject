package com.al2.ddk.jee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.repository.UserRepository;
import com.al2.ddk.jee.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

	/***/
	private final Logger log = LoggerFactory.getLogger(UserResource.class);
	/***/
	@Autowired
	private UserRepository userRepository;
	/***/
	private UserService userService;

	/***/
	public UserResource(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	/**
	 * retourne toute la liste des utilisateurs de Netflisch
	 * @return une liste d'utilisateur
	 */
	@GetMapping("/user")
	public List<User> getAllUser() {
		List<User> allUsers = userService.getAllUser();
		return allUsers;
	}

	/**
	 * retourne un utilisateur de Netflisch
	 * @param id
	 * @return un utilisateur
	 */
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		User user = userService.getUser(id);
		return user;
	}

	/**
	 * supprime un utilisateur de Netflisch
	 * @param id
	 */
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		if(userService.getUser(id)!=null) {
			userService.deleteUser(id);
		}
	}

	/**
	 * créer un compte utilisateur Netflisch
	 * @param user
	 */
	@PostMapping("/user")
	public void createUser(@RequestBody User user) {
		if(!userService.isEmailExist(user.getEmailU())) {
			userService.createUser(user);
		}
	}
}
