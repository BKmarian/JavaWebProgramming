package model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Book {

    private final String isin;
    private final String name;
    private final String author;

    public Book(String isin, String name, String author) {
        this.isin = isin;
        this.name = name;
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isin);
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isin.equals(book.isin);
    }

    public String getName() {
        return name;
    }

    public String getIsin() {
        return isin;
    }

    public String getAuthor() {
        return author;
    }

}
