package com.al2.ddk.jee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.al2.ddk.jee.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	/**
	 * renvoie la liste des utilisateurs
	 * @return une liste de User
	 */
	List<User> findAll();
	
	/**
	 * renvoie un utilisateur en fonction de son id
	 * @param id
	 * @return un objet User
	 */
	@Query("SELECT u FROM User u WHERE u.id = :id")
	User findById(@Param("id") int id);
	
	/**
	 * renvoie un utilisateur en fonction de son email
	 * @param email
	 * @return un objet User
	 */
	@Query("SELECT u FROM User u WHERE u.emailU = :emailU")
	User findByEmail(@Param("emailU") String emailU);
	
	/**
	 * renvoie un utilisateur en fonction de son email et de son mot de passe
	 * @param email
	 * @param password
	 * @return un objet User
	 */
	@Query("SELECT u FROM User u WHERE u.emailU = :emailU AND u.passwordU = :passwordU")
	User findByEmailAndPassword(@Param("emailU") String emailU, @Param("passwordU") String passwordU);
}
