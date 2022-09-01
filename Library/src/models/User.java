package models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    private int userId;
    private String name;
    private Map<Integer,Book> booksBorrowed;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.booksBorrowed= new HashMap<>();
    }
}
