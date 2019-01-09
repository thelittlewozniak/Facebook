package model.dao;

import model.pojo.Comment;
import model.pojo.Like;
import model.pojo.Post;
import model.pojo.User;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoPost extends Dao<Post> {
  public DaoPost(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Post obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{? = call POSTPACKAGE.add(?,?,?,?)}");
      stmt.registerOutParameter(1, OracleTypes.NUMBER);
      stmt.setString(2, obj.getData());
      stmt.setString(3, obj.getType());
      stmt.setDate(
          4,
          java.sql.Date.valueOf(
              obj.getPostDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setInt(5, obj.getUser().getId());
      stmt.execute();
      return stmt.getInt(1) != -1;
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
    }
  }

  @Override
  public boolean delete(Post obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call POSTPACKAGE.del(?)}");
      stmt.setInt(1, obj.getId());
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
    }
    return true;
  }

  @Override
  public boolean update(Post obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call POSTPACKAGE.upd(?,?,?,?,?)}");
      stmt.setInt(1, obj.getId());
      stmt.setString(2, obj.getData());
      stmt.setString(3, obj.getType());
      stmt.setDate(
          4,
          java.sql.Date.valueOf(
              obj.getPostDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setInt(5, obj.getUser().getId());
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
    }
    return true;
  }

  @Override
  public Post find(int id) {
    CallableStatement stmt = null;
    Post p = new Post();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call POSTPACKAGE.get(?)}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.setInt(2, id);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet.next()) {
        p.setId(resultSet.getInt(1));
        p.setData(resultSet.getString(2));
        p.setType(resultSet.getString(3));
        p.setPostDate(resultSet.getTimestamp(4));
        p.setUser(new DaoUser(connect).find(resultSet.getInt(5)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
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
    return p;
  }

  @Override
  public List<Post> getAll() {
    CallableStatement stmt = null;
    List<Post> posts = new ArrayList<>();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call POSTPACKAGE.getAll}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet != null) {
        List<Like> likes=new DaoLikePost(connect).getAll();
        List<Comment> comments=new DaoComment(connect).getAll();
        List<User> users=new DaoUser(connect).getAll();
        while (resultSet.next()) {
          Post p = new Post();
          p.setId(resultSet.getInt("idpost"));
          p.setData(resultSet.getString("data"));
          p.setType(resultSet.getString(3));
          p.setPostDate(resultSet.getTimestamp(4));
          for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId()==resultSet.getInt(5))
              p.setUser(users.get(i));
          }
          p.setLikes(likes.stream().filter(l->l.getPost().getId()==p.getId()).collect(Collectors.toList()));
          p.setComments(comments.stream().filter(c->c.getPost().getId()==p.getId()).collect(Collectors.toList()));
          posts.add(p);
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } finally {
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
    return posts;
  }
}
