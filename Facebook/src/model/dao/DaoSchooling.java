package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Schooling;
import model.pojo.Work;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoSchooling extends Dao<Schooling> {
    public DaoSchooling() {
        super();
    }

    @Override
    public boolean create(Schooling obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("name",obj.getName());
        ((MultivaluedMapImpl) params).add("address",obj.getAddress());
        ((MultivaluedMapImpl) params).add("beginDate",obj.getBeginDate());
        ((MultivaluedMapImpl) params).add("endDate",obj.getEndDate());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("graduate",obj.getGraduate());
        ((MultivaluedMapImpl) params).add("type",obj.getType());
        String response = webResource.path("Schooling/CreateSchooling").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").post(String.class,params);
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
    public boolean delete(Schooling obj) {
        String response = webResource.path("Schooling/DeleteSchooling?iduser="+obj.getUser().getId()+"&id="+obj.getId()).accept(MediaType.APPLICATION_JSON).delete(String.class);
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
    public boolean update(Schooling obj) {
        MultivaluedMap<String,String> params=new MultivaluedMapImpl();
        ((MultivaluedMapImpl) params).add("schoolingId",obj.getId());
        ((MultivaluedMapImpl) params).add("beginDate",obj.getBeginDate());
        ((MultivaluedMapImpl) params).add("endDate",obj.getEndDate());
        ((MultivaluedMapImpl) params).add("user",obj.getUser().getId());
        ((MultivaluedMapImpl) params).add("graduate",obj.getGraduate());
        String response = webResource.path("Schooling/UpdateSchooling").accept(MediaType.APPLICATION_JSON).type("application/x-www-form-urlencoded").put(String.class,params);
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
    public Schooling find(int id) {
        return null;
    }

    public Schooling find(int userId, int idSchool) {
        String response = webResource.path("Schooling/getSchooling?iduser="+userId+"&id="+idSchool).accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        Schooling s=new Schooling();
        try {
            s=mapper.readValue(response, new TypeReference<Work>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }
    @Override
    public List<Schooling> getAll() {
        String response = webResource.path("Schooling/GetAll").accept(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper =new ObjectMapper();
        List<Schooling> schoolings=new ArrayList<>();
        try {
            schoolings=mapper.readValue(response, new TypeReference<List<Schooling>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schoolings;
    }
}
