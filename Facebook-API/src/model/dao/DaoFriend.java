package model.dao;

import model.pojo.Friend;
import model.pojo.Work;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoFriend extends Dao<Friend> {
    public DaoFriend(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Friend obj) {
        return false;
    }

    @Override
    public boolean delete(Friend obj) {
        return false;
    }

    @Override
    public boolean update(Friend obj) {
        return false;
    }

    @Override
    public Friend find(int id) {
        return null;
    }

    public Friend find(int idasker,int idreceiver) {
        CallableStatement stmt=null;
        Work w=new Work();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call WORKPACKAGE.get(?,?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setInt(2,user);
            stmt.setInt(3, id);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet.next()){
                w.setUser(new DaoUser(connect).find(resultSet.getInt(1)));
                w.setId(resultSet.getInt(2));
                w.setBeginDate(resultSet.getTimestamp(3));
                w.setEndDate(resultSet.getTimestamp(4));
                w.setJobTitle(resultSet.getString(5));
                w.setName(resultSet.getString(6));
                w.setAddress(resultSet.getString(7));
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return w;
    }

    @Override
    public List<Friend> getAll() {
        return null;
    }
}