package data;

import models.Actor;
import models.Comment;
import models.Movie;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DummyData {

    private static Actor actorRyanReynolds = new Actor("Ryan", "Reynolds");
    private static Actor actorMorenaBaccarin = new Actor("Morena", "Baccarin");
    private static Actor actorEdSkrein = new Actor("Ed", "Skrein");
    private static Actor actorGinaCarano = new Actor("Gina", "Carano");
    private static Actor actorGerardButler = new Actor("Gerard", "Butler");
    private static Actor actorMorganFreeman = new Actor("Morgan", "Freeman");
    private static Actor actorAaronEckhart = new Actor("Aaron", "Eckhart");

    public static List<Actor> actors = new LinkedList<>(Arrays.asList(
            actorRyanReynolds, actorMorenaBaccarin, actorEdSkrein, actorGinaCarano, actorGerardButler,
            actorMorganFreeman, actorAaronEckhart));

    public static List<Movie> movies = new LinkedList<>(Arrays.asList(
            new Movie("Deadpool", "Tim Miller", "Adventure, Action, Comedy", 2016,
                    new LinkedList<>(Arrays.asList(
                            new Comment("Great movie!", new Date(), "John"),
                            new Comment("Nice.", new Date(), "Kate"))),
                    new LinkedList<>(Arrays.asList(
                            actorRyanReynolds,
                            actorMorenaBaccarin,
                            actorEdSkrein,
                            actorGinaCarano))),
            new Movie("London Has Fallen", "Babak Najafi", "Thriller, Adventure, Action, Mystery", 2016,
                    new LinkedList<>(Arrays.asList(
                            new Comment("so nice!!!", new Date(), "Anna"),
                            new Comment("Hmmm", new Date(), "Eve"),
                            new Comment("I don't know", new Date(), "Nicolas"))),
                    new LinkedList<>(Arrays.asList(
                            actorGerardButler,
                            actorMorganFreeman,
                            actorAaronEckhart))),
            new Movie("Eddie the Eagle", "Dexter Fletcher", "Comedy", 2016),
            new Movie("Fast & Furious", "Justin Lin", "Thriller, Adventure, Action, Mystery", 2009),
            new Movie("Jumper", "Doug Liman", "Science Fiction, Thriller, Adventure, Action", 2008)));
}
