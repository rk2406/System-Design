package models;

import lombok.Data;

@Data
public class User {
//    userId, name, email, mobile number
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
