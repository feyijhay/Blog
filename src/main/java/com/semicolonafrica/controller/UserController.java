package com.semicolonafrica.controller;

import com.semicolonafrica.dtos.request.RegisterUserRequest;
import com.semicolonafrica.dtos.response.ApiResponse;
import com.semicolonafrica.dtos.response.RegisterUserResponse;
import com.semicolonafrica.exception.BloggAppException;
import com.semicolonafrica.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class UserController {

    @Autowired
    private UsersServices usersServices;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        try {
            RegisterUserResponse result = usersServices.register(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED );
        }
        catch (BloggAppException e){
            return new ResponseEntity<>(new ApiResponse(false,  e.getMessage()), BAD_REQUEST);
        }
    }




}
