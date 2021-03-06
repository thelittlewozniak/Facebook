package access;

import model.dao.DaoComment;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.dao.GetConnection;
import model.pojo.Comment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("Comment")
public class CommentAPI extends RestApplication {
  private Response response;
  private Connection conn;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoComment(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetComment")
  public Response getComment(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Comment c = new DaoComment(conn).find(id);
    if (c != null) response = Response.status(Response.Status.OK).entity(c).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreateComment")
  public Response CreateComment(
      @FormParam("data") String data,
      @FormParam("type") String type,
      @FormParam("postDate") String postDate,
      @FormParam("user") String userId,
      @FormParam("post") String postId) {
    conn = GetConnection.getInstance().getConnection();
    Comment c = new Comment();
    c.setData(data);
    c.setType(type);
    Date date = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    try {
      date = dateFormat.parse(postDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    c.setPostDate(date);
    c.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    c.setPost(new DaoPost(conn).find(Integer.parseInt(postId)));
    Boolean test = new DaoComment(conn).create(c);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(test).build();
    return response;
  }

  @DELETE
  @Path("DeleteComment")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteComment(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    Comment c = new DaoComment(conn).find(id);
    boolean test = new DaoComment(conn).delete(c);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdateComment")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateComment(
      @FormParam("commentId") String commentId,
      @FormParam("data") String data,
      @FormParam("type") String type,
      @FormParam("postDate") String postDate,
      @FormParam("user") String userId,
      @FormParam("post") String postId) {
    conn = GetConnection.getInstance().getConnection();
    Comment c = new Comment();
    c.setId(Integer.parseInt(commentId));
    c.setData(data);
    c.setType(type);
    Date date = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    try {
      date = dateFormat.parse(postDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    c.setPostDate(date);
    c.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    c.setPost(new DaoPost(conn).find(Integer.parseInt(postId)));
    boolean test = new DaoComment(conn).update(c);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
