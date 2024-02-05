package models;

public class Card {
    private int balance;
    private String number;
    private String pin;
    private String name;

    public Card(int balance, String number, String pin, String name) {
        this.balance = balance;
        this.number = number;
        this.pin = pin;
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }
}
