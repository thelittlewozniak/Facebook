package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Friend;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.List;

public class DaoFriend extends Dao<Friend> {
    public DaoFriend() {
        super();
    }

    @Override
    public boolean create(Friend obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("asker",obj.getAsker());
        ((MultivaluedMapImpl) params).add("receiver",obj.getReceiver());
        ((MultivaluedMapImpl) params).add("accepted",obj.getAccepted());
        String response = webResource.path("Friend/CreateFriend").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
    public boolean delete(Friend obj) {
        String response = webResource.path("Friend/DeleteFriend?asker="+obj.getAsker().getId()+"&receiver="+obj.getReceiver().getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
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
    public boolean update(Friend obj) {
        return false;
    }

    @Override
    public Friend find(int id) {
        return null;
    }

    @Override
    public List<Friend> getAll() {
        return null;
    }
}
