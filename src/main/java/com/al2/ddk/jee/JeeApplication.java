package com.al2.ddk.jee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.domain.User;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.service.UserService;

@SpringBootApplication
public class JeeApplication implements CommandLineRunner {

	/***/
	private final MovieService movieService;
	/***/
	private final UserService userService;

	@Autowired
	public JeeApplication(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
	}

	public static void main(String[] args) {
        SpringApplication.run(JeeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		/************* Test movieService *************/
		/** GET ALL MOVIES **/
		List<Movie> allMovies = movieService.getAllMovies();
		System.out.println("> all movies :");
		allMovies.stream()
		.forEach(m -> System.out.println("film "+m.getIdM()+" : " + m.getNameM()));
		/** GET MOVIE **/
		Movie movie = movieService.getMovie(2);
		System.out.println("> film 2 :"+movie.getNameM()+" "+movie.getYearM());
		
		/************* Test userService *************/
		/** GET ALL USERS **/
		List<User> allUsers = userService.getAllUser();
		System.out.println("> all users :");
		allUsers.stream()
		.forEach(u -> System.out.println("user "+u.getIdU()+" "+u.getFirstNameU()+" "+u.getLastNameU()));
		/** GET USER **/
		User user = userService.getUser(3);
		System.out.println("> user 3 :"+user.getFirstNameU()+" "+user.getLastNameU());
	}

}
