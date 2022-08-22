package com.example.stomp.controller;

import com.example.stomp.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class MessageController {
    
    private final SimpMessagingTemplate template;

    @MessageMapping(value = "/chat/enter")
    public void enter(MessageDto message){
        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(MessageDto message){
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
