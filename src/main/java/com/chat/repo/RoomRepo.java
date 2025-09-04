package com.chat.repo;

import com.chat.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends MongoRepository<Room ,String> {

//    get using room id
    Room findByRoomId(String roomId);

}
