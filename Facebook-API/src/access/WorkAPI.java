package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoUser;
import model.dao.DaoWork;
import model.pojo.User;
import model.pojo.Work;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

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
}
