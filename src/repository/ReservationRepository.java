package repository;

import config.DatabaseConnection;
import model.Reservation;
import queries.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationRepository {
    public void addReservation(Reservation reservation) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLQueries.INSERT_RESERVATION)) {
            pstmt.setInt(1, reservation.getRoomId());
            pstmt.setInt(2, reservation.getCustomerId());
            pstmt.setDate(3, reservation.getCheckIn());
            pstmt.setDate(4, reservation.getCheckOut());
            pstmt.setTimestamp(5, reservation.getCheckInTime());
            pstmt.setString(6, reservation.getServices());
            pstmt.executeUpdate();
        }
    }

    public void checkOutReservation(int reservationId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLQueries.UPDATE_RESERVATION_CHECKOUT)) {
            pstmt.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
            pstmt.setInt(2, reservationId);
            pstmt.executeUpdate();
        }
    }
}

