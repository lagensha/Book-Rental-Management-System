package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.UserDTO;
import edu.icet.ecom.repository.impl.UserRepositoryImpl;
import edu.icet.ecom.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    UserRepositoryImpl userRepository = new UserRepositoryImpl();

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
    public ObservableList<UserDTO> getAllAdmins() {
        ObservableList<UserDTO>userDTOObservableList= FXCollections.observableArrayList();
        UserRepositoryImpl userRepository1 = new UserRepositoryImpl();
        try {
            ResultSet resultSet=userRepository1.viewUsers();
            while (resultSet.next()){
                userDTOObservableList.add(new UserDTO(
                        resultSet.getString("Id"),
                        resultSet.getString("Username"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDTOObservableList;
    }

}
