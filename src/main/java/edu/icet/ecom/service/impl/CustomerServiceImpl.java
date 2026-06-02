package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.repository.impl.CustomerRepositoryImpl;
import edu.icet.ecom.service.CustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepositoryImpl userRepository = new CustomerRepositoryImpl();

    @Override
    public void addUser(CustomerDTO userDTO) {
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
        try {
            userRepository.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<CustomerDTO> getAllUser() {
        ObservableList<CustomerDTO>userDTOObservableList= FXCollections.observableArrayList();
        CustomerRepositoryImpl userRepository1 = new CustomerRepositoryImpl();
        try {
            ResultSet resultSet=userRepository1.viewUsers();
            while (resultSet.next()){
                userDTOObservableList.add(new CustomerDTO(
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
