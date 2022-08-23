package models;

import lombok.Data;

@Data
public class UserPassbook {
    private User user;
    private Double amount;

    public UserPassbook(User user, Double amount) {
        this.user = user;
        this.amount = amount;
    }
}
