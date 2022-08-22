package com.example.stomp.repository;

import com.example.stomp.entity.Room;

import java.util.List;

public interface RoomRepository {
    List<Room> findAllRooms();
    Room findRoomById(String id);
    Room createRoom(String name);
}
