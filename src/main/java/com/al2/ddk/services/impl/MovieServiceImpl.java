package com.al2.ddk.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.al2.ddk.dao.DAOFactory;
import com.al2.ddk.model.Movie;
import com.al2.ddk.services.MovieService;

public class MovieServiceImpl implements MovieService {
	
	/***/
	public static final String SERVER = "localhost";
	/***/
	public static final String DATABASE = "Netflisch";
	/***/
	public static final String USER = "root";
	/***/
	public static final String PASSWORD = "";
	/***/
	public static final String SELECT_ALL = "SELECT * FROM movie;";

	@Override
	public List<Movie> getAllMovies() {
		
		ArrayList<Movie> allMovies = new ArrayList<>();
		DAOFactory instance = new DAOFactory(SERVER, DATABASE, USER, PASSWORD);
		instance.logIn();
		try {
			Statement statement = instance.getConnection().createStatement();
			ResultSet result= statement.executeQuery(SELECT_ALL);
			
			/** on parcours le resultset **/
			while(result.next()) {
				
				Movie movie = new Movie();
				movie.setId(result.getInt("idM"));
				movie.setName(result.getString("nameM"));
				movie.setDuration(result.getInt("duration"));
				movie.setYear(result.getInt("year"));
				movie.setCreator(result.getString("creatorM"));
				movie.setDescription(result.getString("descriptionM"));
				allMovies.add(movie);
			}
			result.close();
			statement.close();
			instance.logOut();
			
		} catch (SQLException e) {
			System.out.println("Erreur d'execution de "+SELECT_ALL);
			e.printStackTrace();
		}
		
		return allMovies;
	}

	@Override
	public Movie getMovie(String nameMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(String nameMovie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMovie(String nameMovie, String dateMovie, String creatorMovie, String descriptionMovie) {
		// TODO Auto-generated method stub
		
	}

}
