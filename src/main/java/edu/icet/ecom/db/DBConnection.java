package edu.icet.ecom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static DBConnection instance;
private Connection connection;

private DBConnection DBConnection() throws SQLException {
    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book_Rentel_System","root","12345");
    if(instance == null){
        instance=new DBConnection();
    }
    return instance;
}
public  Connection getConnection() {
    return connection;
}
}
