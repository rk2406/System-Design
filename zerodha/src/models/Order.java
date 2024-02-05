package models;

import  models.common.*;

public class Order {
    private ORDER_TYPE orderType;
    private TXN_TYPE transactionType;
    private Stock stock;
    private int quantity;
    private double price;
    //transactions
    //status
    //timestamp


    public Order(ORDER_TYPE orderType, TXN_TYPE transactionType, Stock stock, int quantity, double price) {
        this.orderType = orderType;
        this.transactionType = transactionType;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }

    public TXN_TYPE getTransactionType() {
        return transactionType;
    }

    public double getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }
}
