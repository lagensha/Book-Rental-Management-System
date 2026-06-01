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
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    BookServiceImpl bookService= new BookServiceImpl();
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
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<BookDTO> tblBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtQuantityDetails;

    @FXML
    private TextField txtTitle;

    @FXML
    void btnCreateOnAction(ActionEvent event) {
        String id = txtTitle.getText();
       String title = txtTitle.getText();
         String author = txtAuthor.getText();
            String category = txtCategory.getText();
            String quantity=txtQuantityDetails.getText();
        BookDTO bookDTO = new BookDTO(id, title, author, category, quantity);
        bookService.addBook(bookDTO);
        loadTable();
        resetTable();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        BookDTO selectedBook = tblBooks.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            bookService.deleteBook(selectedBook.getId());
            loadTable();
            resetTable();
        }
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        resetTable();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        BookDTO selectedBook = tblBooks.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String category = txtCategory.getText();
            Integer quantity = Integer.parseInt(txtQuantityDetails.getText());
            bookService.updateBook(title, author, category, quantity, selectedBook.getId());
            loadTable();
            resetTable();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            loadTable();
            tblBooks.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    txtTitle.setText(newSelection.getTitle());
                    txtAuthor.setText(newSelection.getAuthor());
                    txtCategory.setText(newSelection.getCategory());
                    txtQuantityDetails.setText(String.valueOf(newSelection.getQuantity()));
                }
            });

    }
    public void loadTable() {
        tblBooks.setItems(bookService.getAllBook());
    }
    public void resetTable() {
        txtAuthor.clear();
        txtCategory.clear();
        txtQuantityDetails.clear();
        txtTitle.clear();
    }
}
