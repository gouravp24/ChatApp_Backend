package com.chat.service;

import com.chat.entity.Message;
import com.chat.entity.Room;
import com.chat.payload.MessageRequest;
import com.chat.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class RoomService {

    @Autowired
     RoomRepo roomRepo;

//    public RoomService(RoomRepo roomRepo) {
//        this.roomRepo = roomRepo;
//    }

    public ResponseEntity<?> createRoom(String roomId) {

        if (roomRepo.findByRoomId(roomId) != null) {
            //room is already there
            return ResponseEntity.badRequest().body("Room already exists!");

        }


        //create new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomRepo.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);

    }

    public ResponseEntity<?> joinRoom(String roomId) {
        Room room = roomRepo.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest()
                    .body("Room not found!!");
        }
        return ResponseEntity.ok(room);


    }


    public ResponseEntity<List<Message>> getMessagesInChat(String roomId, int page, int size) {
        Room room = roomRepo.findByRoomId(roomId);

        if (room == null) {

            return ResponseEntity.badRequest().build();
        }

//        get messages  and pegination

        //get messages :
        //pagination
        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        List<Message> paginatedMessages = messages.subList(start, end);
        return ResponseEntity.ok(paginatedMessages);



    }


//    public Message saveMessage(String roomId, MessageRequest request) {
//        Message message = new Message();
//        message.setSender(request.getSender());
//        message.setContent(request.getContent());
//        message.setTimespam(new LocalDateTime());
//
//        // Save to database
//        return roomRepo.save(message);
//    }
}
