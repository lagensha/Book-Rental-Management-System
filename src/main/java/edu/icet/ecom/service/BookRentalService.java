package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.util.List;

public interface BookRentalService {
    boolean rentBook(BookRentDTO bookRentDTO);
    boolean updateStock(List<BookRentDTO> bookRentDTO);

}
