package edu.icet.ecom.service;

import edu.icet.ecom.dto.LoginPageDTO;

public interface AdminService {
    void addAdmin(LoginPageDTO loginPageDTO);
    void UpdateAdmin(String username,String password,String email,String id);
    void deleteAdmin(String id);

}
