package com.chat.repo;

import com.chat.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepo extends MongoRepository<Message,String> {
}
