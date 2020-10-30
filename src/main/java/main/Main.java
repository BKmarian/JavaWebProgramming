package main;

import config.ProjectConfig;
import exceptions.BookNotFoundException;
import model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class Main {

    public static final Book BROTHERS_KARAMAZOV = new Book("1", "Brothers Karamazov", "Dostoievsky");
    public static final Book CRIME_AND_PUNISHMENT = new Book("2", "Crime and Punishment", "Dostoievsky");
    public static final Book NOTES_FROM_UNDERGROUND = new Book("3", "Notes from Underground", "Dostoievsky");
    public static final Book DEMONS = new Book("4", "Demons", "Dostoievsky");

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BookService bookService = context.getBean(BookService.class);
        bookService.addBook(BROTHERS_KARAMAZOV);
        bookService.removeBook(BROTHERS_KARAMAZOV);
        try {
            bookService.borrowBook(BROTHERS_KARAMAZOV);
        }
        catch(BookNotFoundException e) {

        }
        bookService.addBook(CRIME_AND_PUNISHMENT);
        bookService.borrowBook(CRIME_AND_PUNISHMENT);
        try {
            bookService.borrowBook(CRIME_AND_PUNISHMENT);
        }
        catch(BookNotFoundException e) {

        }
        bookService.returnBook(CRIME_AND_PUNISHMENT);
        bookService.borrowBook(CRIME_AND_PUNISHMENT);
        bookService.addBook(NOTES_FROM_UNDERGROUND);
        bookService.addBook(NOTES_FROM_UNDERGROUND);
        bookService.addBook(NOTES_FROM_UNDERGROUND);
        bookService.borrowBook(NOTES_FROM_UNDERGROUND);
        bookService.borrowBook(NOTES_FROM_UNDERGROUND);
        bookService.borrowBook(NOTES_FROM_UNDERGROUND);
        try {
            bookService.borrowBook(NOTES_FROM_UNDERGROUND);
        }
        catch(BookNotFoundException e) {

        }
        bookService.returnBook(CRIME_AND_PUNISHMENT);
        bookService.addBook(CRIME_AND_PUNISHMENT);
        bookService.borrowBook(CRIME_AND_PUNISHMENT);
        bookService.removeBook(CRIME_AND_PUNISHMENT);
    }
}
