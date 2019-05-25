package com.al2.ddk.jee.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.test.context.junit4.SpringRunner;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.repository.MovieRepository;
import com.al2.ddk.jee.service.impl.MovieServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieServiceImpl movieService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnAllMovies() {
		// Given
		List<Movie> movies = new ArrayList<Movie>();
		Movie movie = new Movie();
		movies.add(movie);
		// When
		when(movieService.getAllMovies()).thenReturn(movies);
		// Then
		assertTrue("lists should be equals", movieService.getAllMovies().equals(movies));
	}

	@Test
	public void shouldReturnEmptyListMovie() {
		// When
		when(movieService.getAllMovies()).thenReturn(Collections.emptyList());
		// Then
		assertTrue("list should be empty", movieService.getAllMovies().isEmpty());
	}

	@Test
	public void shouldReturnMovieById() {
		// Given
		Movie movie = new Movie();
		// When
		when(movieService.getMovie(anyInt())).thenReturn(movie);
		// Then
		assertTrue("movies should be equals", movieService.getMovie(anyInt()).equals(movie));
	}

	@Test
	public void shouldNotReturnMovieById() {
		// When
		when(movieService.getMovie(anyInt())).thenReturn(null);
		// Then
		assertTrue("movies should be equals", movieService.getMovie(anyInt()) == null);
	}
}
