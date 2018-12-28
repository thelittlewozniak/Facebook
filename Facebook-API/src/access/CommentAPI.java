package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoComment;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.pojo.Comment;
import model.pojo.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetComment")
    public Response getComment(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Comment c=new DaoComment(conn).find(id);
        if(c!=null)
            response=Response.status(Response.Status.OK).entity(c).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateComment")
    public Response CreateComment(@FormParam("data") String data,@FormParam("type") String type,@FormParam("postDate") String postDate,@FormParam("user") String userId,@FormParam("post") String postId){
        Connection conn=GetConnection.getInstance().getConnection();
        Comment c=new Comment();
        c.setData(data);
        c.setType(type);
        Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(postDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setPostDate(date);
        c.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        c.setPost(new DaoPost(conn).find(Integer.parseInt(postId)));
        Boolean test=new DaoComment(conn).create(c);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
}
