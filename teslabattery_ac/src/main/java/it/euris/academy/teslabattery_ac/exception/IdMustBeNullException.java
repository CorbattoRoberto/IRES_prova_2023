package it.euris.academy.teslabattery_ac.exception;

public class IdMustBeNullException extends RuntimeException{
    public IdMustBeNullException(){super("Id must be null. You sent a dto whit an id already present");}
    public IdMustBeNullException(String message){super(message);}
}
