package access;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@ApplicationPath("rest")
public class RestApplication extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        return null;
    }
}