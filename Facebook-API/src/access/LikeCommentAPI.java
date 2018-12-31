package access;

import model.dao.GetConnection;
import model.dao.*;
import model.pojo.Like;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("LikeComment")
public class LikeCommentAPI extends RestApplication {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoLikeComment(conn).getAll()).build();
        return response;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getLike")
    public Response getLike(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        Like l=new DaoLikeComment(conn).find(id);
        if(l!=null)
            response=Response.status(Response.Status.OK).entity(l).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateLike")
    public Response createLike(@FormParam("dateLiked") String dateLike,@FormParam("user") String userId,@FormParam("comment") String commentid){
        Connection conn=GetConnection.getInstance().getConnection();
        Like l=new Like();
        l.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(dateLike);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        l.setDateLiked(date);
        l.setComment(new DaoComment(conn).find(Integer.parseInt(commentid)));
        Boolean test=new DaoLikeComment(conn).create(l);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
    @DELETE
    @Path("DeleteLike")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLike(@QueryParam("id")int id){
        Connection conn=GetConnection.getInstance().getConnection();
        Like l=new DaoLikeComment(conn).find(id);
        Boolean test=new DaoLikeComment(conn).delete(l);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        return response;
    }
    @PUT
    @Path("UpdateLike")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLike(@FormParam("id") String idLike,@FormParam("dateLiked") String dateLike,@FormParam("user") String userId,@FormParam("comment") String commentid){
        Connection conn=GetConnection.getInstance().getConnection();
        Like l=new Like();
        l.setId(Integer.parseInt(idLike));
        l.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
        Date date=null;
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(dateLike);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        l.setDateLiked(date);
        l.setComment(new DaoComment(conn).find(Integer.parseInt(commentid)));
        Boolean test=new DaoLikeComment(conn).update(l);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        return response;
    }
}
