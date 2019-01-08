package model.dao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.util.List;

abstract class Dao<T> {
  final WebResource webResource;

  Dao() {
    Client client = Client.create();
    webResource = client.resource("http://localhost:9090/Facebook_API_war_exploded/rest/");
  }

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean create(T obj);

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean delete(T obj);

  /**
   * @param obj the object of the DAO
   * @return boolean
   */
  public abstract boolean update(T obj);

  /**
   * @param id the id of the object of the DAO
   * @return T
   */
  public abstract T find(int id);

  public abstract List<T> getAll();
}
