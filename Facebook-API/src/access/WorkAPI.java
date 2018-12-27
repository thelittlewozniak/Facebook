package access;

import jdk.nashorn.internal.parser.DateParser;
import model.BusinessLayer.GetConnection;
import model.dao.DaoPost;
import model.dao.DaoUser;
import model.dao.DaoWork;
import model.pojo.Post;
import model.pojo.Work;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("Work")
public class WorkAPI extends RestApplication {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoWork(conn).getAll()).build();
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetWork")
    public Response getWork(@QueryParam("id") int id) {
        Response response=null;
        Connection conn= GetConnection.getInstance().getConnection();
        Work w=new DaoWork(conn).find(id);
        if(w!=null)
            response=Response.status(Response.Status.OK).entity(w).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateWork")
    public Response createPost(@FormParam("name") String name,@FormParam("address") String address,@FormParam("beginDate") String beginDate,@FormParam("endDate") String endDate,@FormParam("user") String userId,@FormParam("jobTitle" ) String jobTitle){
        Connection conn=GetConnection.getInstance().getConnection();
        Work w=new Work();
        w.setName(name);
        w.setAddress(address);
        w.setJobTitle(jobTitle);
        w.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        Date begin=null;
        try{
            begin=new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        w.setBeginDate(begin);
        Date end=null;
        try{
            end=new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        w.setEndDate(end);
        Boolean test=new DaoWork(conn).create(w);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
    @DELETE
    @Path("DeleteWork")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePost(@QueryParam("id")int id){
        Connection conn=GetConnection.getInstance().getConnection();
        Work w=new DaoWork(conn).find(id);
        Boolean test=new DaoWork(conn).delete(w);
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
