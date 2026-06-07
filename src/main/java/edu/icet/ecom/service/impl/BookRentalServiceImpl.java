package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.impl.BookRepositoryImpl;
import edu.icet.ecom.service.BookRentalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRentalServiceImpl implements BookRentalService {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public void AddBookRent(BookRentDTO bookRentDTO) {

    }

    @Override
    public ResultSet getAllBookRent() {
        return null;
    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
