package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoUser extends Dao<User> {
    public DaoUser(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(User obj) {
        return false;
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return false;
    }

    @Override
    public User find(int id) {

        return null;
    }

    @Override
    public List<User> getAll() {
        Client client= Client.create();
        WebResource webResource=client.resource("http://localhost:9090/Facebook_API_war_exploded/rest/");
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
