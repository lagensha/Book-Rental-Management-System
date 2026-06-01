package edu.icet.ecom.repository.impl;

import edu.icet.ecom.dto.BookDTO;
import edu.icet.ecom.repository.BookRepository;
import javafx.collections.ObservableList;


public class BookRepositoryImpl implements BookRepository {
    @Override
    public void addBook(BookDTO bookDTO) {

    }

    @Override
    public void updateBook(String title, String author, String category, Integer quantity, String id) {

    }

    @Override
    public void deleteBook(String id) {

    }

    @Override
    public ObservableList<BookDTO> getAllBook() {
        return null;
    }
}
