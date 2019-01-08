package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Like;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoLikePost extends Dao<Like> {
  @Override
  public boolean create(Like obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    params.add("dateLiked", dateFormat.format(obj.getDateLiked()));
    params.add("user", String.valueOf(obj.getUser().getId()));
    params.add("post", String.valueOf(obj.getPost().getId()));
    String response =
        webResource
            .path("LikePost/CreateLike")
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
  public boolean delete(Like obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("id", String.valueOf(obj.getId()));
    String response =
        webResource
            .queryParams(params)
            .path("LikePost/DeleteLike")
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
  public boolean update(Like obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    params.add("dateLiked", dateFormat.format(obj.getDateLiked()));
    params.add("user", String.valueOf(obj.getUser().getId()));
    params.add("post", String.valueOf(obj.getPost().getId()));
    String response =
        webResource
            .path("LikePost/UpdateLike")
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
  public Like find(int id) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    params.add("id", String.valueOf(id));
    String response =
        webResource
            .queryParams(params)
            .path("LikePost/getLike")
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    Like l = new Like();
    try {
      l = mapper.readValue(response, new TypeReference<Like>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return l;
  }

  @Override
  public List<Like> getAll() {
    String response =
        webResource.path("LikePost/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Like> likes = new ArrayList<>();
    try {
      likes = mapper.readValue(response, new TypeReference<List<Like>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return likes;
  }
}
