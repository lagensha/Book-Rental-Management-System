package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface BookService {
    void addBook(BookDTO bookDTO);
    void updateBook(String title,String author,String category,Integer quantity,String id);
    void deleteBook(String id);
    ObservableList<BookDTO> getAllBook();
}
