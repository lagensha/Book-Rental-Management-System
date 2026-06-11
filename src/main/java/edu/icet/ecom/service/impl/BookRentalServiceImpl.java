package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.BookRentRepository;
import edu.icet.ecom.repository.RepositoryFactory;
import edu.icet.ecom.service.BookRentalService;

import java.sql.SQLException;



public class BookRentalServiceImpl implements BookRentalService {
     BookRentRepository bookRentRepository = RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryType.BOOK_RENTAL);

    @Override
    public boolean rentBook(BookRentDTO bookRentDTO) {
        try {
            return bookRentRepository.rentBook(bookRentDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
