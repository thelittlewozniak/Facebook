package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Post;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DaoPost extends Dao<Post> {
    public DaoPost() {
        super();
    }

    @Override
    public boolean create(Post obj) {
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
    public boolean delete(Post obj) {
        String response = webResource.path("Post/DeletePost?id="+obj.getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
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
    public boolean update(Post obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("postid",obj.getId());
        ((MultivaluedMapImpl) params).add("data",obj.getData());
        ((MultivaluedMapImpl) params).add("type",obj.getType());
        ((MultivaluedMapImpl) params).add("postDate",obj.getPostDate());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        String response = webResource.path("Post/UpdatePost").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
    public Post find(int id) {
        String response = webResource.path("Post/GetPost?id="+id).accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        Post p=new Post();
        try {
            p=mapper.readValue(response, new TypeReference<Post>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Post> getAll() {
        String response = webResource.path("User/getAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        List<Post> posts=new ArrayList<>();
        try {
            posts=mapper.readValue(response, new TypeReference<List<Post>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
