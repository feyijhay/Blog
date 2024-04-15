package com.semicolonafrica.exception;

public class UsernameExistsException extends BloggAppException{
    public UsernameExistsException(String statement){
        super(statement);
    }
}
