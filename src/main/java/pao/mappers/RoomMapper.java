package pao.mappers;

import pao.generics.Mapper;
import pao.model.floorplan.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RoomMapper implements Mapper<Room> {
    private static final RoomMapper INSTANCE = new RoomMapper();

    public static RoomMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Room> mapToClass(ResultSet resultSet) throws SQLException {
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

    @Override
    public List<Room> mapToClassList(ResultSet resultSet) throws SQLException {
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
