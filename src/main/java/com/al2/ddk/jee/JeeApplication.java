package com.al2.ddk.jee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.service.MovieService;

@SpringBootApplication
public class JeeApplication implements CommandLineRunner {

	private final MovieService movieService;

	@Autowired
	public JeeApplication(MovieService movieService) {
		this.movieService = movieService;
	}

	public static void main(String[] args) {
        SpringApplication.run(JeeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		List<Movie> allMovies = movieService.getAllMovies();
		Movie movie = movieService.getMovie(2);
		
		System.out.println("> all movies :");
		allMovies.stream()
		.forEach(m -> System.out.println("film "+m.getIdM()+" : " + m.getNameM()));
		System.out.println("> film 2 :"+movie.getNameM());
	}

}
