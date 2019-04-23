package com.al2.ddk.jee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.al2.ddk.jee.domain.Movie;

@Service
public interface MovieService {

	
	List<Movie> findAll();
}
