package pao.services.interfaces.floorplan;

import pao.model.floorplan.Room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomInterface {
    Optional <Room> getRoomById(UUID id);
    Optional <Room> getRoomByNumber(Integer nr);
    List<Room> getRoomsByFloor(Integer floor);
    void addRoom(Room room);
    void removeRoomById(UUID id);
    void modifyRoomById(UUID id, Room room);
}
