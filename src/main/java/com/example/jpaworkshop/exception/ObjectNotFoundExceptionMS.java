package com.example.jpaworkshop.exception;

public class ObjectNotFoundExceptionMS extends RuntimeException{

    public ObjectNotFoundExceptionMS(String message){
        super(message);
    }
    public ObjectNotFoundExceptionMS(){
        super("object not found");
    }
}
