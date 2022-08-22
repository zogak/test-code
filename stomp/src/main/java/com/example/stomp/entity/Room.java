package com.example.stomp.entity;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Room {
    private String roomId;
    private String roomName;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public Room(String roomName) {
        this.roomName = roomName;
        this.roomId = UUID.randomUUID().toString();
    }
}
