package com.example.stomp.repository;

import com.example.stomp.entity.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryRoomRepository implements RoomRepository{
    private HashMap<String, Room> rooms = new HashMap<>();

    @Override
    public List<Room> findAllRooms() {
        List<Room> res = new ArrayList<>();
        for (Room room : rooms.values()){
            res.add(room);
        }
        return res;
    }

    @Override
    public Room findRoomById(String id) {
        return rooms.get(id);
    }

    @Override
    public Room createRoom(String name) {
        Room room = new Room(name);
        return room;
    }
}
