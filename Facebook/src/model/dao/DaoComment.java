package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Comment;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoComment extends Dao<Comment> {
    public DaoComment() {
        super();
    }

    @Override
    public boolean create(Comment obj) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        ((MultivaluedMapImpl) params).add("data", obj.getData());
        ((MultivaluedMapImpl) params).add("type", obj.getType());
        ((MultivaluedMapImpl) params).add("postDate", dateFormat.format(obj.getPostDate()));
        ((MultivaluedMapImpl) params).add("user", obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("post", obj.getPost().getId());
        String response = webResource.path("Comment/CreateComment").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class, params);
        ObjectMapper mapper = new ObjectMapper();
        Boolean done = false;
        try {
            done = mapper.readValue(response, new TypeReference<Boolean>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;
    }

    @Override
    public boolean delete(Comment obj) {
        String response = webResource.path("Comment/DeleteComment?id=" + obj.getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Boolean done = false;
        try {
            done = mapper.readValue(response, new TypeReference<Boolean>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;
    }

    @Override
    public boolean update(Comment obj) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        ((MultivaluedMapImpl) params).add("data", obj.getData());
        ((MultivaluedMapImpl) params).add("type", obj.getType());
        ((MultivaluedMapImpl) params).add("postDate", dateFormat.format(obj.getPostDate()));
        ((MultivaluedMapImpl) params).add("user", obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("post", obj.getPost().getId());
        ((MultivaluedMapImpl) params).add("commentId", obj.getId());
        String response = webResource.path("Comment/UpdateComment").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class, params);
        ObjectMapper mapper = new ObjectMapper();
        Boolean done = false;
        try {
            done = mapper.readValue(response, new TypeReference<Boolean>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return done;

    }

    @Override
    public Comment find(int id) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("id", id);
        String response = webResource.queryParams(params).path("Comment/GetComment").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Comment c = new Comment();
        try {
            c = mapper.readValue(response, new TypeReference<Comment>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Comment> getAll() {
        String response = webResource.path("Comment/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Comment> comments = new ArrayList<>();
        try {
            comments = mapper.readValue(response, new TypeReference<List<Comment>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
