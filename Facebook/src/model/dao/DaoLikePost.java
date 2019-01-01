package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Like;
import model.pojo.User;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoLikePost extends Dao<Like> {
    @Override
    public boolean create(Like obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("dateLiked",obj.getDateLiked());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("post",obj.getPost().getId());
        String response = webResource.path("LikePost/CreateLike").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
    public boolean delete(Like obj) {
        String response = webResource.path("LikePost/DeleteLike?id="+obj.getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
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
    public boolean update(Like obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("dateLiked",obj.getDateLiked());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("post",obj.getPost().getId());
        String response = webResource.path("LikePost/UpdateLike").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").put(String.class,params);
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
    public Like find(int id) {
        String response = webResource.path("LikePost/GetLike?id="+id).accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        Like l=new Like();
        try {
            l=mapper.readValue(response, new TypeReference<Like>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public List<Like> getAll() {
        String response = webResource.path("LikePost/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        List<Like> likes=new ArrayList<>();
        try {
            likes=mapper.readValue(response, new TypeReference<List<Like>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return likes;
    }
}
