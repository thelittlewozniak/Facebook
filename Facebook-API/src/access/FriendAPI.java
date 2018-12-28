package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoFriend;
import model.dao.DaoPost;
import model.pojo.Friend;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

@Path("Friend")
public class FriendAPI extends RestApplication {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoFriend(conn).getAll()).build();
        return response;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getFriend")
    public Response getFriend(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Friend f=new DaoFriend(conn).find(id);
        if(f!=null)
            response=Response.status(Response.Status.OK).entity(f).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
}
