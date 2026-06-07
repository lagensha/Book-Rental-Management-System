package edu.icet.ecom.repository;

import java.sql.ResultSet;

public interface BookRentRepository {
   void AddBookRent();
   void getAllBookRent();
   ResultSet RentBook();
}
