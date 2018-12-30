package model.dao;

import model.pojo.Like;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;

public class DaoLikeComment extends Dao<Like> {
    public DaoLikeComment(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Like obj) {
        CallableStatement stmt=null;
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call LIKEPACKAGE.ADDLikeComment(?,?,?)}");
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.setDate(2,java.sql.Date.valueOf(obj.getDateLiked().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setInt(3,obj.getUser().getId());
            stmt.setInt(4,obj.getComment().getId());
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