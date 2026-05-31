package edu.icet.ecom.service;

import edu.icet.ecom.dto.LoginPageDTO;

import java.sql.SQLException;

public interface AdminService {
    void addAdmin(LoginPageDTO loginPageDTO) throws SQLException;
    void UpdateAdmin(String username,String password,String email,String id) throws SQLException;
    void deleteAdmin(String id) throws SQLException;

}
