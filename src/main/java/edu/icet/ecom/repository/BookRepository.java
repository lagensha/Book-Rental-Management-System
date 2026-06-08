package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookRepository {
    void addBook(BookDTO bookDTO) throws SQLException;
    void updateBook(String title,String author,String category,Integer quantity,String id) throws SQLException;
    void deleteBook(String id) throws SQLException;
    ResultSet getAllBook() throws SQLException;
}
