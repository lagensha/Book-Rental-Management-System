package edu.icet.ecom.repository.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.LoginPageDTO;
import edu.icet.ecom.service.AdminService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepositoryImpl implements AdminService {
    public ResultSet viewAdmin() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM Admin");
        return preparedStatement.executeQuery();
        }

    @Override
    public void addAdmin(LoginPageDTO loginPageDTO) throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Admin(id,  Username, email, password) VALUES (?,?,?,?)");
        preparedStatement.setObject(1,loginPageDTO.getId());
        preparedStatement.setObject(2,loginPageDTO.getUsername());
        preparedStatement.setObject(3,loginPageDTO.getEmail());
        preparedStatement.setObject(4,loginPageDTO.getPassword());
        preparedStatement.executeUpdate();

    }

    @Override
    public void UpdateAdmin(String username, String password, String email, String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Admin SET Username=?, Email=?,Password=? WHERE Id=?");
        preparedStatement.setObject(1,username);
        preparedStatement.setObject(2,email);
        preparedStatement.setObject(3,password);
        preparedStatement.setObject(4,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteAdmin(String id) {

    }
}
