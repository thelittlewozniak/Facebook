package access;

import model.dao.GetConnection;
import model.dao.DaoSchooling;
import model.dao.DaoUser;
import model.pojo.Schooling;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("Schooling")
public class SchoolingAPI extends RestApplication {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoSchooling(conn).getAll()).build();
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetSchooling")
    public Response getSchooling(@QueryParam("id") int id,@QueryParam("iduser") int iduser) {
        Response response=null;
        Connection conn= GetConnection.getInstance().getConnection();
        Schooling s=new DaoSchooling(conn).find(id,iduser);
        if(s!=null)
            response=Response.status(Response.Status.OK).entity(s).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateSchooling")
    public Response createSchooling(@FormParam("name") String name,@FormParam("address") String address,@FormParam("type") String type,@FormParam("beginDate") String beginDate,@FormParam("endDate") String endDate,@FormParam("graduate") String graduate,@FormParam("user") String userid){
        Connection conn=GetConnection.getInstance().getConnection();
        Schooling school=new Schooling();
        school.setName(name);
        school.setAddress(address);
        school.setType(type);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date begin=null;
        try{
            begin=dateFormat.parse(beginDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        school.setBeginDate(begin);
        Date end=null;
        try{
            end=dateFormat.parse(endDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        school.setEndDate(end);
        school.setGraduate(Boolean.parseBoolean(graduate));
        school.setUser(new DaoUser(conn).find(Integer.parseInt(userid)));
        Boolean test=new DaoSchooling(conn).create(school);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(test).build();
        return response;
    }
    @DELETE
    @Path("DeleteSchooling")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSchooling(@QueryParam("id")int id,@QueryParam("iduser") int iduser){
        Connection conn=GetConnection.getInstance().getConnection();
        Schooling school=new DaoSchooling(conn).find(id,iduser);
        Boolean test=new DaoSchooling(conn).delete(school);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        return response;
    }
    @PUT
    @Path("UpdateSchooling")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSchooling(@FormParam("schoolingId") String schoolingId,@FormParam("beginDate") String beginDate,@FormParam("endDate") String endDate,@FormParam("graduate") String graduate,@FormParam("user") String userid){
        Connection conn=GetConnection.getInstance().getConnection();
        Schooling school=new Schooling();
        school.setId(Integer.parseInt(schoolingId));
        DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date begin=null;
        try{
            begin=dateFormat.parse(beginDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        school.setBeginDate(begin);
        Date end=null;
        try{
            end=dateFormat.parse(endDate);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        school.setEndDate(end);
        school.setGraduate(Boolean.parseBoolean(graduate));
        school.setUser(new DaoUser(conn).find(Integer.parseInt(userid)));
        Boolean test=new DaoSchooling(conn).update(school);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        return response;
    }
}
