package access;

import model.BusinessLayer.GetConnection;
import model.dao.DaoSchooling;
import model.dao.DaoUser;
import model.dao.DaoWork;
import model.pojo.Schooling;
import model.pojo.Work;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;

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
    @Path("GetWork")
    public Response getWork(@QueryParam("id") int id) {
        Response response=null;
        Connection conn= GetConnection.getInstance().getConnection();
        Schooling s=new DaoSchooling(conn).find(id);
        if(s!=null)
            response=Response.status(Response.Status.OK).entity(s).build();
        else
            response=Response.status(Response.Status.NO_CONTENT).entity(null).build();
        return response;
    }
}
