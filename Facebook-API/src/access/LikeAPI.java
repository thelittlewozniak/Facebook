package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoLike;
import model.dao.DaoPost;
import model.pojo.Like;
import model.pojo.Post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

@Path("Like")
public class LikeAPI extends RestApplication {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoLike(conn).getAll()).build();
        return response;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getLike")
    public Response getPost(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Like l=new DaoLike(conn).find(id);
        if(l!=null)
            response=Response.status(Response.Status.OK).entity(l).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    
}
