package edu.icet.ecom.service;

import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface CustomerService {
    void addUser(CustomerDTO userDTO);
    void updateUser(String username,String phoneNumber,String email,String id);
    void deleteUser(String id);
    ObservableList<CustomerDTO> getAllUser();
    List<String> loadCustomer();
}
