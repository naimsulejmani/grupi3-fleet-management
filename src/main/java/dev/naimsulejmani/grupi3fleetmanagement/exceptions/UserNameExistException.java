package dev.naimsulejmani.grupi3fleetmanagement.exceptions;

public class UserNameExistException extends RuntimeException {
    public UserNameExistException(String message) {
        super(message);
    }

    public UserNameExistException() {
        super("Username already exists");
    }
}
