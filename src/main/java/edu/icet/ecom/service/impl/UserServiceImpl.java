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
        try {
            userRepository.addUser(userDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUser(String username, String phoneNumber, String email, String id) {
        try {
            userRepository.updateUser(username,phoneNumber,email,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public ObservableList<UserDTO> getAllUser() {
        ObservableList<UserDTO>userDTOObservableList= FXCollections.observableArrayList();
        UserRepositoryImpl userRepository1 = new UserRepositoryImpl();
        try {
            ResultSet resultSet=userRepository1.viewUsers();
            while (resultSet.next()){
                userDTOObservableList.add(new UserDTO(
                        resultSet.getString("Id"),
                        resultSet.getString("Username"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDTOObservableList;
    }

}
