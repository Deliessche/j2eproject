package com.al2.ddk.jee.api;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.al2.ddk.jee.domain.Movie;
import com.al2.ddk.jee.service.MovieService;
import com.al2.ddk.jee.utils.JsonReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Component
public class MovieDB {

    private static MovieService movieService;

    public MovieDB(MovieService movieService) {
        this.movieService = movieService;
    }

    public static JsonObject getMoviesByGenre(int id) {
        JsonReader reader = new JsonReader("/3/discover/movie","&with_genres="+id);
        return reader.getResult();
    }

    public static void fillAndAdd(String id) {
        JsonReader reader = new JsonReader("/3/movie/"+id);
        JsonObject movie = reader.getResult();
        int runtime = 0;
        if (!movie.get("runtime").isJsonNull()) {
            runtime = movie.get("runtime").getAsInt();
        }
        try {
			Movie newMovie = movieService.createMovie(
			        movie.get("original_title").getAsString(),
			        runtime,
			        Integer.parseInt(movie.get("release_date").getAsString().substring(0,4)),
			        movie.get("overview").getAsString(),
			        movie.get("poster_path").getAsString()
			);
			movieService.addCopiesOfMovie(newMovie);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


    public static void insertMoviesByGenre(int genre) {
        JsonObject movies = getMoviesByGenre(genre);
        JsonArray moviesToRequest = movies.getAsJsonArray("results");
        for (JsonElement movie : moviesToRequest) {
            JsonObject movieToParse = movie.getAsJsonObject();
            fillAndAdd(movieToParse.get("id").getAsString());
        }
    }
    
    /**
     * Fire at 23:30 PM on the last day of every month
     */
    /*@Scheduled(cron = "0 30 23 L * ?")
    public void go() {
    	insertMoviesByGenre(28);
    }*/
}
