package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.service.BookRentalService;


public class BookRentalServiceImpl implements BookRentalService {


    @Override
    public boolean rentBook(BookRentDTO bookRentDTO) {
        System.out.println(bookRentDTO);
        return false;
    }
}
