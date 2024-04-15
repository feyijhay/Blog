package com.semicolonafrica.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
