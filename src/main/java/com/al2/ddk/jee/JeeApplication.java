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
		
		List<Movie> findAll = movieService.findAll();
		
		findAll.stream()
		.forEach(m -> System.out.println("nom: " + m.getNameM()));
//		System.out.println("> getAllMovies()");
//        List<Movie> allMovies = movieService.getAllMovies();
//        System.out.println("< getAllMovies()");
//        for(Movie movie : allMovies) {
//        	System.out.println("movie 1 : "+movie.getName());
//        }
	}

}
