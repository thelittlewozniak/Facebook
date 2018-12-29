package model.dao;

import model.pojo.Comment;
import model.pojo.Post;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DaoComment extends Dao<Comment> {
    public DaoComment(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Comment obj) {
        CallableStatement stmt=null;
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call COMMENTPACKAGE.add(?,?,?,?,?)}");
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.setString(2,obj.getData());
            stmt.setString(3,obj.getType());
            stmt.setDate(4,java.sql.Date.valueOf(obj.getPostDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
            stmt.setInt(5,obj.getPost().getId());
            stmt.setInt(6,obj.getUser().getId());
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
    public boolean delete(Comment obj) {
        CallableStatement stmt=null;
        try{
            stmt=connect.prepareCall("{call COMMENTPACKAGE.del(?)}");
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
    public boolean update(Comment obj) {
        return false;
    }

    @Override
    public Comment find(int id) {
        CallableStatement stmt=null;
        Comment c=new Comment();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call COMMENTPACKAGE.get(?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.setInt(2, id);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet.next()){
                c.setId(resultSet.getInt(1));
                c.setData(resultSet.getString(2));
                c.setType(resultSet.getString(3));
                c.setPostDate(resultSet.getTimestamp(4));
                c.setPost(new DaoPost(connect).find(resultSet.getInt(5)));
                c.setUser(new DaoUser(connect).find(resultSet.getInt(6)));
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
        return c;
    }

    @Override
    public List<Comment> getAll() {
        CallableStatement stmt=null;
        List<Comment> comments=new ArrayList<>();
        ResultSet resultSet=null;
        try{
            stmt=connect.prepareCall("{? = call COMMENTPACKAGE.getAll}");
            stmt.registerOutParameter(1,OracleTypes.CURSOR);
            stmt.execute();
            resultSet=(ResultSet) stmt.getObject(1);
            if(resultSet!=null){
                while(resultSet.next()){
                    Comment c=new Comment();
                    c.setId(resultSet.getInt("idpost"));
                    c.setData(resultSet.getString("data"));
                    c.setType(resultSet.getString(3));
                    c.setPostDate(resultSet.getTimestamp(4));
                    c.setPost(new DaoPost(connect).find(resultSet.getInt(5)));
                    c.setUser(new DaoUser(connect).find(resultSet.getInt(6)));
                    comments.add(c);
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
        return comments;
    }
}