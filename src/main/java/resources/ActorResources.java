package resources;

import models.Actor;
import models.Movie;
import services.ActorService;
import services.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/actors")
public class ActorResources {

    private ActorService actorService = new ActorService();
    private MovieService movieService = new MovieService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Actor actor) {
        actorService.add(actor);
        return Response.ok(actor.getId()).build();
    }

    @GET
    @Path("/{actorId}/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies(@PathParam("actorId") int actorId) {
        Actor actor = actorService.get(actorId);
        if(actor == null) {
            return null;
        }
        return actorService.getMovies(actor);
    }

    @POST
    @Path("/{actorId}/assign")
    public Response rate(@PathParam("actorId") int actorId, @QueryParam("movieId") int movieId) {
        Actor actor = actorService.get(actorId);
        if(actor == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Movie movie = movieService.get(movieId);
        if(movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        actorService.assignMovie(actor, movie);
        return Response.ok().build();
    }
}
