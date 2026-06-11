package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.impl.BookRentRepositoryImpl;
import edu.icet.ecom.service.BookRentalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRentalServiceImpl implements BookRentalService {


    @Override
    public boolean rentBook(BookRentDTO bookRentDTO) {
        System.out.println(bookRentDTO);
        return false;
    }
}
