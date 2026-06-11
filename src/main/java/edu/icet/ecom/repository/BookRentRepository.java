package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookRentDTO;

import java.sql.SQLException;

public interface BookRentRepository {
boolean rentBook(BookRentDTO bookRentDTO) throws SQLException;
}
