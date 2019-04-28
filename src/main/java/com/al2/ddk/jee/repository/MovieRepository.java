package com.al2.ddk.jee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.al2.ddk.jee.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	/**
	 * renvoie la liste des films
	 * @return une liste de Movie
	 */
	List<Movie> findAll();
	
	/**
	 * renvoie un film en fonction de son identifiant
	 * @param id
	 * @return un objet Movie
	 */
	@Query("SELECT m FROM Movie m WHERE m.id = :id")
	Movie findById(@Param("id") int id);
}
