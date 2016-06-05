package resources;

import models.Comment;
import services.CommentService;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/comments")
public class CommentResources {

    private CommentService commentService = new CommentService();

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Comment comment = commentService.get(id);
        if(comment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        commentService.delete(comment);
        return Response.ok().build();
    }
}
