package edu.icet.ecom.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static DBConnection instance;
private Connection connection;

private DBConnection(){
    connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom_db","root","password");
}
}
