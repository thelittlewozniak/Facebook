package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoComment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

@Path("Comment")
public class CommentAPI extends RestApplication {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoComment(conn).getAll()).build();
        return response;
    }
}
