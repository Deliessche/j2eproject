package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Movie;

@Service
public interface MovieService {

	/**
	 * retourne la liste des films
	 * @return une liste de Movie
	 */
	List<Movie> getAllMovies();
	
	/**
	 * retourne un film en fonction de son identifiant
	 * @param id
	 * @return un Movie
	 */
	Movie getMovie(int id);

	/**
	 * crée un nouveau film
	 * @param nameM
	 * @param durationM
	 * @param yearM
	 * @param descriptionM
	 * @param cover_url
	 */
	void createMovie(String nameM, int durationM, int yearM, String descriptionM, String cover_url);
}
