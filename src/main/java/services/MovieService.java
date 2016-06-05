package services;

import data.DummyData;
import models.Movie;

import java.util.List;

public class MovieService {

    private static List<Movie> movies = DummyData.movies;

    public List<Movie> getAll() {
        return movies;
    }

    public Movie get(int id) {
        for(Movie m : movies) {
            if(m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void add(Movie movie) {
        movie.setId(Movie.getNextId());
        movies.add(movie);
    }

    public void update(Movie movie) {
        for (Movie m : movies) {
            if(m.getId() == movie.getId()) {
                m.setName(movie.getName());
                m.setDirector(movie.getDirector());
                m.setGenres(movie.getGenres());
                m.setYear(movie.getYear());
            }
        }
    }

    public void delete(Movie movie) {
        movies.remove(movie);
    }
}
