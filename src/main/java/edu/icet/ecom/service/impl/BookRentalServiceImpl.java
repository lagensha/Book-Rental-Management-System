package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.impl.BookRepositoryImpl;
import edu.icet.ecom.service.BookRentalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRentalServiceImpl implements BookRentalService {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public void AddBookRent(BookRentDTO bookRentDTO) {

    }

    @Override
    public ResultSet getAllBookRent() {
        ObservableList<BookRentDTO> bookRentDTOS = FXCollections.observableArrayList();
        BookRepositoryImpl bookRepository1 = new BookRepositoryImpl();
        try {
            ResultSet resultSet = bookRepository1.getAllBook();
            while (resultSet.next()) {
            bookRentDTOS.add(new BookRentDTO(
                 resultSet.getInt("Book_Id"),
                 resultSet.getInt("Customer_Id"),
                    resultSet.getInt("Quantity")
            ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
