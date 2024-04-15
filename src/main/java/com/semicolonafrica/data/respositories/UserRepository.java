package com.semicolonafrica.data.respositories;

import com.semicolonafrica.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    User findUserByUsername(String username);
}
