package com.semicolonafrica.dtos.request;

import lombok.Data;

@Data
public class CommentRequest {

    private String CommenterUsername;
    private String postId;
    private String comment;
}
