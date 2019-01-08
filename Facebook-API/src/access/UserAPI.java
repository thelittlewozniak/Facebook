package access;

import model.dao.DaoUser;
import model.dao.GetConnection;
import model.pojo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("User")
public class UserAPI extends RestApplication {

  private Response response;
  private Connection conn;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoUser(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetUser")
  public Response getUser(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    User u = new DaoUser(conn).find(id);
    if (u != null) response = Response.status(Response.Status.OK).entity(u).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreateUser")
  public Response createUser(
      @FormParam("firstname") String firstname,
      @FormParam("lastname") String lastname,
      @FormParam("email") String email,
      @FormParam("password") String password,
      @FormParam("address") String address,
      @FormParam("birthday") String birthday,
      @FormParam("registerDate") String registerDate,
      @FormParam("relationship") String relationship,
      @FormParam("phoneNumber") String phoneNumber,
      @FormParam("gender") String gender,
      @FormParam("interestedIn") String interestedIn) {
    conn = GetConnection.getInstance().getConnection();
    User u = new User();
    u.setFirstname(firstname);
    u.setLastname(lastname);
    u.setEmail(email);
    u.setPassword(password);
    u.setAddress(address);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date birth = null;
    try {
      birth = dateFormat.parse(birthday);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    u.setBirthday(birth);
    Date register = null;
    try {
      register = dateFormat.parse(registerDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    u.setRegisterDate(register);
    u.setRelationship(Boolean.parseBoolean(relationship));
    u.setPhoneNumber(Integer.parseInt(phoneNumber));
    u.setGender(Boolean.parseBoolean(gender));
    u.setInterestedIn(Boolean.parseBoolean(interestedIn));
    boolean test = new DaoUser(conn).create(u);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(u).build();
    return response;
  }

  @DELETE
  @Path("DeleteUser")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUser(@QueryParam("id") int id) {
    conn = GetConnection.getInstance().getConnection();
    User u = new DaoUser(conn).find(id);
    boolean test = new DaoUser(conn).delete(u);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdateUser")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateUser(
      @FormParam("userid") String userid,
      @FormParam("firstname") String firstname,
      @FormParam("lastname") String lastname,
      @FormParam("email") String email,
      @FormParam("password") String password,
      @FormParam("address") String address,
      @FormParam("birthday") String birthday,
      @FormParam("registerDate") String registerDate,
      @FormParam("relationship") String relationship,
      @FormParam("phoneNumber") String phoneNumber,
      @FormParam("gender") String gender,
      @FormParam("interestedIn") String interestedIn) {
    conn = GetConnection.getInstance().getConnection();
    User u = new User();
    u.setId(Integer.parseInt(userid));
    u.setFirstname(firstname);
    u.setLastname(lastname);
    u.setEmail(email);
    u.setPassword(password);
    u.setAddress(address);
    Date birth = null;
    try {
      birth = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(birthday);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    u.setBirthday(birth);
    Date register = null;
    try {
      register = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(registerDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    u.setRegisterDate(register);
    u.setRelationship(Boolean.parseBoolean(relationship));
    u.setPhoneNumber(Integer.parseInt(phoneNumber));
    u.setGender(Boolean.parseBoolean(gender));
    u.setInterestedIn(Boolean.parseBoolean(interestedIn));
    boolean test = new DaoUser(conn).update(u);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
