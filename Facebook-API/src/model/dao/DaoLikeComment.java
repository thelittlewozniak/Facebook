package model.dao;

import model.pojo.Like;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
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
        CallableStatement stmt=null;
        try{
            stmt=connect.prepareCall("{call LIKEPACKAGE.delLikeComment(?)}");
            stmt.setInt(1,obj.getId());
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
    public boolean update(Like obj) {
        CallableStatement stmt=null;
        try{
            stmt=connect.prepareCall("{call LIKEPACKAGE.updLikeComment(?,?,?,?)}");
            stmt.setInt(1,obj.getId());
            stmt.setDate(2,java.sql.Date.valueOf(obj.getDateLiked().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setInt(3,obj.getUser().getId());
            stmt.setInt(4,obj.getComment().getId());
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
    public Like find(int id) {
        CallableStatement stmt=null;
        Like l=new Like();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call LIKEPACKAGE.getLikeComment(?)}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.setInt(2, id);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet.next()){
                l.setId(resultSet.getInt(1));
                l.setDateLiked(resultSet.getTimestamp(2));
                l.setUser(new DaoUser(connect).find(resultSet.getInt(3)));
                l.setComment(new DaoComment(connect).find(resultSet.getInt(4)));
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
        return l;
    }

    @Override
    public List<Like> getAll() {
        CallableStatement stmt=null;
        List<Like> likes=new ArrayList<>();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call LIKEPACKAGE.getAllLikeComment}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet!=null){
                while(resultSet.next()){
                    Like l=new Like();
                    l.setId(resultSet.getInt(1));
                    l.setDateLiked(resultSet.getTimestamp(2));
                    l.setUser(new DaoUser(connect).find(resultSet.getInt(3)));
                    l.setComment(new DaoComment(connect).find(resultSet.getInt(4)));
                    likes.add(l);
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
        return likes;
    }
}