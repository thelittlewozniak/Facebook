package model.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import model.pojo.Schooling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
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
        return false;
    }

    @Override
    public boolean update(Schooling obj) {
        return false;
    }

    @Override
    public Schooling find(int id) {
        return null;
    }

    @Override
    public List<Schooling> getAll() {
        return null;
    }
}
