package com.chat.controller;


import com.chat.config.AppConstants;
import com.chat.entity.Message;
import com.chat.payload.MessageRequest;
import com.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
public class ChatController {

    @Autowired
    private ChatService chatService;

//    for sending and resiving msg

    @MessageMapping("sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")//
    public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request){
        Message saveMessage= chatService.sendMessage(roomId,request);
        return saveMessage;

    }


}
