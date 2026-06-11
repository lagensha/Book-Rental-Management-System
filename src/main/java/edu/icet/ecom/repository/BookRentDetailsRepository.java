package edu.icet.ecom.repository;

import edu.icet.ecom.dto.BookRentDTO;

import java.sql.SQLException;
import java.util.List;

public interface BookRentDetailsRepository {
    boolean insertRentDetails(List<BookRentDTO>bookRentDTOList) throws SQLException;
}
