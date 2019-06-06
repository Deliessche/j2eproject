package com.al2.ddk.jee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.al2.ddk.jee.domain.Copy;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Integer>{

	/**
	 * renvoie la liste des Copy
	 * @return une liste de Copy
	 */
	List<Copy> findAll();

	/**
	 * renvoie une Copy en fonction de son id
	 * @param id
	 * @return un objet Copy
	 */
	@Query("SELECT c FROM Copy c WHERE c.id = :id")
	Copy findById(@Param("id") int id);
	
	/**
	 * renvoie la liste des des Copy d'un Movie en fonction de son id
	 * @param id
	 * @return une liste de Copy
	 */
	@Query("SELECT c FROM Copy c WHERE c.movie.id = :id")
	List<Copy> findAllByMovieId(@Param("id") int id);
}
