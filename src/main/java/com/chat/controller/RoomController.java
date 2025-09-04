package com.chat.controller;

import com.chat.config.AppConstants;
import com.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rooms")
@CrossOrigin(AppConstants.FRONT_END_BASE_URL)
public class RoomController {

    @Autowired
    private RoomService roomService;
//    create roomC

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {

        return roomService.createRoom(roomId);

    }


//    get room

    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {

        return roomService.joinRoom(roomId);
    }


    //    get messages of room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<?> getMessages(@PathVariable String roomId, @RequestParam(value = "page", defaultValue = "0", required = false) int page, @RequestParam(value = "size", defaultValue = "20", required = false) int size) {
        return  roomService.getMessagesInChat(roomId,page,size);
    }

//    @PostMapping("/{roomId}/messages")
//    public ResponseEntity<Message> saveMessage(@PathVariable String roomId, @RequestBody MessageRequest request) {
//        Message savedMessage = roomService.saveMessage(roomId, request);
//        return ResponseEntity.ok(savedMessage);
//    }



}

