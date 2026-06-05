package edu.icet.ecom.controller;

import edu.icet.ecom.db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PlaceOrderBookController implements Initializable {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private ComboBox<?> cmbBookId;

    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private Label lblCount;

    @FXML
    private AnchorPane lblNetTotal;

    @FXML
    private TableView<?> tblBooksOrder;

    @FXML
    private TextField txtQuantity;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        loadCustomerId();
    }

    @FXML

    void cmdBookIdOnAction(ActionEvent event) {

    }

    private void loadCustomerId() {
        ObservableList<String> customerList = FXCollections.observableArrayList();
        String sql = "SELECT Id FROM User";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerList.add(resultSet.getString("Id"));
            }
            cmbCustomerId.setItems(customerList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadBookId(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCustomerId();
    }
}
