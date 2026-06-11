package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.BookRentRepository;
import edu.icet.ecom.repository.RepositoryFactory;
import edu.icet.ecom.service.BookRentalService;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.List;


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

    @Override
    public boolean updateStock(List<BookRentDTO> bookRentDTO) {
        for(BookRentDTO bookRentDto :bookRentDTO){
           boolean isUpdate = updateStockSingle(bookRentDto);
           if(!isUpdate){
               return false;
           }
        }
        return true;
    }


    private boolean updateStockSingle(BookRentDTO bookRentDTO) {
        CrudUtil.execute("UPDATE book SET quantity=? WHERE id=?");
    }
}
