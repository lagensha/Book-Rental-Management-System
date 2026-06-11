package edu.icet.ecom.controller;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.service.impl.BookRentalServiceImpl;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.print.ServiceUIFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookRentController implements Initializable {

    BookRentalServiceImpl bookRentalService = new BookRentalServiceImpl();

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private ComboBox<String> cmbBookId;

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
    private TableView<BookRentDTO> tblBooksOrder;

    @FXML
    private TextField txtQuantity;

    ArrayList<BookRentDTO> bookRentList = new ArrayList<>();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String bookId = cmbBookId.getValue();
        String customerId = cmbCustomerId.getValue();
        int quantity = Integer.parseInt(txtQuantity.getText());
        bookRentList.add(new BookRentDTO(bookId, customerId, quantity));
        tblBooksOrder.setItems(FXCollections.observableArrayList(bookRentList));
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        ArrayList<BookRentDTO> bookRentArrayList = new ArrayList<>();
        bookRentList.forEach(bookRentDTO -> {
          bookRentArrayList.add(new BookRentDTO(
                  bookRentDTO.getBookId(),
                  bookRentDTO.getCustomerId(),
                  bookRentDTO.getQuantity()
          ));
        });
         BookRentDTO bookRentDTO = new BookRentDTO(
                cmbBookId.getValue(),
                cmbCustomerId.getValue(),
                Integer.parseInt(txtQuantity.getText())
        );

    }

    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        loadCustomerId();
    }

    @FXML
    void cmdBookIdOnAction(ActionEvent event) {
        loadBookId();
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

    private void loadBookId() {
        ObservableList<String> bookIdList = FXCollections.observableArrayList();
        String sql = "SELECT Id FROM book";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookIdList.add(resultSet.getString("Id"));
            }
            cmbBookId.setItems(bookIdList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBookId();
        loadCustomerId();

        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblBooksOrder.getSelectionModel().selectedItemProperty().addListener(((observableValue, bookRentDTO, t1) -> {
            tblBooksOrder.setItems(FXCollections.observableArrayList(bookRentList));
            if (t1 != null) {
                cmbBookId.setValue(t1.getBookId());
                cmbCustomerId.setValue(t1.getCustomerId());
                txtQuantity.setText(String.valueOf(t1.getQuantity()));
            }
        }));

    }
}