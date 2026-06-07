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
    public void AddBookRent(BookRentDTO bookRentDTO) {

    }

    @Override
    public ResultSet getAllBookRent() throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();

    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
