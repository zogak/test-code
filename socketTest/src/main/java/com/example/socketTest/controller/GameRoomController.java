package com.example.socketTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRoomController {
	
	@GetMapping("/test")
	public void gameRoom() {
		
	}
}
