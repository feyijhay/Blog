package com.semicolonafrica.data.respositories;


import com.semicolonafrica.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
}
