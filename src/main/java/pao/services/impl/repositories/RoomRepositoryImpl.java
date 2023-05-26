package pao.services.impl.repositories;

import pao.config.DatabaseConfiguration;
import pao.mappers.RoomMapper;
import pao.model.floorplan.Room;
import pao.services.interfaces.repositories.RoomRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RoomRepositoryImpl implements RoomRepository {
    private static final RoomMapper roomMapper = RoomMapper.getInstance();
    @Override
    public Optional<Room> getRoomById(UUID id) {
        String selectSql = "SELECT * FROM room WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return roomMapper.mapToRoomClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Room> getRoomByNumber(Integer nr) {
        String selectSql = "SELECT * FROM room WHERE number = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, nr);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return roomMapper.mapToRoomClass(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Room> getRoomsByFloor(Integer floor) {
        List<Room> rooms = new ArrayList<>();
        String selectSql = "SELECT * FROM room WHERE floor = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, floor);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rooms = RoomMapper.mapToRoomClassList(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    @Override
    public void addRoom(Room room) {
        String insertSql = "INSERT INTO room (id, number, floor) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, room.getId().toString());
            preparedStatement.setInt(2, room.getNumber());
            preparedStatement.setInt(3, room.getFloor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRoomById(UUID id) {
        String deleteSql = "DELETE FROM room WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyRoomById(UUID id, Room room) {
        String updateSql = "UPDATE room SET number = ?, floor = ? WHERE id = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setInt(2, room.getFloor());
            preparedStatement.setString(3, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
