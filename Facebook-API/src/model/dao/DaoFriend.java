package model.dao;

import model.pojo.Friend;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoFriend extends Dao<Friend> {
  public DaoFriend(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Friend obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{? = call FRIENDSPACKAGE.add(?,?,?)}");
      stmt.registerOutParameter(1, OracleTypes.NUMBER);
      stmt.setInt(2, obj.getAsker().getId());
      stmt.setInt(3, obj.getReceiver().getId());
      stmt.setInt(4, obj.getAccepted() ? 1 : 0);
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
  public boolean delete(Friend obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call FRIENDSPACKAGE.del(?,?)}");
      stmt.setInt(1, obj.getAsker().getId());
      stmt.setInt(2, obj.getReceiver().getId());
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
  public boolean update(Friend obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call FRIENDSPACKAGE.upd(?,?,?)}");
      stmt.setInt(1, obj.getAsker().getId());
      stmt.setInt(2, obj.getReceiver().getId());
      stmt.setInt(3, obj.getAccepted() ? 1 : 0);
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
  public Friend find(int id) {
    return null;
  }

  public Friend find(int idasker, int idreceiver) {
    CallableStatement stmt = null;
    Friend f = new Friend();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call FRIENDSPACKAGE.get(?,?)}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.setInt(2, idasker);
      stmt.setInt(3, idreceiver);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet.next()) {
        f.setAsker(new DaoUser(connect).find(resultSet.getInt(1)));
        f.setReceiver(new DaoUser(connect).find(resultSet.getInt(2)));
        f.setAccepted(resultSet.getInt(3) == 1);
      } else {
        return null;
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
    return f;
  }

  @Override
  public List<Friend> getAll() {
    CallableStatement stmt = null;
    List<Friend> friends = new ArrayList<>();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call FRIENDSPACKAGE.getAll}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet != null) {
        while (resultSet.next()) {
          Friend f = new Friend();
          f.setAsker(new DaoUser(connect).find(resultSet.getInt(1)));
          f.setReceiver(new DaoUser(connect).find(resultSet.getInt(2)));
          f.setAccepted(resultSet.getInt(3) == 1);
          friends.add(f);
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
    return friends;
  }
}
