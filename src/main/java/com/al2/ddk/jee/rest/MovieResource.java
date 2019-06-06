package com.al2.ddk.jee.rest;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.exception.NetflischException;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.repository.MovieRepository;
import com.al2.ddk.jee.repository.UserRepository;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieResource {

	/***/
	private final Logger log = LoggerFactory.getLogger(MovieResource.class);
	/***/
	@Autowired
	private MovieRepository movieRepository;
	/***/
	@Autowired
	private CopyRepository copyRepository;
	/***/
	private MovieService movieService;

	/***/
	public MovieResource(MovieRepository movieRepository, CopyRepository copyRepository, MovieService movieService) {
		this.movieService = movieService;
		this.copyRepository = copyRepository;
		this.movieRepository = movieRepository;
	}

	/**
	 * retourne toute la liste des films disponibles
	 * @return une liste de films
	 */
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		List<Movie> allMovies = movieService.getAllMovies();
		return allMovies;
	}

	/**
	 * retourne un film
	 * @param id
	 * @return un film
	 * @throws NetflischException
	 */
	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable int id) throws NetflischException {
		Movie movie = movieService.getMovie(id);
		if(movie == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Ce film n'existe pas");
		} else {
			return movie;
		}
	}

	/**
	 * retourne toute la liste d'exemplaire d'un film
	 * @param idMovie
	 * @return une liste de copies
	 */
	@GetMapping("/movies/{id}/copies")
	public List<Copy> getAllCopiesForMovie(@PathVariable int id){
		List<Copy> copies = movieService.getAllCopiesOfMovie(id);
		return copies;
	}

	/**
	 * retourne tous les exemplaires des films de Netflisch
	 * @return les copies
	 */
	@GetMapping("/movies/copies")
	public List<Copy> getAllCopies(){
		List<Copy> copies = movieService.getAllCopies();
		return copies;
	}

	/**
	 * retourne un exemplaire d'un film Netflisch
	 * @param id
	 * @return une Copy
	 * @throws NetflischException
	 */
	@GetMapping("/movies/copies/{id}")
	public Copy getCopyById(@PathVariable int id) throws NetflischException {
		Copy copy = movieService.getCopy(id);
		if(copy == null) {
			throw new NetflischException(HttpStatus.NOT_FOUND.value(), "Cet exemplaire n'existe pas");
		} else {
			return copy;
		}
	}
	
	// TODO 2 methode séparé pour retirer/ajouter la commande ? ou alors juste 1 methode pour update directement
}
