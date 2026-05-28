package edu.icet.ecom.repository;

import edu.icet.ecom.dto.LoginPageDTO;

public interface AdminRepository {
    void addAdmin(LoginPageDTO loginPageDTO);
    void UpdateAdmin(String username,String password,String email,String id);
    void deleteAdmin(String id);

}
