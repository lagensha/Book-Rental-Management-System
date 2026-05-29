package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.LoginPageDTO;
import edu.icet.ecom.repository.impl.AdminRepositoryImpl;
import edu.icet.ecom.service.AdminService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
 AdminRepositoryImpl adminRepository= new AdminRepositoryImpl();

 public ObservableList<LoginPageDTO> getAllAdmins() {
     ObservableList<LoginPageDTO> adminList = FXCollections.observableArrayList();
     AdminRepositoryImpl adminRepositoryimpl = new AdminRepositoryImpl();
     try {
         ResultSet resultSet = adminRepositoryimpl.viewAdmin();
         while (resultSet.next()){
             adminList.add(new LoginPageDTO(
             resultSet.getString("Id"),
             resultSet.getString("Username"),
                resultSet.getString("Password"),
                resultSet.getString("Email")
             ));
         }
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
        return adminList;
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
