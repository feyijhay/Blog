package com.semicolonafrica.services;



import com.semicolonafrica.data.model.Post;
import com.semicolonafrica.data.model.User;
import com.semicolonafrica.data.respositories.UserRepository;
import com.semicolonafrica.dtos.request.CommentRequest;
import com.semicolonafrica.dtos.request.LoginRequest;
import com.semicolonafrica.dtos.request.PostRequest;
import com.semicolonafrica.dtos.request.RegisterUserRequest;
import com.semicolonafrica.dtos.response.RegisterUserResponse;
import com.semicolonafrica.exception.UsernameExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UsersServicesImpl implements UsersServices{
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setFirstName(registerUserRequest.getFirstName());
         if(userRepository.findUserByUsername(user.getUsername()) != null) throw new UsernameExistsException("Username already taken");
        userRepository.findUserByUsername(user.getUsername());

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setFirstName(registerUserResponse.getFirstName());
        registerUserResponse.setLastName(registerUserResponse.getLastName());
        registerUserResponse.setUsername(registerUserResponse.getUsername());
        registerUserResponse.setPassword(registerUserResponse.getPassword());

        userRepository.save(user);
        return registerUserResponse;
    }

    @Override
    public void post(PostRequest postRequest, String username) {

    }

    @Override
    public long getNumberOfUser() {
        return  userRepository.count();
    }

    @Override
    public User login(LoginRequest loginRequest) {
        User user = userRepository.findUserByUsername(loginRequest.getUsername());
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        user.setLoggedIn(true);
        userRepository.save(user);

        return user;


    }

    @Override
    public void comment(CommentRequest commentRequest) {

    }

    @Override
    public void logout(String username) {
        User user = userRepository.findUserByUsername("username");
        user.setLoggedIn(false);
        userRepository.save(user);
    }

    @Override
    public Object findBy(String username) {
        return null;
    }

    @Override
    public List<Post> findPosts() {
        return null;
    }

    @Override
    public boolean loggedIn(String username) {
        return true;
    }


}
