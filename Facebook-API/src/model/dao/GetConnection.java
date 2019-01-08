package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
  private static GetConnection instance;
  private Connection conn;

  private GetConnection() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

      conn =
          DriverManager.getConnection(
              "jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe", "nathan3", "Nathan");
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public static GetConnection getInstance() {
    if (instance == null) {
      instance = new GetConnection();
    }
    return instance;
  }

  public Connection getConnection() {
    return conn;
  }
}
