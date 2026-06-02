package edu.icet.ecom.repository.impl;


import edu.icet.ecom.db.DBConnection;
import edu.icet.ecom.repository.PlaceOrderBookRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderBookRepositoryImpl implements PlaceOrderBookRepository {

    @Override
    public void loadCustomer(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM User");
            ResultSet resultSet =preparedStatement.executeQuery();
            ObservableList<String> customerIds = FXCollections.observableArrayList();
            while (resultSet.next()) {
             customerIds.add(resultSet.getString("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void loadBook(String id) {

    }
}
