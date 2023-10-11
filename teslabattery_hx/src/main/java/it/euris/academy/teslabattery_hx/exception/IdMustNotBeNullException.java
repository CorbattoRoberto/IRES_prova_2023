package it.euris.academy.teslabattery_hx.exception;

public class IdMustNotBeNullException extends RuntimeException{
    public IdMustNotBeNullException() {
        super("Id must not be null.");
    }

    public IdMustNotBeNullException(String message) {
        super(message);
    }
}
