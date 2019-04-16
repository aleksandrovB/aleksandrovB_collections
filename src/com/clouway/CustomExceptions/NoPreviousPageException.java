package com.clouway.CustomExceptions;

public class NoPreviousPageException extends Exception {
    public NoPreviousPageException(String message) {
        super(message);
    }
}
