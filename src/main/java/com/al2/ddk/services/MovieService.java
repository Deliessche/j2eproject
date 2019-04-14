package com.al2.ddk.services;

import java.util.List;

import com.al2.ddk.model.Movie;

public interface MovieService {
	
	/**
	 * retourne la liste de tous les films
	 * @return liste de Movie
	 */
	public List<Movie> getAllMovies();
	
	/**
	 * retourne un film a partir de son nom
	 * @param nameMovie
	 * @return Movie
	 */
	public Movie getMovie(String nameMovie);
	
	/**
	 * supprime un film a partir de son nom
	 * @param nameMovie
	 */
	public void deleteMovie(String nameMovie);
	
	/**
	 * creer un film
	 * @param nameMovie
	 * @param dateMovie
	 * @param creatorMovie
	 * @param descriptionMovie
	 */
	public void createMovie(String nameMovie, String dateMovie, String creatorMovie, String descriptionMovie);
}
