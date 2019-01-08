package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Friend;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoFriend extends Dao<Friend> {
  public DaoFriend() {
    super();
  }

  @Override
  public boolean create(Friend obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("asker", String.valueOf(obj.getAsker().getId()));
    params.add("receiver", String.valueOf(obj.getReceiver().getId()));
    params.add("accepted", String.valueOf(obj.getAccepted()));
    String response =
        webResource
            .path("Friend/CreateFriend")
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
  public boolean delete(Friend obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("asker", String.valueOf(obj.getAsker().getId()));
    params.add("receiver", String.valueOf(obj.getReceiver().getId()));
    String response =
        webResource
            .path("Friend/DeleteFriend")
            .queryParams(params)
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
  public boolean update(Friend obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("asker", String.valueOf(obj.getAsker().getId()));
    params.add("receiver", String.valueOf(obj.getReceiver().getId()));
    params.add("accepted", String.valueOf(obj.getAccepted()));
    String response =
        webResource
            .path("Friend/UpdateFriend")
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
  public Friend find(int id) {
    return null;
  }

  public Friend find(int askerId, int receiverId) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("asker", String.valueOf(askerId));
    params.add("receiver", String.valueOf(receiverId));
    String response =
        webResource
            .path("Friend/GetFriend")
            .queryParams(params)
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    Friend f = new Friend();
    try {
      f = mapper.readValue(response, new TypeReference<Friend>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return f;
  }

  @Override
  public List<Friend> getAll() {
    String response =
        webResource.path("Friend/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Friend> friends = new ArrayList<>();
    try {
      friends = mapper.readValue(response, new TypeReference<List<Friend>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return friends;
  }
}
