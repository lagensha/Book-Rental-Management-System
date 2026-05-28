package edu.icet.ecom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPageController {

    @FXML
    private Button btnLogin;

    @FXML
    private ComboBox<?> cmbRole;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    Stage stage= new Stage();
    @FXML
    void btnLoginOnAction(ActionEvent event) {
//stage.setScene(new Scene(FXMLLoader.load(getClass().getResource())));
    }

}
