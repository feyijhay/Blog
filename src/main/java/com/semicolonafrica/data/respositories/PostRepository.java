package com.semicolonafrica.data.respositories;

import com.semicolonafrica.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
