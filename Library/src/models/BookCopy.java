package models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class BookCopy {
    public static HashMap<Integer, HashMap<Integer,Rack>> bookCopies = new HashMap<>();
    public static HashMap<Integer,Book> bookHashMap = new HashMap<>();
}
