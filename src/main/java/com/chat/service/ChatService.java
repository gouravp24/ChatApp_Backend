package com.chat.service;

import com.chat.entity.Message;
import com.chat.entity.Room;
import com.chat.payload.MessageRequest;
import com.chat.repo.MessageRepo;
import com.chat.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    @Autowired
    RoomRepo roomRepo;


    @Autowired
    MessageRepo messageRepo;



    public Message sendMessage(String roomId, MessageRequest request) {
      Room room =roomRepo.findByRoomId(request.getRoomId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimespam(LocalDateTime.now());

   Message saveMessage= messageRepo.save(message);
//        if (room!=null){
//            room.getMessages().add(message);
//            roomRepo.save(room);
//        }else {
//            throw new RuntimeException("Room not found !!");
//        }

        return saveMessage;

    }
}
