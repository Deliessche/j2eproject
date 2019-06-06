package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;

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
	Movie createMovie(String nameM, int durationM, int yearM, String descriptionM, String cover_url);

	/**
	 * retourne la liste des Copies
	 * @return la liste des copies
	 */
	List<Copy> getAllCopies();

	/**
	 * retourne une Copy en fonction de son identifiant
	 * @return une Copy
	 */
	Copy getCopy(int id);
	
	/**
	 * retourne la liste des des Copy d'un Movie en fonction de son identifiant
	 * @param idMovie
	 * @return une liste de Copy
	 */
	List<Copy> getAllCopiesOfMovie(int idMovie);

	/**
	 * assossie une Copy à une commande
	 * @param order
	 * @param movie
	 */
	void setOrderToCopy(Copy copy, NetflischOrder order) throws Exception;

	/**
	 * libere l'exemplaire d'une commande
	 * @param order
	 * @param movie
	 */
	void deleteOrderToCopy(Copy copy) throws Exception;

	/**
	 * ajout les exemplaire d'un film
	 * @param movie
	 * @throws Exception
	 */
	void addCopiesOfMovie(Movie movie) throws Exception;
}
