package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.impl.BookRentRepositoryImpl;
import edu.icet.ecom.service.BookRentalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRentalServiceImpl implements BookRentalService {

  BookRentRepositoryImpl bookRentRepository = new BookRentRepositoryImpl();
    @Override
    public void AddBookRent(BookRentDTO bookRentDTO) {
        try {
            bookRentRepository.AddBookRent(bookRentDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<BookRentDTO> getAllUser(){
       ObservableList<BookRentDTO> rentDTOObservableList = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = bookRentRepository.getAllBookRent();
            while (resultSet.next()){
                rentDTOObservableList.add(new BookRentDTO(
                        resultSet.getString("bookId"),
                        resultSet.getString("customerId"),
                        resultSet.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rentDTOObservableList;
    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
