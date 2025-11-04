package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DashBoardController {

    public void addRoomDetails(String roomId, String type, double pricePerNight, int maxGuests, boolean availability, String description, int floor) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_system", "root", "1234");

            String SQL = "INSERT INTO rooms VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, roomId);
            preparedStatement.setObject(2, type);
            preparedStatement.setObject(3, pricePerNight);
            preparedStatement.setObject(4, maxGuests);
            preparedStatement.setObject(5, availability);
            preparedStatement.setObject(6, description);
            preparedStatement.setObject(7, floor);

            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteRoomDetails(String roomId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_system", "root", "1234");

            PreparedStatement pstm = connection.prepareStatement("DELETE FROM rooms WHERE room_id = ?");


            pstm.setObject(1,roomId);
            pstm.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

