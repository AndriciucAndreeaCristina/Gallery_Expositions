package pao.services.impl.floorplan;

import pao.model.floorplan.Room;
import pao.services.interfaces.floorplan.RoomInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RoomInterfaceImplementation implements RoomInterface {
    private static HashMap<Integer, List<Room>> roomsList = new HashMap<>();
    @Override
    public Optional<Room> getRoomById(UUID id) {
        for (List<Room> list : roomsList.values())
        {
            for (Room room: list)
            {
                if (room.getId().equals(id))
                {
                    return Optional.of(room);
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Room> getRoomByNumber(Integer nr) {
        for (List<Room> list : roomsList.values())
        {
            for (Room room: list)
            {
                if (room.getNumber().equals(nr))
                {
                    return Optional.of(room);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Room> getRoomsByFloor(Integer floor) {
        return roomsList.get(floor);
    }

    @Override
    public void addRoom(Room room) {
        roomsList.get(room.getFloor()).add(room);
    }

    @Override
    public void removeRoomById(UUID id) {
        HashMap<Integer, List<Room>> partial = new HashMap<>();
        for (List<Room> list: roomsList.values())
        {
            for (Room room : list)
            {
                if (!room.getId().equals(id))
                {
                    partial.get(room.getFloor()).add(room);
                }
            }
        }
        roomsList = partial;
    }

    @Override
    public void modifyRoomById(UUID id, Room room) {
        removeRoomById(id);
        addRoom(room);
    }
}
