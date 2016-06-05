package services;

import data.DummyData;
import models.Actor;
import models.Comment;
import models.Movie;

import java.util.ArrayList;
import java.util.List;

public class ActorService {

    private static List<Actor> actors = DummyData.actors;
    private static List<Movie> movies = DummyData.movies;

    public Actor get(int id) {
        for(Actor a : actors) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void add(Actor actor) {
        actor.setId(Actor.getNextId());
        actors.add(actor);
    }

    public List<Movie> getMovies(Actor actor) {
        List<Movie> actorMovies = new ArrayList<>();
        for(Movie m : movies) {
            for(Actor a : m.getActors()) {
                if(a.getId() == actor.getId()) {
                    actorMovies.add(m);
                }
            }
        }
        return actorMovies;
    }

    public void assignMovie(Actor actor, Movie movie) {
        movie.getActors().add(actor);
    }
}
