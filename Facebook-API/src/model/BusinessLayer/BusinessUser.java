package model.BusinessLayer;

import model.dao.DaoUser;
import model.pojo.User;

import java.sql.Connection;
import java.util.List;

public class BusinessUser {
    private Connection conn;
    public BusinessUser(){
        conn=GetConnection.getInstance().getConnection();
    }
    public User login(String email,String password){
        if(email!=null && password!=null){
            List<User> users=new DaoUser(conn).getAll();
            for(int i=0;i<users.size();i++){
                if(users.get(i).getEmail().equals(email.toLowerCase())){
                    if(users.get(i).getPassword().equals(password)){
                        return users.get(i);
                    }
                }
            }
        }
        return null;
    }
    public User Create(){
        //TO DO
        return null;
    }
}
