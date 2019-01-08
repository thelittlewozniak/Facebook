package access;

import model.dao.DaoFriend;
import model.dao.DaoUser;
import model.dao.GetConnection;
import model.pojo.Friend;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

@Path("Friend")
public class FriendAPI extends RestApplication {
  private Response response;
  private Connection conn;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoFriend(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetFriend")
  public Response getFriend(
      @QueryParam("asker") int idasker, @QueryParam("receiver") int idreceiver) {
    conn = GetConnection.getInstance().getConnection();
    Friend f = new DaoFriend(conn).find(idasker, idreceiver);
    if (f != null) response = Response.status(Response.Status.OK).entity(f).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreateFriend")
  public Response createFriend(
      @FormParam("asker") String askerid,
      @FormParam("receiver") String receiverid,
      @FormParam("accepted") String accepted) {
    conn = GetConnection.getInstance().getConnection();
    Friend f = new Friend();
    f.setAsker(new DaoUser(conn).find(Integer.parseInt(askerid)));
    f.setReceiver(new DaoUser(conn).find(Integer.parseInt(receiverid)));
    f.setAccepted(Boolean.parseBoolean(accepted));
    Boolean test = new DaoFriend(conn).create(f);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(test).build();
    return response;
  }

  @DELETE
  @Path("DeleteFriend")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteFriend(
      @QueryParam("asker") int askerid, @QueryParam("receiver") int receiverid) {
    conn = GetConnection.getInstance().getConnection();
    Friend p = new DaoFriend(conn).find(askerid, receiverid);
    boolean test = new DaoFriend(conn).delete(p);
    Response response;
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdateFriend")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateFriend(
      @FormParam("asker") String askerid,
      @FormParam("receiver") String receiverid,
      @FormParam("accepted") String accepted) {
    conn = GetConnection.getInstance().getConnection();
    Friend f = new Friend();
    f.setAsker(new DaoUser(conn).find(Integer.parseInt(askerid)));
    f.setReceiver(new DaoUser(conn).find(Integer.parseInt(receiverid)));
    f.setAccepted(Boolean.parseBoolean(accepted));
    boolean test = new DaoFriend(conn).update(f);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
