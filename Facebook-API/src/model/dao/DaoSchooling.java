package model.dao;

import model.pojo.Schooling;
import oracle.jdbc.internal.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DaoSchooling extends Dao<Schooling> {
  public DaoSchooling(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Schooling obj) {
    CallableStatement stmt = null;
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call SCHOOLINGPACKAGE.add(?,?,?,?,?,?,?)}");
      stmt.registerOutParameter(1, OracleTypes.NUMBER);
      stmt.setInt(2, obj.getUser().getId());
      stmt.setString(3, obj.getName());
      stmt.setString(4, obj.getAddress());
      stmt.setString(5, obj.getType());
      stmt.setDate(
          6,
          java.sql.Date.valueOf(
              obj.getBeginDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setDate(
          7,
          java.sql.Date.valueOf(
              obj.getEndDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setInt(8, obj.getGraduate() ? 1 : 0);
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
  public boolean delete(Schooling obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call SCHOOLINGPACKAGE.del(?,?)}");
      stmt.setInt(1, obj.getUser().getId());
      stmt.setInt(2, obj.getId());
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
  public boolean update(Schooling obj) {
    CallableStatement stmt = null;
    try {
      stmt = connect.prepareCall("{call SCHOOLINGPACKAGE.upd(?,?,?,?,?)}");
      stmt.setInt(1, obj.getUser().getId());
      stmt.setInt(2, obj.getId());
      stmt.setDate(
          3,
          java.sql.Date.valueOf(
              obj.getBeginDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setDate(
          4,
          java.sql.Date.valueOf(
              obj.getEndDate().toInstant().atZone(ZoneId.of("Europe/Brussels")).toLocalDate()));
      stmt.setInt(5, obj.getGraduate() ? 1 : 0);
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
  public Schooling find(int id) {
    return null;
  }

  public Schooling find(int id, int iduser) {
    CallableStatement stmt = null;
    Schooling s = new Schooling();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call SCHOOLINGPACKAGE.get(?,?)}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.setInt(2, iduser);
      stmt.setInt(3, id);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet.next()) {
        s.setUser(new DaoUser(connect).find(resultSet.getInt(1)));
        s.setId(resultSet.getInt(2));
        s.setBeginDate(resultSet.getTimestamp(3));
        s.setEndDate(resultSet.getTimestamp(4));
        s.setGraduate(resultSet.getInt(5) == 1);
        s.setName(resultSet.getString(6));
        s.setAddress(resultSet.getString(7));
        s.setType(resultSet.getString(8));
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
    return s;
  }

  @Override
  public List<Schooling> getAll() {
    CallableStatement stmt = null;
    List<Schooling> schoolings = new ArrayList<>();
    ResultSet resultSet = null;
    try {
      stmt = connect.prepareCall("{? = call SCHOOLINGPACKAGE.getAll}");
      stmt.registerOutParameter(1, OracleTypes.CURSOR);
      stmt.execute();
      resultSet = (ResultSet) stmt.getObject(1);
      if (resultSet != null) {
        while (resultSet.next()) {
          Schooling s = new Schooling();
          s.setUser(new DaoUser(connect).find(resultSet.getInt(1)));
          s.setId(resultSet.getInt(2));
          s.setBeginDate(resultSet.getTimestamp(3));
          s.setEndDate(resultSet.getTimestamp(4));
          s.setGraduate(resultSet.getInt(5) == 1);
          s.setName(resultSet.getString(6));
          s.setAddress(resultSet.getString(7));
          s.setType(resultSet.getString(8));
          schoolings.add(s);
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
    return schoolings;
  }
}
