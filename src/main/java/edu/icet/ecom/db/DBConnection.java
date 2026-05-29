package edu.icet.ecom.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
private static DBConnection instance;
private Connection connection;

    public  static DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance=new DBConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
