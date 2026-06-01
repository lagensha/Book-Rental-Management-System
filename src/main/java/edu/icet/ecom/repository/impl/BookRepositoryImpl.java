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
    public void addBook(BookDTO bookDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Book(id,title, author, category, quantity) VALUES (?,?,?,?,?)");
        preparedStatement.setObject(1,bookDTO.getId());
        preparedStatement.setObject(2,bookDTO.getTitle());
        preparedStatement.setObject(3,bookDTO.getAuthor());
        preparedStatement.setObject(4,bookDTO.getCategory());
        preparedStatement.setObject(5,bookDTO.getQuantity());
        preparedStatement.executeUpdate();
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
