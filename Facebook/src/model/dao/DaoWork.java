package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Work;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoWork extends Dao<Work> {
  public DaoWork() {
    super();
  }

  @Override
  public boolean create(Work obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    params.add("name", obj.getName());
    params.add("address", obj.getAddress());
    params.add("beginDate", dateFormat.format(obj.getBeginDate()));
    params.add("endDate", dateFormat.format(obj.getEndDate()));
    ((MultivaluedMapImpl) params).add("user", obj.getUser().getId());
    params.add("jobTitle", obj.getJobTitle());
    String response =
        webResource
            .path("Work/CreateWork")
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
  public boolean delete(Work obj) {
    String response =
        webResource
            .path("Work/DeleteWork?user=" + obj.getUser().getId() + "&company=" + obj.getId())
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
  public boolean update(Work obj) {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    ((MultivaluedMapImpl) params).add("workid", obj.getId());
    params.add("beginDate", dateFormat.format(obj.getBeginDate()));
    params.add("endDate", dateFormat.format(obj.getEndDate()));
    ((MultivaluedMapImpl) params).add("user", obj.getUser().getId());
    params.add("jobTitle", obj.getJobTitle());
    String response =
        webResource
            .path("Work/UpdateWork")
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
  public Work find(int id) {
    return null;
  }

  public Work find(int userId, int idCompany) {
    String response =
        webResource
            .path("Work/getWork?user=" + userId + "&company=" + idCompany)
            .accept(MediaType.APPLICATION_JSON)
            .get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    Work w = new Work();
    try {
      w = mapper.readValue(response, new TypeReference<Work>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return w;
  }

  @Override
  public List<Work> getAll() {
    String response =
        webResource.path("Work/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
    ObjectMapper mapper = new ObjectMapper();
    List<Work> works = new ArrayList<>();
    try {
      works = mapper.readValue(response, new TypeReference<List<Work>>() {});
    } catch (IOException e) {
      e.printStackTrace();
    }
    return works;
  }
}
