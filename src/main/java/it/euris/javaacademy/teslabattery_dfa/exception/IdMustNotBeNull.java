package it.euris.javaacademy.teslabattery_dfa.exception;

public class IdMustNotBeNull extends RuntimeException{

    public IdMustNotBeNull() {
        super("Cant update without id");
    }
    public IdMustNotBeNull(String message) {
        super(message);
    }

}
