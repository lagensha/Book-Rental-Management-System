package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public interface BookRentalService {
    void AddBookRent(BookRentDTO bookRentDTO);
    ObservableList<BookRentDTO> getAllUser();
    void RentBook(BookRentDTO bookRentDTO);
}
