package se.magnus.microservices.util.exceptions;

public class InvalidInputException extends RuntimeException  {
    public InvalidInputException(String s) {
        super(s);
    }
}
