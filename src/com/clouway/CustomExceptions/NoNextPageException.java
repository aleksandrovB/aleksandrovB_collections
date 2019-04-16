package com.clouway.CustomExceptions;

public class NoNextPageException extends Exception{
    public NoNextPageException(String message) {
        super(message);
    }
}
