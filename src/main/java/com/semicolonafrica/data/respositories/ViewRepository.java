package com.semicolonafrica.data.respositories;

import com.semicolonafrica.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View,String> {
}
