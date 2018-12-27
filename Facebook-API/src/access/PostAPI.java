package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoPost;
import model.pojo.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

@Path("Post")
public class PostAPI extends RestApplication{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoPost(conn).getAll()).build();
        return response;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetPost")
    public Response GetPost(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Post p=new DaoPost(conn).find(id);
        if(p!=null)
            response=Response.status(Response.Status.OK).entity(p).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("MakeAPost")
    public Response MakePost(){
        return  null;
    }
}
