package com.al2.ddk.jee.rest;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.repository.MovieRepository;
import com.al2.ddk.jee.repository.UserRepository;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    private MovieService movieService;

    /***/
    public MovieResource(MovieRepository movieRepository, MovieService movieService) {
        this.movieService = movieService;
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
}
