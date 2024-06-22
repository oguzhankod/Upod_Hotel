package repository;

import config.DatabaseConnection;
import model.Room;
import queries.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomRepository {
    public void addRoom(Room room) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQLQueries.INSERT_ROOM)) {
            pstmt.setInt(1, room.getCapacity());
            pstmt.setString(2, room.getDescription());
            pstmt.setBoolean(3, room.isSeaView());
            pstmt.setBoolean(4, room.isJacuzzi());
            pstmt.setBoolean(5, room.isSafe());
            pstmt.executeUpdate();
        }
    }
}