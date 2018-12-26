package access;

import model.BusinessLayer.GetConnection;

import java.sql.*;

public class Test {
    Connection connec=null;

    Statement stmt = null;
    ResultSet res = null;
    public String testText() throws SQLException,ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connec = DriverManager.getConnection("jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe","nathan3","Nathan");
        model.pojo.User user = new model.pojo.User();
        stmt = connec.createStatement();
        String find = "SELECT * from personne WHERE NUM_PERS_PK =1";
        res = stmt.executeQuery(find);

        if(res.next()) {
            user.setEmail(res.getString(2));

        }
        return user.getEmail();
    }
    public static void main(String[] args){
        Connection connec = GetConnection.getInstance().getConnection();
        Statement stmt = null;
        ResultSet res = null;
        model.pojo.User user = new model.pojo.User();
        try{
            try {
                stmt = connec.createStatement();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String find = "SELECT * FROM personne WHERE NUM_PERS_PK =1";
            res = stmt.executeQuery(find);

            if(res.next()){
                user.setEmail(res.getString(2));

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(user.getEmail());
    }
}
