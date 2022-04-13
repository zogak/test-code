package com.example.socketTest.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketHandler extends TextWebSocketHandler{
	private List<WebSocketSession> players = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		System.out.println("Player entered");
		players.add(session);
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String receivedMessage = message.getPayload();
		System.out.println(receivedMessage);
		
		for (WebSocketSession player : players) {
			player.sendMessage(new TextMessage(receivedMessage));
		}
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		System.out.println("Player left");
		players.remove(session);
	}
	
	
}
