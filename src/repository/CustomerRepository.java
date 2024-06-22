package repository;

import config.DatabaseConnection;
import model.Customer;
import queries.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRepository {
    public void addCustomer(Customer customer) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLQueries.INSERT_CUSTOMER)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getSurname());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getPhone());
            pstmt.executeUpdate();
        }
    }
}