package service;

import exceptions.BookNotFoundException;
import model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<Book,Integer> bookPresent = new HashMap<>();

    public String borrowBook(Book book) {
        if(bookPresent.get(book) == null)
            throw new BookNotFoundException(book.getName() + " not found");
        bookPresent.put(book ,bookPresent.get(book) - 1);
        cleanDatabase();
        return "Borrowed";
    }

    public String returnBook(Book book) {
        if (bookPresent.containsKey(book))
            bookPresent.computeIfPresent(book ,(Book key, Integer val) -> val + 1);
        else
            bookPresent.put(book,1);
        return "Returned";
    }

    public String addBook(Book book) {
        if (bookPresent.containsKey(book))
            bookPresent.computeIfPresent(book ,(Book key, Integer val) -> val + 1);
        else
            bookPresent.put(book,1);
        return "Added";
    }

    public String removeBook(Book book) {
        bookPresent.computeIfPresent(book , (Book key, Integer val) -> val - 1);
        cleanDatabase();
        return "Removed";
    }
    private void cleanDatabase() {
        bookPresent.values().removeIf(val -> val == 0);
    }
}
