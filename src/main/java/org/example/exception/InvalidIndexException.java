package org.example.exception;

public class InvalidIndexException extends RuntimeException{
    public InvalidIndexException(String message) {
        super(message);
    }
}
