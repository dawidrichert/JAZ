package services;

import data.DummyData;
import models.Comment;
import models.Movie;

import java.util.List;

public class CommentService {

    private static List<Movie> movies = DummyData.movies;

    public Comment get(int id) {
        for(Movie m : movies) {
            for(Comment c : m.getComments()) {
                if(c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    public void delete(Comment comment) {
        Movie movie = getMovieForComment(comment);
        if(movie != null) {
            movie.getComments().remove(comment);
        }
    }

    private Movie getMovieForComment(Comment comment) {
        for(Movie m : movies) {
            for(Comment c : m.getComments()) {
                if(c.getId() == comment.getId()) {
                    return m;
                }
            }
        }
        return null;
    }
}
