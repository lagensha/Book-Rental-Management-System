package edu.icet.ecom.repository;

import edu.icet.ecom.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    void addUser(CustomerDTO userDTO) throws SQLException;
    void updateUser(String username,String phoneNumber,String email,String id) throws SQLException;
    void deleteUser(String id) throws SQLException;
    public ResultSet viewUsers() throws SQLException;
}
