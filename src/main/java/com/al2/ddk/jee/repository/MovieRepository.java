package com.al2.ddk.jee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.al2.ddk.jee.domain.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query("SELECT m FROM Movie m WHERE m.id = :id")
	List<Movie> findAllById(@Param("id") int id);
}
