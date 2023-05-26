package pao.mappers;

import pao.model.floorplan.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RoomMapper {
    private static final RoomMapper INSTANCE = new RoomMapper();

    public static RoomMapper getInstance() {
        return INSTANCE;
    }

    public Optional<Room> mapToRoomClass(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Room.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .floor(resultSet.getInt(2))
                            .number(resultSet.getInt(3))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Room> mapToRoomClassList(ResultSet resultSet) throws SQLException {
        List<Room> exampleClassList = new ArrayList<>();
        while (resultSet.next()) {
            exampleClassList.add(
                    Room.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .floor(resultSet.getInt(2))
                            .number(resultSet.getInt(3))
                            .build()
            );
        }

        return exampleClassList;
    }
}
