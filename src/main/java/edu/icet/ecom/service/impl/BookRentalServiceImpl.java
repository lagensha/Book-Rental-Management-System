package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.impl.BookRepositoryImpl;
import edu.icet.ecom.service.BookRentalService;

import java.sql.ResultSet;

public class BookRentalServiceImpl implements BookRentalService {

    BookRepositoryImpl bookRepository = new BookRepositoryImpl();

    @Override
    public void AddBookRent(BookRentDTO bookRentDTO) {

    }

    @Override
    public ResultSet getAllBookRent() {

    }

    @Override
    public void RentBook(BookRentDTO bookRentDTO) {

    }
}
