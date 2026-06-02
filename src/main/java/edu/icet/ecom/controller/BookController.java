package edu.icet.ecom.controller;

import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.service.impl.BookServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class BookController implements Initializable {

    BookServiceImpl bookService = new BookServiceImpl();
    @FXML
    private Button btnCreate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<BookDTO> tblBook;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtQuantityDetails;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnCreateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String category = txtCategory.getText();
        String quantity = txtQuantityDetails.getText();

        BookDTO bookDTO = new BookDTO(id, title, author, category, quantity);
        bookService.addBook(bookDTO);
        loadTable();
        resetTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();
        bookService.deleteBook(id);
        loadTable();
        resetTable();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        resetTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id=txtId.getText();
        String title=txtTitle.getText();
        String author=txtAuthor.getText();
        String category=txtCategory.getText();
        String quantity=txtQuantityDetails.getText();
        bookService.updateBook(title,author,category,Integer.valueOf(quantity),id);
        loadTable();
        resetTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("author"));
        colCategory.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("category"));
        colQuantity.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
        loadTable();
        tblBook.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(newSelection.getId());
                txtTitle.setText(newSelection.getTitle());
                txtAuthor.setText(newSelection.getAuthor());
                txtCategory.setText(newSelection.getCategory());
                txtQuantityDetails.setText(newSelection.getQuantity());
            }
        });

    }
    public void loadTable() {
        tblBook.setItems(bookService.getAllBook());
    }
    public void resetTable() {
        txtAuthor.clear();
        txtCategory.clear();
        txtQuantityDetails.clear();
        txtTitle.clear();
    }
}
