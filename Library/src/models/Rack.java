package models;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Data
public class Rack {
    private int rackNumber;
    private HashSet<Integer> book;
    private final int capacity;

    private int currentBookNum=0;

//    private HashMap<Integer,Book> bookStore;

    public Rack(int rackNumber, int capacity) {
        this.rackNumber = rackNumber;
        this.capacity = capacity;
        this.book= new HashSet<>(capacity);
//        this.bookStore=new HashMap<>();
    }
}
