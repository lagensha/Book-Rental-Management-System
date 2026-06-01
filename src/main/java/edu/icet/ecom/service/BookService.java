package edu.icet.ecom.service;

import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface BookService {
    void addBook(CustomerDTO userDTO);
    void updateBook();
    void deleteBook(String id);
    ObservableList<BookDTO> getAllBook();
}
