package edu.icet.ecom.repository.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.repository.BookRepository;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookRepositoryImpl implements BookRepository {
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
    public ResultSet getAllBook() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Book");
        return preparedStatement.executeQuery();

    }
}
