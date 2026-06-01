package edu.icet.ecom.repository;

import edu.icet.ecom.dto.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserRepository {
    void addUser(UserDTO userDTO) throws SQLException;
    void updateUser(String username,String phoneNumber,String email,String id) throws SQLException;
    void deleteUser(String id);
    public ResultSet viewUsers() throws SQLException;
}
