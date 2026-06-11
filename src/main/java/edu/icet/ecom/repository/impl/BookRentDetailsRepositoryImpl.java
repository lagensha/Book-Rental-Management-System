package edu.icet.ecom.repository.impl;

import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.BookRentDetailsRepository;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.List;

public class BookRentDetailsRepositoryImpl implements BookRentDetailsRepository {
    @Override
    public boolean insertRentDetails(List<BookRentDTO> bookRentDTOList) throws SQLException {
        for (BookRentDTO bookRentDTO: bookRentDTOList) {
            boolean insert =insertRentDetails(bookRentDTO);
            if (!insert) {
                return false;
            }
        }
        return true;
    }

    public boolean insertRentDetails(BookRentDTO bookRentDTO) throws SQLException {
        return CrudUtil.execute("INSERT INTO rentbooks VALUES (?,?,?,?)",
                bookRentDTO.getBookId(),
                bookRentDTO.getCustomerId(),
                bookRentDTO.getQuantity()
        );
    }

    @Override
    public boolean isUpdate(List<BookRentDTO> bookRentDTOList) throws SQLException {
        for(BookRentDTO bookRentDto :bookRentDTOList){
            boolean isUpdate = updateStockSingle(bookRentDto);
            if(!isUpdate){
                return false;
            }
        }
        return true;
    }

private boolean updateStockSingle(BookRentDTO bookRentDTO) throws SQLException {
    return CrudUtil.execute("UPDATE book SET quantity= quantity-? WHERE id=?",bookRentDTO.getQuantity(),bookRentDTO.getBookId());

}
}
