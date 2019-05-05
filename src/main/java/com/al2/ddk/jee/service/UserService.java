package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.User;

@Service
public interface UserService {

	/**
	 * retourne la liste des utilisateurs
	 * @return une liste de User
	 */
	List<User> getAllUser();
	
	/**
	 * retourne un utilisateur en fonction de son identifiant
	 * @param id
	 * @return un User
	 */
	User getUser(int id);
	
	/**
	 * retourne un utilisateur en fonction de son email
	 * @param email
	 * @return un User
	 */
	User getUser(String email);
	
	/**
	 * permet de savoir si les identifiants de l'utilisateur correspondent ou non
	 * @param email
	 * @param password
	 * @return true si les identifants de connexions sont correct, sinon false
	 */
	boolean isValidAccount(String email, String password);
	
	/**
	 * modifie le mot de passe d'un utilisateur en fonction de son identifiant
	 * @param id
	 * @param password
	 */
	void setPassword(int id, String password);
	
	/**
	 * créer un nouvel utilisateur
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	void createUser(String firstName, String lastName, String email,  String password);
}
