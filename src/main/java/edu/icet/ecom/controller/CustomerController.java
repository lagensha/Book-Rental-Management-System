package edu.icet.ecom.controller;


import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.service.impl.CustomerServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CustomerServiceImpl userService = new CustomerServiceImpl();
    @FXML
    private Button btnCreate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<CustomerDTO> tblUserTable;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnCreateOnAction(ActionEvent event) {
        String id=txtId.getText();
        String name=txtName.getText();
        String email=txtEmail.getText();
        String phoneNumber=txtPhoneNumber.getText();
        CustomerDTO userDTO = new CustomerDTO(id, name, email, phoneNumber);
        userService.addUser(userDTO);
        loadTable();
        restTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id=txtId.getText();
        userService.deleteUser(id);
        loadTable();
        restTable();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        restTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id=txtId.getText();
        String name=txtName.getText();
        String email=txtEmail.getText();
        String phoneNumber=txtPhoneNumber.getText();
        userService.updateUser(name,phoneNumber,email,id);
        loadTable();
        restTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("username"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        loadTable();
        tblUserTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtId.setText(newValue.getId());
                txtName.setText(newValue.getUsername());
                txtEmail.setText(newValue.getEmail());
                txtPhoneNumber.setText(newValue.getPhoneNumber());
            }
        });
    }

    private void loadTable() {

        tblUserTable.setItems(userService.getAllUser());
    }
    public void restTable() {
        txtId.clear();
        txtEmail.clear();
        txtName.clear();
        txtPhoneNumber.clear();
    }
}
