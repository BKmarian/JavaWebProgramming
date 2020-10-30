package exceptions;

//Although is not a good practice to have an exceptions package :P
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
