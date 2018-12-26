package access;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("User")
public class User extends RestApplication{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(){
        return new String("Salut");
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTest() throws SQLException,ClassNotFoundException {
        return new Test().testText();
    }
}
