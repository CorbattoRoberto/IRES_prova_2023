package it.euris.javaacademy.teslabattery_dfa.exception;

public class IdMustBeNull extends RuntimeException{

    public IdMustBeNull() {
        super("Id needs to be null while doing insert");
    }
    public IdMustBeNull(String message) {
        super(message);
    }

}
