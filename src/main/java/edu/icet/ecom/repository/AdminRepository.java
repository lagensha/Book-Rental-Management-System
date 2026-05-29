package edu.icet.ecom.repository;

import edu.icet.ecom.dto.LoginPageDTO;

import java.sql.ResultSet;

public interface AdminRepository {
    void addAdmin(LoginPageDTO loginPageDTO);
    void UpdateAdmin(String username,String password,String email,String id);
    void deleteAdmin(String id);
    public ResultSet viewItems();
}
