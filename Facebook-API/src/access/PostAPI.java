package access;

import model.dao.DaoPost;
import model.dao.DaoUser;
import model.dao.GetConnection;
import model.pojo.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("Post")
public class PostAPI extends RestApplication {
  private Connection conn;
  private Response response;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoPost(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetPost")
  public Response getPost(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Post p = new DaoPost(conn).find(id);
    if (p != null) response = Response.status(Response.Status.OK).entity(p).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreatePost")
  public Response createPost(
      @FormParam("data") String data,
      @FormParam("type") String type,
      @FormParam("postDate") String postDate,
      @FormParam("user") String userId) {
    conn = GetConnection.getInstance().getConnection();
    Post p = new Post();
    p.setData(data);
    p.setType(type);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date date = null;
    try {
      date = dateFormat.parse(postDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    p.setPostDate(date);
    p.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    Boolean test = new DaoPost(conn).create(p);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(test).build();
    return response;
  }

  @DELETE
  @Path("DeletePost")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deletePost(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Post p = new DaoPost(conn).find(id);
    boolean test = new DaoPost(conn).delete(p);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdatePost")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updatePost(
      @FormParam("postid") String postid,
      @FormParam("data") String data,
      @FormParam("type") String type,
      @FormParam("postDate") String postDate,
      @FormParam("user") String userId) {
    conn = GetConnection.getInstance().getConnection();
    Post p = new Post();
    p.setId(Integer.parseInt(postid));
    p.setData(data);
    p.setType(type);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date date = null;
    try {
      date = dateFormat.parse(postDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    p.setPostDate(date);
    p.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    boolean test = new DaoPost(conn).update(p);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
