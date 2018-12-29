package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoFriend;
import model.dao.DaoUser;
import model.pojo.Friend;

import javax.ws.rs.*;
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
    @Path("GetFriend")
    public Response getFriend(@QueryParam("asker") int idasker,@QueryParam("receiver") int idreceiver) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Friend f=new DaoFriend(conn).find(idasker,idreceiver);
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
        f.setAccepted(Boolean.parseBoolean(accepted));
        Boolean test=new DaoFriend(conn).create(f);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
    @DELETE
    @Path("DeleteFriend")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFriend(@QueryParam("id")int id){
        Connection conn=GetConnection.getInstance().getConnection();
        Friend p=new DaoFriend(conn).find(id);
        Boolean test=new DaoFriend(conn).delete(p);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        return response;
    }
    @PUT
    @Path("UpdatePost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@FormParam("asker") String askerid,@FormParam("receiver") String receiverid,@FormParam("accepted") String accepted){
        Connection conn=GetConnection.getInstance().getConnection();
        Friend f=new Friend();
        f.setAsker(new DaoUser(conn).find(Integer.parseInt(askerid)));
        f.setReceiver(new DaoUser(conn).find(Integer.parseInt(receiverid)));
        Boolean test=new DaoFriend(conn).update(f);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        return response;
    }
}
