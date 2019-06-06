package com.al2.ddk.jee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Copy;
import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.NetflischOrder;
import com.al2.ddk.jee.repository.CopyRepository;
import com.al2.ddk.jee.repository.MovieRepository;
import com.al2.ddk.jee.service.MovieService;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

	/***/
	private final MovieRepository movieRepository;
	/***/
	private final CopyRepository copyRepository;
	/***/
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, CopyRepository copyRepository) {
		this.movieRepository = movieRepository;
		this.copyRepository = copyRepository;
	}

	/******/
	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	/******/
	@Override
	public Movie getMovie(int id) {
		return movieRepository.findById(id);
	}

	/******/
	@Override
	public Movie createMovie(String nameM, int durationM, int yearM, String descriptionM, String cover_url) {
		Movie movie = new Movie(nameM, durationM, yearM, descriptionM, cover_url);
		return movieRepository.save(movie);
	}

	/******/
	@Override
	public List<Copy> getAllCopies() {
		return copyRepository.findAll();
	}

	/******/
	@Override
	public Copy getCopy(int id) {
		return copyRepository.findById(id);
	}

	/******/
	@Override
	public List<Copy> getAllCopiesOfMovie(int idMovie) {
		return copyRepository.findAllByMovieId(idMovie);
	}

	/******/
	@Override
	public void setOrderToCopy(Copy copy, NetflischOrder order) throws Exception {
		//		if(netflischOrderService.getNetflischOrder(order.getIdO()) == null) {
		//			throw new Exception("Erreur, la commande n'existe pas");
		//		}
		if(copy.getOrder()!= null) {
			throw new Exception("Erreur, cette exemplaire appartient deja a une commande");
		}
		copy.setOrder(order);
		copyRepository.save(copy);
	}

	/******/
	@Override
	public void deleteOrderToCopy(Copy copy) throws Exception {
		if(copy.getOrder() == null) {
			throw new Exception("Erreur, cette exemplaire est deja disponnible");
		}
		copy.setOrder(null);
		copyRepository.save(copy);
	}

	/******/
	@Override
	public void addCopiesOfMovie(Movie movie) throws Exception {
		if(getMovie(movie.getIdM()) == null) {
			throw new Exception("Erreur, le film n'existe pas");
		}
		int numberOfCopy = 3;
		for(int i=0; i<numberOfCopy; i++) {
			Copy copy = new Copy();
			copy.setMovie(movie);
			copyRepository.save(copy);
		}
	}
}
