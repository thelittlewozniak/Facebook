package access;

import model.dao.DaoUser;
import model.dao.DaoWork;
import model.dao.GetConnection;
import model.pojo.Work;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("Work")
public class WorkAPI extends RestApplication {
  private Connection conn;
  private Response response;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetAll")
  public Response getAll() {
    conn = GetConnection.getInstance().getConnection();
    response = Response.status(Response.Status.OK).entity(new DaoWork(conn).getAll()).build();
    return response;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("GetWork")
  public Response getWork(@QueryParam("company") int id, @QueryParam("user") int userid) {
    conn = GetConnection.getInstance().getConnection();
    Work w = new DaoWork(conn).find(id, userid);
    if (w != null) response = Response.status(Response.Status.OK).entity(w).build();
    else response = Response.status(Response.Status.NO_CONTENT).entity(null).build();
    return response;
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("CreateWork")
  public Response createWork(
      @FormParam("name") String name,
      @FormParam("address") String address,
      @FormParam("beginDate") String beginDate,
      @FormParam("endDate") String endDate,
      @FormParam("user") String userId,
      @FormParam("jobTitle") String jobTitle) {
    conn = GetConnection.getInstance().getConnection();
    Work w = new Work();
    w.setName(name);
    w.setAddress(address);
    w.setJobTitle(jobTitle);
    w.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    Date begin = null;
    try {
      begin = dateFormat.parse(beginDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    w.setBeginDate(begin);
    Date end = null;
    try {
      end = dateFormat.parse(beginDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    w.setEndDate(end);
    Boolean test = new DaoWork(conn).create(w);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(test).build();
    return response;
  }

  @DELETE
  @Path("DeleteWork")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteWork(@QueryParam("user") int id, @QueryParam("company") int idCompany) {
    conn = GetConnection.getInstance().getConnection();
    Work w = new DaoWork(conn).find(idCompany, id);
    boolean test = new DaoWork(conn).delete(w);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
    return response;
  }

  @PUT
  @Path("UpdateWork")
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateWork(
      @FormParam("workid") String workid,
      @FormParam("beginDate") String beginDate,
      @FormParam("endDate") String endDate,
      @FormParam("user") String userId,
      @FormParam("jobTitle") String jobTitle) {
    conn = GetConnection.getInstance().getConnection();
    Work w = new Work();
    w.setId(Integer.parseInt(workid));
    w.setJobTitle(jobTitle);
    w.setUser(new DaoUser(conn).find(Integer.parseInt(userId)));
    Date begin = null;
    try {
      begin = new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    w.setBeginDate(begin);
    Date end = null;
    try {
      end = new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    w.setEndDate(end);
    boolean test = new DaoWork(conn).update(w);
    if (test) response = Response.status(Response.Status.OK).entity(true).build();
    else response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
    return response;
  }
}
