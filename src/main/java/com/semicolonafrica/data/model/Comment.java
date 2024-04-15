package com.semicolonafrica.data.model;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Comment {

    private String postId;

    private String commenterUsername;
    private String comment;

    private LocalDateTime timeOfComment = LocalDateTime.now();

}
