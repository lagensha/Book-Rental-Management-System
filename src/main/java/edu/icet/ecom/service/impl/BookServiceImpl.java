package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.repository.impl.BookRepositoryImpl;
import edu.icet.ecom.service.BookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookServiceImpl implements BookService {
    BookRepositoryImpl bookRepository = new BookRepositoryImpl();
    @Override
    public void addBook(BookDTO bookDTO) {

    }

    @Override
    public void updateBook(String title, String author, String category, Integer quantity, String id) {

    }

    @Override
    public void deleteBook(String id) {

    }

    @Override
    public ObservableList<BookDTO> getAllBook() {
        ObservableList<BookDTO> bookDTOS = FXCollections.observableArrayList();
        BookRepositoryImpl bookRepository1 = new BookRepositoryImpl();
        try {
            ResultSet resultSet = bookRepository1.getAllBook();
            while (resultSet.next()){
                bookDTOS.add(new BookDTO(
                        resultSet.getString("Id"),
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getString("Category"),
                        resultSet.getInt("Quantity")
                ));
            }
            return bookDTOS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
