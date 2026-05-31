package edu.icet.ecom.service;

import edu.icet.ecom.dto.UserDTO;

import java.sql.ResultSet;

public interface UserService {
    void addUser(UserDTO userDTO);
    void updateUser(String username,String phoneNumber,String email,String id);
    void deleteUser(String id);

}
