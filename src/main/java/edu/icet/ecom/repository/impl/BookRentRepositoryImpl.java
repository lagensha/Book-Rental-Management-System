package edu.icet.ecom.repository.impl;


import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.dto.BookRentDTO;
import edu.icet.ecom.repository.BookRentRepository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BookRentRepositoryImpl implements BookRentRepository {

    @Override
    public boolean rentBook(BookRentDTO bookRentDTO) throws SQLException {
        Connection connection= DBConnection.getInstance().getConnection();
       PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO  rentbooks (Book_Id,Customer_Id,Rent_Date,Return_Date) VALUES (?,?,?,?)");
        preparedStatement.setString(1, bookRentDTO.getBookId());
        preparedStatement.setString(2, bookRentDTO.getCustomerId());
        preparedStatement.setInt(3,bookRentDTO.getQuantity());

        return  preparedStatement.executeUpdate() > 0;

    }
}
