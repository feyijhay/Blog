package com.semicolonafrica.services;


import com.semicolonafrica.data.model.Post;
import com.semicolonafrica.data.model.User;
import com.semicolonafrica.dtos.request.CommentRequest;
import com.semicolonafrica.dtos.request.LoginRequest;
import com.semicolonafrica.dtos.request.PostRequest;
import com.semicolonafrica.dtos.request.RegisterUserRequest;
import com.semicolonafrica.dtos.response.RegisterUserResponse;

import java.util.List;

public interface UsersServices {

    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    void post(PostRequest postRequest, String username);

    long getNumberOfUser();

    User login(LoginRequest loginRequest);

    void comment(CommentRequest commentRequest);
    void logout(String username);

    Object findBy(String username);

    List<Post> findPosts();

    boolean loggedIn(String username);
}
