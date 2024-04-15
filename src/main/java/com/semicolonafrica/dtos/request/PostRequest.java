package com.semicolonafrica.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostRequest {
    private String title;
    private String context;
    private String id;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
