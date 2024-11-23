package connectorJ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JConnector {
    final static String HOST = "localhost:3306";
    final static String DATABASE = "digital_shop";
    final static String USER = "root";
    final static String PASSWORD = "";
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnecion(){
        Connection connection = null;

        try{
            Class.forName(DRIVER);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://" + HOST + "/" + DATABASE;
        
        try{
            connection = DriverManager.getConnection(url, USER, PASSWORD);

        }catch(SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}