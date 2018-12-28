package model.dao;

import model.pojo.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import oracle.jdbc.internal.OracleTypes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DaoUser extends Dao<User> {
    public DaoUser(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(User obj) {
        CallableStatement stmt=null;
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call USERPACKAGE.add(?,?,?,?,?,?,?,?,?,?,?)}");
            stmt.registerOutParameter(1,OracleTypes.NUMBER);
            stmt.setString(2,obj.getFirstname());
            stmt.setString(3,obj.getLastname());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getPassword());
            stmt.setString(6,obj.getAddress());
            stmt.setDate(7,java.sql.Date.valueOf(obj.getBirthday().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setDate(8,java.sql.Date.valueOf(obj.getRegisterDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setInt(9,obj.getRelationship()?1:0);
            stmt.setInt(10,obj.getPhoneNumber());
            stmt.setInt(11,obj.getGender()?1:0);
            stmt.setInt(12,obj.getInterestedIn()?1:0);
            stmt.execute();
            return stmt.getInt(1)!=-1?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return false;
    }

    @Override
    public User find(int id) {
        CallableStatement stmt=null;
        User u=new User();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call USERPACKAGE.get(?)}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.setInt(2, id);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet.next()){
                u.setId(resultSet.getInt(1));
                u.setEmail(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));
                u.setFirstname(resultSet.getString(4));
                u.setLastname(resultSet.getString(5));
                u.setAddress(resultSet.getString(6));
                u.setBirthday(resultSet.getTimestamp(7));
                u.setRegisterDate(resultSet.getTimestamp(8));
                u.setRelationship(resultSet.getInt(9)==1?true:false);
                u.setPhoneNumber(resultSet.getInt(10));
                u.setGender(resultSet.getInt(11)==1?true:false);
                u.setInterestedIn(resultSet.getInt(12)==1?true:false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return u;
    }

    @Override
    public List<User> getAll() {
        CallableStatement stmt=null;
        List<User> users=new ArrayList<>();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call USERPACKAGE.getAll}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet!=null){
                while(resultSet.next()){
                    User u=new User();
                    u.setId(resultSet.getInt(1));
                    u.setEmail(resultSet.getString(2));
                    u.setPassword(resultSet.getString(3));
                    u.setFirstname(resultSet.getString(4));
                    u.setLastname(resultSet.getString(5));
                    u.setAddress(resultSet.getString(6));
                    u.setBirthday(resultSet.getTimestamp(7));
                    u.setRegisterDate(resultSet.getTimestamp(8));
                    u.setRelationship(resultSet.getInt(9)==1?true:false);
                    u.setPhoneNumber(resultSet.getInt(10));
                    u.setGender(resultSet.getInt(11)==1?true:false);
                    u.setInterestedIn(resultSet.getInt(12)==1?true:false);
                    users.add(u);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }
}