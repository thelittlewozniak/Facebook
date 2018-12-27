package access;

import com.sun.org.apache.xpath.internal.operations.Bool;
import model.BusinessLayer.GetConnection;
import model.dao.DaoUser;
import model.pojo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("User")
public class UserAPI extends RestApplication{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetAll")
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response= Response.status(Response.Status.OK).entity(new DaoUser(conn).getAll()).build();
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("GetUser")
    public Response getUser(@QueryParam("id") int id) {
        Response response=null;
        Connection conn=GetConnection.getInstance().getConnection();
        User u=new DaoUser(conn).find(id);
        if(u!=null)
            response=Response.status(Response.Status.OK).entity(u).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateUser")
    public Response createUser(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("email") String email,@FormParam("password") String password,@FormParam("address") String address,@FormParam("birthday") String birthday,@FormParam("registerDate") String registerDate,@FormParam("relationship") String relationship,@FormParam("phoneNumber") String phoneNumber,@FormParam("gender") String gender,@FormParam("interestedIn") String interestedIn){
        Connection conn=GetConnection.getInstance().getConnection();
        User u=new User();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setEmail(email);
        u.setPassword(password);
        u.setAddress(address);
        Date birth=null;
        try {
            birth=new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.setBirthday(birth);
        Date register=null;
        try {
            register=new SimpleDateFormat("dd/MM/yyyy").parse(registerDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.setRegisterDate(register);
        u.setRelationship(Boolean.parseBoolean(relationship));
        u.setPhoneNumber(Integer.parseInt(phoneNumber));
        u.setGender(Boolean.parseBoolean(gender));
        u.setInterestedIn(Boolean.parseBoolean(interestedIn));
        Boolean test=new DaoUser(conn).create(u);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(u).build();
        return response;
    }
    @DELETE
    @Path("DeleteUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@QueryParam("id")int id){
        Connection conn=GetConnection.getInstance().getConnection();
        User u=new DaoUser(conn).find(id);
        Boolean test=new DaoUser(conn).delete(u);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        return response;
    }
    @PUT
    @Path("UpdateUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@FormParam("firstname") String firstname,@FormParam("lastname") String lastname,@FormParam("email") String email,@FormParam("password") String password,@FormParam("address") String address,@FormParam("birthday") String birthday,@FormParam("registerDate") String registerDate,@FormParam("relationship") String relationship,@FormParam("phoneNumber") String phoneNumber,@FormParam("gender") String gender,@FormParam("interestedIn") String interestedIn){
        Connection conn=GetConnection.getInstance().getConnection();
        User u=new User();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setEmail(email);
        u.setPassword(password);
        u.setAddress(address);
        Date birth=null;
        try {
            birth=new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.setBirthday(birth);
        Date register=null;
        try {
            register=new SimpleDateFormat("dd/MM/yyyy").parse(registerDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        u.setRegisterDate(register);
        u.setRelationship(Boolean.parseBoolean(relationship));
        u.setPhoneNumber(Integer.parseInt(phoneNumber));
        u.setGender(Boolean.parseBoolean(gender));
        u.setInterestedIn(Boolean.parseBoolean(interestedIn));
        Boolean test=new DaoUser(conn).update(u);
        Response response=null;
        if(test)
            response=Response.status(Response.Status.OK).entity(test).build();
        else
            response=Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        return response;
    }
}
