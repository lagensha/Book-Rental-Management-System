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
    public void addUser(UserDTO userDTO) {

    }

    @Override
    public void updateUser(String username, String phoneNumber, String email, String id) {

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
