package models;

import constants.BookType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Book {
    private int bookId;
    private String title;
    private String author;

    private BookType genre;
     public Book(int bookId, String title, String author, BookType genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre=genre;
        BookCopy.bookHashMap.put(bookId,this);
    }
}
