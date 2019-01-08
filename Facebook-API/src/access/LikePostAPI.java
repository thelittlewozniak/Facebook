package access;

import model.dao.DaoLikePost;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.dao.GetConnection;
import model.pojo.Like;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("LikePost")
public class LikePostAPI extends RestApplication {
  private Connection conn;
  private Response response;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoLikePost(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("getLike")
  public Response getLike(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Like l = new DaoLikePost(conn).find(id);
    if (l != null) response = Response.status(Response.Status.OK).entity(l).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreateLike")
  public Response createLike(
      @FormParam("dateLiked") String dateLike,
      @FormParam("user") String userId,
      @FormParam("post") String postId) {
    conn = GetConnection.getInstance().getConnection();
    Like l = new Like();
    l.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date date = null;
    try {
      date = dateFormat.parse(dateLike);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    l.setDateLiked(date);
    l.setPost(new DaoPost(conn).find(Integer.parseInt(postId)));
    boolean test = new DaoLikePost(conn).create(l);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }

  @DELETE
  @Path("DeleteLike")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteLike(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Like l = new DaoLikePost(conn).find(id);
    boolean test = new DaoLikePost(conn).delete(l);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdateLike")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateLike(
      @FormParam("id") String idLike,
      @FormParam("dateLiked") String dateLike,
      @FormParam("user") String userId,
      @FormParam("post") String postId) {
    conn = GetConnection.getInstance().getConnection();
    Like l = new Like();
    l.setId(Integer.parseInt(idLike));
    l.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    Date date = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    try {
      date = dateFormat.parse(dateLike);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    l.setDateLiked(date);
    l.setPost(new DaoPost(conn).find(Integer.parseInt(postId)));
    boolean test = new DaoLikePost(conn).update(l);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
