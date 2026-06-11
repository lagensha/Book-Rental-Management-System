package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public interface BookRentalService {
    boolean rentBook(BookRentDTO bookRentDTO);
}
