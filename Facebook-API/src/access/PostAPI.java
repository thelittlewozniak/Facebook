package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.pojo.Post;
import model.pojo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Response getPost(@QueryParam("id") int id) {
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
    @Path("CreatePost")
    public Response createPost(@FormParam("data") String data,@FormParam("type") String type,@FormParam("postDate") String postDate,@FormParam("user") String userId){
        Connection conn=GetConnection.getInstance().getConnection();
        Post p=new Post();
        p.setData(data);
        p.setType(type);
        Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(postDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setPostDate(date);
        p.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        Boolean test=new DaoPost(conn).create(p);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
    @DELETE
    @Path("DeletePost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePost(@QueryParam("id")int id){
        Connection conn=GetConnection.getInstance().getConnection();
        Post p=new DaoPost(conn).find(id);
        Boolean test=new DaoPost(conn).delete(p);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        return response;
    }
    @PUT
    @Path("updatePost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@FormParam("data") String data,@FormParam("type") String type,@FormParam("postDate") String postDate,@FormParam("user") String userId){
        Connection conn=GetConnection.getInstance().getConnection();
        Post p=new Post();
        p.setData(data);
        p.setType(type);
        Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(postDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setPostDate(date);
        p.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        Boolean test=new DaoPost(conn).update(p);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        return response;
    }
}
