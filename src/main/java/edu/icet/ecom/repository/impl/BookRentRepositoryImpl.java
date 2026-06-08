package edu.icet.ecom.repository.impl;

import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.BookRentRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRentRepositoryImpl implements BookRentRepository {


    @Override
    public void AddBookRent(BookRentDTO bookRentDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO rentbooks(bookId,customerId,quantity) VALUES (?,?,?)")) {
            preparedStatement.setObject(1, bookRentDTO.getBookId());
            preparedStatement.setObject(2, bookRentDTO.getCustomerId());
            preparedStatement.setObject(3, bookRentDTO.getQuantity());
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public ResultSet getAllBookRent() throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  rentbooks");
        return preparedStatement.executeQuery();
    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
