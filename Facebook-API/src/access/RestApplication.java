package access;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("rest")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    return null;
  }
}
