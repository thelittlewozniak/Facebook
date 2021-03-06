package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoUser extends Dao<User> {
  public DaoUser() {
    super();
  }

  @Override
  public boolean create(User obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    params.add("interestedIn", String.valueOf(obj.getInterestedIn()));
    params.add("gender", String.valueOf(obj.getGender()));
    params.add("phoneNumber", String.valueOf(obj.getPhoneNumber()));
    params.add("relationship", String.valueOf(obj.getRelationship()));
    params.add("registerDate", dateFormat.format(obj.getRegisterDate()));
    params.add("birthday", dateFormat.format(obj.getBirthday()));
    params.add("address", obj.getAddress());
    params.add("lastname", obj.getLastname());
    params.add("firstname", obj.getFirstname());
    params.add("password", obj.getPassword());
    params.add("email", obj.getEmail());
    String response =
        webResource
            .path("User/CreateUser")
            .accept(MediaType.APPLICATION_JSON)
            .type("application/x-www-form-urlencoded")
            .post(String.class, params);
    ObjectMapper mapper = new ObjectMapper();
    Boolean done = false;
    try {
      done = mapper.readValue(response, new TypeReference<Boolean>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return done;
  }

  @Override
  public boolean delete(User obj) {
    String response =
        webResource
            .path("User/DeleteUser?id=" + obj.getId())
            .accept(MediaType.APPLICATION_JSON)
            .delete(String.class);
    ObjectMapper mapper = new ObjectMapper();
    Boolean done = false;
    try {
      done = mapper.readValue(response, new TypeReference<Boolean>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return done;
  }

  @Override
  public boolean update(User obj) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("userid", String.valueOf(obj.getId()));
    params.add("interestedIn", String.valueOf(obj.getInterestedIn()));
    params.add("gender", String.valueOf(obj.getGender()));
    params.add("phoneNumber", String.valueOf(obj.getPhoneNumber()));
    params.add("relationship", String.valueOf(obj.getRelationship()));
    params.add("registerDate", dateFormat.format(obj.getRegisterDate()));
    params.add("birthday", dateFormat.format(obj.getBirthday()));
    params.add("address", obj.getAddress());
    params.add("lastname", obj.getLastname());
    params.add("firstname", obj.getFirstname());
    params.add("password", obj.getPassword());
    params.add("email", obj.getEmail());
    String response =
        webResource
            .path("User/UpdateUser")
            .accept(MediaType.APPLICATION_JSON)
            .type("application/x-www-form-urlencoded")
            .put(String.class, params);
    ObjectMapper mapper = new ObjectMapper();
    Boolean done = false;
    try {
      done = mapper.readValue(response, new TypeReference<Boolean>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return done;
  }

  @Override
  public User find(int id) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("id", String.valueOf(id));
    String response =
        webResource
            .path("User/GetUser")
            .queryParams(params)
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    User u = new User();
    try {
      u = mapper.readValue(response, new TypeReference<User>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return u;
  }

  @Override
  public List<User> getAll() {
    String response =
        webResource.path("User/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<User> users = new ArrayList<>();
    try {
      users = mapper.readValue(response, new TypeReference<List<User>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return users;
  }
}
