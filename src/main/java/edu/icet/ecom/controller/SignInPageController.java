package edu.icet.ecom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInPageController {

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    Stage stage = new Stage();
    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        try {
            stage.setScene(FXMLLoader.load(getClass().getResource("/view/UserPage.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

}
