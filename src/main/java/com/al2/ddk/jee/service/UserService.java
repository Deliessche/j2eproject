package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.service.dto.UserDTO;

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
	 * créer un nouvel utilisateur
	 * @param DTO
	 * @throws Exception 
	 */
	void createUser(UserDTO DTO) throws Exception;
	
	/**
	 * met à jour un utilisateur
	 * @param DTO
	 * @throws Exception
	 */
	void updateUser(UserDTO DTO) throws Exception;

	/**
	 * supprime un utilisateur en fonction de son identifiant
	 * @param id
	 */
	void deleteUser(int id);

	/**
	 * modifie le mot de passe d'un utilisateur en fonction de son identifiant
	 * @param id
	 * @param password
	 * @return true si la modif a réussit, sinon false
	 */
	boolean setPassword(int id, String password);

	/**
	 * permet de savoir si les identifiants de l'utilisateur correspondent ou non
	 * @param email
	 * @param password
	 * @return true si les identifants de connexions sont correct, sinon false
	 */
	boolean isValidAccount(String email, String password);
	
	/**
	 * permet de savoir si un utilisateur possédant cet email existe déjà
	 * @param email
	 * @return true si les l'email existe, sinon false
	 */
	boolean isEmailExist(String email);
}
