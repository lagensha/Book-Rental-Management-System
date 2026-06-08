package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookRentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookRentRepository {
   void AddBookRent(BookRentDTO bookRentDTO) throws SQLException;
    ResultSet getAllBookRent() throws SQLException;
   void RentBook(BookRentDTO bookRentDTO);
}
