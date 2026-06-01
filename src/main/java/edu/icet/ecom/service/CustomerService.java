package edu.icet.ecom.service;

import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CustomerService {
    void addUser(CustomerDTO userDTO);
    void updateUser(String username,String phoneNumber,String email,String id);
    void deleteUser(String id);
    ObservableList<CustomerDTO> getAllUser();
}
