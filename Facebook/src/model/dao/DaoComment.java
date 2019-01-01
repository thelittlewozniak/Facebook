package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Comment;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class DaoComment extends Dao<Comment> {
    public DaoComment() {
        super();
    }

    @Override
    public boolean create(Comment obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("data",obj.getData());
        ((MultivaluedMapImpl) params).add("type",obj.getType());
        ((MultivaluedMapImpl) params).add("postDate",obj.getPostDate());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        String response = webResource.path("Post/CreatePost").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
    public boolean delete(Comment obj) {
        return false;
    }

    @Override
    public boolean update(Comment obj) {
        return false;
    }

    @Override
    public Comment find(int id) {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }
}
