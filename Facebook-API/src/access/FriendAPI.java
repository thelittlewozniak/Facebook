package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoFriend;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.pojo.Friend;
import model.pojo.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Path("GetFriend")
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
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateFriend")
    public Response createFriend(@FormParam("asker") String askerid,@FormParam("receiver") String receiverid,@FormParam("accepted") String accepted){
        Connection conn=GetConnection.getInstance().getConnection();
        Friend f=new Friend();
        f.setAsker(new DaoUser(conn).find(Integer.parseInt(askerid)));
        f.setReceiver(new DaoUser(conn).find(Integer.parseInt(receiverid)));
        Boolean test=new DaoFriend(conn).create(f);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
}
