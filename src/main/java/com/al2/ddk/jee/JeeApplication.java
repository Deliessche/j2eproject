package com.al2.ddk.jee;

import java.util.List;

import com.al2.ddk.jee.api.MovieDB;
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
	/***/
	private final MovieDB movieDB;

	@Autowired
	public JeeApplication(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
		movieDB = new MovieDB(movieService);
	}

	public static void main(String[] args) {
        SpringApplication.run(JeeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

//		//MovieDB.insertMoviesByGenre(28);
//		/************* Test movieService *************/
//		/** GET ALL MOVIES **/
//		List<Movie> allMovies = movieService.getAllMovies();
//		System.out.println("> all movies :");
//		allMovies.stream()
//		.forEach(m -> System.out.println("film "+m.getIdM()+" : " + m.getNameM()));
//		/** GET MOVIE **/
//		Movie movie = movieService.getMovie(2);
//		System.out.println("> film 2 :"+movie.getNameM()+" "+movie.getYearM());
//		
//		/************* Test userService *************/
//		/** GET ALL USERS **/
//		List<User> allUsers = userService.getAllUser();
//		System.out.println("> all users :");
//		allUsers.stream()
//		.forEach(u -> System.out.println("user "+u.getIdU()+" "+u.getFirstNameU()+" "+u.getLastNameU()));
//		/** GET USER **/
//		User user = userService.getUser(3);
//		System.out.println("> user (by id) 3 : "+user.getFirstNameU()+" "+user.getLastNameU());
//		/** GET USER (BY EMAIL) **/
//		User user2 = userService.getUser("angelo.deliessche@gmail.com");
//		System.out.println("> user (by email) 2 : "+user2.getFirstNameU()+" "+user2.getLastNameU());
//		/** GET USER (BY EMAIL AND PASSWORD) **/
//		User user3 = userService.getUser(1);
//		System.out.println("> user (by id) 1 : "+user3.getFirstNameU()+" "+user3.getLastNameU());
//		/** IS CREDENTIAL VALID OR NOT **/
//		boolean existOrNot = userService.isValidAccount(user3.getEmailU(), user3.getPasswordU());
//		System.out.println("> le compte de "+user3.getFirstNameU()+" existe t-il ? "+existOrNot);
//		existOrNot = userService.isValidAccount("test@test.fr", "test");
//		System.out.println("> le compte de test@test.fr existe t-il ? "+existOrNot);
//		/** SET PASSWORD **/
//		// userService.setPassword(user.getIdU(), "newtest4");
//		/** CREATE USER **/
//		// user3.setIdU(null);
//		// userService.createUser(user3);
//		/** DELETE USER **/
//		// userService.deleteUser(6);
	}

}
