package edu.icet.ecom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingPageController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignIn;

    Stage stage = new Stage();
    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {
            stage.setScene(FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {

    }

}
