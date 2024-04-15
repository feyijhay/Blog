package com.semicolonafrica.exception;

public class BloggAppException extends RuntimeException{
   public BloggAppException(String statement){
       super(statement);
   }

}
