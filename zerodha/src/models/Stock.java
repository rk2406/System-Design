package models;

import models.common.*;

public class Stock {
    EXCHANGE exchange;
    String name;
    Double price;

    public Stock(EXCHANGE exchange, String name, double price) {
        this.exchange = exchange;
        this.name = name;
        this.price = price;
    }
}
