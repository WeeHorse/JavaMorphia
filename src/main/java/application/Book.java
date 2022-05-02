package application;

import dev.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("Books")
public class Book {
    @Id
    private String isbn;
    private String title;
    @Property("price")
    private double cost;

    @Embedded
    private Publisher publisher;

    @Reference
    private ArrayList<Book> companionBooks = new ArrayList<>();

    @Reference
    private Author author;

    // constructors, getters, setters and hashCode, equals, toString implementations


    public Book() {
    }

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public Book(String isbn, String title, double cost, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.cost = cost;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Book> getCompanionBooks() {
        return companionBooks;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void addCompanionBook(Book companionBook) {
        companionBooks.add(companionBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", publisher=" + publisher +
                ", companionBooks=" + companionBooks +
                ", author=" + author +
                '}';
    }
}
