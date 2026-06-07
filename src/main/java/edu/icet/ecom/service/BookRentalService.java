package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookRentDTO;

import java.sql.ResultSet;

public interface BookRentalService {
    void AddBookRent(BookRentDTO bookRentDTO);
    ResultSet getAllBookRent();
    void RentBook(BookRentDTO bookRentDTO);
}
