package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookRentDTO;

import java.sql.ResultSet;

public interface BookRentRepository {
   void AddBookRent(BookRentDTO bookRentDTO);
    ResultSet getAllBookRent();
   void RentBook(BookRentDTO bookRentDTO);
}
