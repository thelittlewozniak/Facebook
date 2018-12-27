package access;

import jdk.net.SocketFlow;
import model.BusinessLayer.GetConnection;
import model.dao.DaoUser;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("User")
public class User extends RestApplication{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        Connection conn= GetConnection.getInstance().getConnection();
        Response response=null;
        List<model.pojo.User> list=new ArrayList<>();
        model.pojo.User user= new model.pojo.User();
        user.setFirstname("Nathan");
        list.add(user);
        //response= Response.status(Response.Status.OK).entity(new DaoUser(conn).getAll()).build();
        response= Response.status(Response.Status.OK).entity(list).build();
        return response;
    }

}
