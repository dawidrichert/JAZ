package models;

import java.util.LinkedList;
import java.util.List;

public class Movie {

    private static int idCounter = 1;

    private int id;
    private String name;
    private String director;
    private String genres;
    private int year;
    private List<Comment> comments;
    private List<Actor> actors;
    private List<Integer> ratings;
    private float rating;

    public Movie() { }

    public Movie(String name, String director, String genres, int year) {
        this(name, director, genres, year, new LinkedList<>(), new LinkedList<>());
    }

    public Movie(String name, String director, String genres, int year, List<Comment> comments, List<Actor> actors) {
        this.id = getNextId();
        this.name = name;
        this.director = director;
        this.genres = genres;
        this.year = year;
        this.comments = comments;
        this.actors = actors;
        this.ratings = new LinkedList<>();
        this.rating = 0;
    }

    public static int getNextId() {
        return idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getRating() {
        if(ratings.size() == 0) {
            return 0;
        }
        float total = 0;
        for(int rating : this.ratings) {
            total += rating;
        }
        return total / ratings.size();
    }

    public void addRatingsValue(int value) {
        this.ratings.add(value);
    }
}
