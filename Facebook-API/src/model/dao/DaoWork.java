package model.dao;

import model.pojo.Work;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
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
        return false;
    }

    @Override
    public boolean update(Work obj) {
        return false;
    }

    @Override
    public Work find(int id) {
        return null;
    }

    @Override
    public List<Work> getAll() {
        return null;
    }
}