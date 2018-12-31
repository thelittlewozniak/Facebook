package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoUser extends Dao<User> {
    public DaoUser() {
        super();
    }

    @Override
    public boolean create(User obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("interestedIn",obj.getInterestedIn());
        ((MultivaluedMapImpl) params).add("gender",obj.getGender());
        ((MultivaluedMapImpl) params).add("phoneNumber",obj.getPhoneNumber());
        ((MultivaluedMapImpl) params).add("relationship",obj.getRelationship());
        ((MultivaluedMapImpl) params).add("registerDate",obj.getRegisterDate());
        ((MultivaluedMapImpl) params).add("birthday",obj.getBirthday());
        ((MultivaluedMapImpl) params).add("address",obj.getAddress());
        ((MultivaluedMapImpl) params).add("lastname",obj.getLastname());
        ((MultivaluedMapImpl) params).add("firstnam",obj.getFirstname());
        ((MultivaluedMapImpl) params).add("password",obj.getPassword());
        ((MultivaluedMapImpl) params).add("email",obj.getEmail());
        String response = webResource.path("User/CreateUser").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
        ObjectMapper mapper =new ObjectMapper();
        Boolean done=false;
        try {
            done=mapper.readValue(response, new TypeReference<Boolean>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;
    }

    @Override
    public boolean delete(User obj) {
        String response = webResource.path("User/DeleteUser?id="+obj.getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
        ObjectMapper mapper =new ObjectMapper();
        Boolean done=false;
        try {
            done=mapper.readValue(response, new TypeReference<Boolean>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;
    }

    @Override
    public boolean update(User obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("userid",obj.getId());
        ((MultivaluedMapImpl) params).add("interestedIn",obj.getInterestedIn());
        ((MultivaluedMapImpl) params).add("gender",obj.getGender());
        ((MultivaluedMapImpl) params).add("phoneNumber",obj.getPhoneNumber());
        ((MultivaluedMapImpl) params).add("relationship",obj.getRelationship());
        ((MultivaluedMapImpl) params).add("registerDate",obj.getRegisterDate());
        ((MultivaluedMapImpl) params).add("birthday",obj.getBirthday());
        ((MultivaluedMapImpl) params).add("address",obj.getAddress());
        ((MultivaluedMapImpl) params).add("lastname",obj.getLastname());
        ((MultivaluedMapImpl) params).add("firstnam",obj.getFirstname());
        ((MultivaluedMapImpl) params).add("password",obj.getPassword());
        ((MultivaluedMapImpl) params).add("email",obj.getEmail());
        String response = webResource.path("User/UpdateUser").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").put(String.class,params);
        ObjectMapper mapper =new ObjectMapper();
        Boolean done=false;
        try {
            done=mapper.readValue(response, new TypeReference<Boolean>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;
    }

    @Override
    public User find(int id) {
        String response = webResource.path("User/GetUser?id="+id).accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        User u=new User();
        try {
            u=mapper.readValue(response, new TypeReference<User>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public List<User> getAll() {
        String response = webResource.path("User/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        List<User> users=new ArrayList<>();
        try {
            users=mapper.readValue(response, new TypeReference<List<User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
