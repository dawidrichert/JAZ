package resources;

import models.Actor;
import models.Comment;
import models.Movie;
import services.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movies")
public class MovieResources {

    private MovieService movieService = new MovieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Movie movie = movieService.get(id);
        if(movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(movie).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Movie movie) {
        movieService.add(movie);
        return Response.ok(movie.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Movie movie) {
        if(movieService.get(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        movie.setId(id);
        movieService.update(movie);
        return Response.ok().build();
    }

    @GET
    @Path("/{movieId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments(@PathParam("movieId") int movieId) {
        Movie movie = movieService.get(movieId);
        if(movie == null) {
            return null;
        }
        return movie.getComments();
    }

    @POST
    @Path("/{movieId}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("movieId") int movieId, Comment comment) {
        Movie movie = movieService.get(movieId);
        if(movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        comment.setId(Comment.getNextId());
        movie.getComments().add(comment);
        return Response.ok(comment.getId()).build();
    }

    @POST
    @Path("/{movieId}/rate")
    public Response rate(@PathParam("movieId") int movieId, @QueryParam("value") int value) {
        Movie movie = movieService.get(movieId);
        if(movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if(value < 0 || value > 10) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        movie.addRatingsValue(value);
        return Response.ok().build();
    }

    @GET
    @Path("/{movieId}/actors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Actor> getActors(@PathParam("movieId") int movieId) {
        Movie movie = movieService.get(movieId);
        if(movie == null) {
            return null;
        }
        return movie.getActors();
    }
}
