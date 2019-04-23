package com.al2.ddk.jee.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.repository.MovieRepository;
import com.al2.ddk.jee.service.MovieService;
@Service("MovieService")
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;
	
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}



	@Override
	public List<Movie> findAll() {
		
		return movieRepository.findAllById(1);
		
//		return Collections.emptyList();
	}

}
