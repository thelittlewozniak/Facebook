package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        Client client= Client.create();
        WebResource webResource=client.resource("http://localhost:9090/Facebook_API_war_exploded/rest/");
        String response = webResource.path("User/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        List<User> users=new ArrayList<>();
        users=mapper.readValue(response, new TypeReference<List<User>>(){});
        for (User u:users) {
            System.out.println(u.getBirthday());
        }
    }
}
