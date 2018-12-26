package model.BusinessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    private Connection conn;
    private static  GetConnection instance;
    public Connection getConnection(){
        return conn;
    }
    private GetConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn= DriverManager.getConnection("jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe","nathan3","Nathan");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static GetConnection getInstance(){
        if(instance==null){
            instance=new GetConnection();
        }
        return instance;
    }
}
