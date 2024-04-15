package com.semicolonafrica.services;

import com.semicolonafrica.data.respositories.UserRepository;
import com.semicolonafrica.dtos.request.LoginRequest;
import com.semicolonafrica.dtos.request.RegisterUserRequest;
import com.semicolonafrica.exception.UsernameExistsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UsersServicesImplTest {

@Autowired
private UsersServices usersServices;
@Autowired
private UserRepository userRepository;

    @Test
    void register() {
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            userRepository.deleteAll();
            registerUserRequest.setUsername("username");
            registerUserRequest.setPassword("password");
            registerUserRequest.setFirstName("firstName");
            registerUserRequest.setLastName("lastName");
            usersServices.register(registerUserRequest);
            assertEquals(1, usersServices.getNumberOfUser());
    }

    @Test
    public void testThat2UserCanRegister() {
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Jhay");
        registerUserRequest.setPassword("1111");
        registerUserRequest.setFirstName("Jumoke");
        registerUserRequest.setLastName("Joseph");
        usersServices.register(registerUserRequest);

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setUsername("Jummy");
        registerUserRequest1.setPassword("2222");
        registerUserRequest1.setFirstName("Feyi");
        registerUserRequest1.setLastName("Jumoke");
        usersServices.register(registerUserRequest1);

        assertEquals(2, usersServices.getNumberOfUser());
    }

    @Test
    public void testThatUserCannotRegisterWithTheSameUsername_ThrowsUsernameExistsException() {
        userRepository.deleteAll();;
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");
        usersServices.register(registerUserRequest);


        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setUsername("username");
        registerUserRequest1.setPassword("password");
        registerUserRequest1.setFirstName("firstName");
        registerUserRequest1.setLastName("lastName");
        assertThrows(UsernameExistsException.class, () -> usersServices.register(registerUserRequest1));
    }

    @Test
    public void testThatUserCanLogin(){
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");
        usersServices.register(registerUserRequest);


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        usersServices.login(loginRequest);
        assertTrue(usersServices.loggedIn("username"));
        assertEquals(1, usersServices.getNumberOfUser());
    }

    @Test
    public void testThatUserCanLogout() {
        userRepository.deleteAll();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("username");
        registerUserRequest.setPassword("password");
        registerUserRequest.setFirstName("firstName");
        registerUserRequest.setLastName("lastName");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        usersServices.login(loginRequest);
        assertEquals(1, usersServices.getNumberOfUser());

        usersServices.logout("username");
        assertFalse(usersServices.loggedIn("username"));
    }


//    @Test
//    void post() {
//    }
//
//    @Test
//    void getNumberOfUser() {
//    }
//
//    @Test
//    void login() {
//    }
//
//    @Test
//    void comment() {
//    }
//
//    @Test
//    void logout() {
//    }
//
//    @Test
//    void findBy() {
//    }
//
//    @Test
//    void findPosts() {
//    }
}