package dev.naimsulejmani.grupi3fleetmanagement.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super("Wrong password");
    }
}
