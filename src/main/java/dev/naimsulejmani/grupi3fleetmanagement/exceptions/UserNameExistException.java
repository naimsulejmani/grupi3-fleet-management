package dev.naimsulejmani.grupi3fleetmanagement.exceptions;

import jakarta.persistence.EntityExistsException;

public class UserNameExistException extends EntityExistsException {
    public UserNameExistException(String message) {
        super(message);
    }

    public UserNameExistException() {
        super("Username already exists");
    }
}
