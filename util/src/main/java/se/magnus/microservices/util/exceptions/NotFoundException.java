package se.magnus.microservices.util.exceptions;

public class NotFoundException extends RuntimeException  {
    public NotFoundException(String s) {
        super(s);
    }
}
