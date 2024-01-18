package org.example.exception;

public class StorageIsFullException extends RuntimeException{
    public StorageIsFullException(String message) {
        super(message);
    }
}
