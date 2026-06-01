package edu.icet.ecom.repository.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void addUser(UserDTO userDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO User(id,username, email, phoneNumber) VALUES (?,?,?,?)");
        preparedStatement.setObject(1,userDTO.getId());
        preparedStatement.setObject(2,userDTO.getUsername());
        preparedStatement.setObject(3,userDTO.getEmail());
        preparedStatement.setObject(4,userDTO.getPhoneNumber());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUser(String username, String phoneNumber, String email, String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE User SET username=?, email=?, phoneNumber=? WHERE id=?");
        preparedStatement.setObject(1,username);
        preparedStatement.setObject(2,email);
        preparedStatement.setObject(3,phoneNumber);
        preparedStatement.setObject(4,id);
        preparedStatement.executeUpdate();


    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public ResultSet viewUsers() throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM User");
        return preparedStatement.executeQuery();
    }
}
