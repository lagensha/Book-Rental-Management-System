package edu.icet.ecom.service;

import java.sql.ResultSet;

public interface BookRentalService {
    void AddBookRent();
    void getAllBookRent();
    ResultSet RentBook();
}
