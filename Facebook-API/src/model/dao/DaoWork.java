package model.dao;

import model.pojo.User;
import model.pojo.Work;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DaoWork extends Dao<Work> {
    public DaoWork(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Work obj) {
        CallableStatement stmt=null;
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call WORKPACKAGE.add(?,?,?,?,?,?)}");
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.setInt(2,obj.getUser().getId());
            stmt.setString(3,obj.getName());
            stmt.setString(4,obj.getAddress());
            stmt.setDate(5,java.sql.Date.valueOf(obj.getBeginDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setDate(6,java.sql.Date.valueOf(obj.getEndDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setString(7,obj.getJobTitle());
            stmt.execute();
            return stmt.getInt(1)!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
    }

    @Override
    public boolean delete(Work obj) {
        CallableStatement stmt=null;
        try{
            stmt=connect.prepareCall("{call WORKPACKAGE.del(?,?)}");
            stmt.setInt(1,obj.getUser().getId());
            stmt.setInt(2,obj.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    @Override
    public boolean update(Work obj) {
        CallableStatement stmt = null;
        try {
            stmt = connect.prepareCall("{call WORKPACKAGE.upd(?,?,?,?,?)}");
            stmt.setInt(1, obj.getUser().getId());
            stmt.setInt(2, obj.getId());
            stmt.setDate(3, java.sql.Date.valueOf(obj.getBeginDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setDate(4, java.sql.Date.valueOf(obj.getEndDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setString(5, obj.getJobTitle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
    }

    @Override
    public Work find(int id) {
        return null;
    }

    public Work find(int id,int user) {
        CallableStatement stmt=null;
        Work w=new Work();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call WORKPACKAGE.get(?,?)}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
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
    public List<Work> getAll() {
        CallableStatement stmt=null;
        List<Work> works=new ArrayList<>();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call WORKPACKAGE.getAll}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet!=null){
                while(resultSet.next()){
                    Work w=new Work();
                    w.setUser(new DaoUser(connect).find(resultSet.getInt(1)));
                    w.setId(resultSet.getInt(2));
                    w.setBeginDate(resultSet.getTimestamp(3));
                    w.setEndDate(resultSet.getTimestamp(4));
                    w.setJobTitle(resultSet.getString(5));
                    w.setName(resultSet.getString(6));
                    w.setAddress(resultSet.getString(7));
                    works.add(w);
                }
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
        return works;
    }
}