package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Like;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.List;

public class DaoLikeComment extends Dao<Like> {
    public DaoLikeComment() {
        super();
    }

    @Override
    public boolean create(Like obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("dateLiked",obj.getDateLiked());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("comment",obj.getComment().getId());
        String response = webResource.path("LikeComment/CreateLike").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
        return false;
    }

    @Override
    public boolean update(Like obj) {
        return false;
    }

    @Override
    public Like find(int id) {
        return null;
    }

    @Override
    public List<Like> getAll() {
        return null;
    }
}
