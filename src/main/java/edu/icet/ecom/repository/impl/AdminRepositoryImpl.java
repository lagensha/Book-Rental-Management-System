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
    public void addAdmin(LoginPageDTO loginPageDTO) {

    }

    @Override
    public void UpdateAdmin(String username, String password, String email, String id) {

    }

    @Override
    public void deleteAdmin(String id) {

    }
}
