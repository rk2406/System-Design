package models;

public class User {
    double funds;
    String userId;
    //portfolio
    //watchlists


    public User(double funds, String userId) {
        this.funds = funds;
        this.userId = userId;
    }

    public double getFunds() {
        return funds;
    }

    public String getUserId() {
        return userId;
    }
}
