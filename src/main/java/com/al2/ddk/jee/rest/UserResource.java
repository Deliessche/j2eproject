package com.al2.ddk.jee.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.exception.NetflischException;
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
	 * @return
	 * @throws NetflischException
	 */
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) throws NetflischException {
		User user = userService.getUser(id);
		if(user == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet utilisateur n'existe pas");
		} else {
			return user;
		}
	}

	/**
	 * supprime un utilisateur de Netflisch
	 * @param id
	 * @return
	 * @throws NetflischException
	 */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) throws NetflischException {
		if(userService.getUser(id) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet utilisateur n'existe pas");
		} else {
			userService.deleteUser(id);
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * créer un compte utilisateur Netflisch
	 * @param user
	 * @return
	 * @throws NetflischException
	 */
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user) throws NetflischException {
		/** si le user n'existe déjà on ne fait rien **/
		if(userService.isEmailExist(user.getEmailU())) {
			//return ResponseEntity.badRequest().body("Cet utilisateur existe déjà");
			throw new NetflischException(HttpStatus.BAD_REQUEST.value(), "Cet utilisateur existe déjà");
		} else {
			try {
				userService.createUser(user);
			} catch (Exception e) {
				throw new NetflischException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
			}
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * met à jour un compte utilisateur Netflisch
	 * @param user
	 * @return
	 * @throws NetflischException
	 */
	@PutMapping("/user")
	public ResponseEntity<Object> updateUser(@RequestBody User user) throws NetflischException {
		if(user.getIdU() == null || userService.getUser(user.getIdU()) == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet utilisateur n'existe pas");
		} else {
			try {
				userService.updateUser(user);
			} catch (Exception e) {
				throw new NetflischException(HttpStatus.BAD_REQUEST.value(), e.getMessage());
			}
		}
		return ResponseEntity.ok().build();
	}
}
