package model.dao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

public abstract class Dao<T> {
  WebResource webResource;

  public Dao() {
    Client client = Client.create();
    webResource = client.resource("http://localhost:9090/Facebook_API_war_exploded/rest/");
  }

  /**
   * @param obj
   * @return boolean
   */
  public abstract boolean create(T obj);

  /**
   * @param obj
   * @return boolean
   */
  public abstract boolean delete(T obj);

  /**
   * @param obj
   * @return boolean
   */
  public abstract boolean update(T obj);

  /**
   * @param id
   * @return T
   */
  public abstract T find(int id);

  public abstract List<T> getAll();
}
