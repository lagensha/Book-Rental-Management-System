package edu.icet.ecom.repository.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.repository.BookRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookRepositoryImpl implements BookRepository {
    @Override
    public void addBook(BookDTO bookDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        // use try-with-resources to ensure statement is closed and use consistent table name (lowercase 'book')
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book(id,title, author, category, quantity) VALUES (?,?,?,?,?)")) {
            preparedStatement.setObject(1, bookDTO.getId());
            preparedStatement.setObject(2, bookDTO.getTitle());
            preparedStatement.setObject(3, bookDTO.getAuthor());
            preparedStatement.setObject(4, bookDTO.getCategory());
            preparedStatement.setObject(5, bookDTO.getQuantity());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateBook(String title, String author, String category, Integer quantity, String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book SET Title=?, Author=?, Category=?, Quantity=? WHERE Id=?")) {
            preparedStatement.setObject(1, title);
            preparedStatement.setObject(2, author);
            preparedStatement.setObject(3, category);
            preparedStatement.setObject(4, quantity);
            preparedStatement.setObject(5, id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void deleteBook(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE Id=?")) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public ResultSet getAllBook() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book");
        return preparedStatement.executeQuery();

    }
}
