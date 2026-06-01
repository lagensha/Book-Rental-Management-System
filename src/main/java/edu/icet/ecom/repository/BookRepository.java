package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookDTO;
import javafx.collections.ObservableList;

public interface BookRepository {
    void addBook(BookDTO bookDTO);
    void updateBook(String title,String author,String category,Integer quantity,String id);
    void deleteBook(String id);
    ObservableList<BookDTO> getAllBook();
}
