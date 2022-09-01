package services;

import models.BookCopy;
import models.Library;
import models.Rack;

import java.util.HashMap;
import java.util.Map;

public class RackTracker {
    public static void printLibrary(Library library){
        for(Map.Entry<Integer,HashMap<Integer,Rack>> entry: BookCopy.bookCopies.entrySet()){
            System.out.println(BookCopy.bookHashMap.get(entry.getKey()).getTitle());
            for(Map.Entry<Integer,Rack> rackEntry: entry.getValue().entrySet()){
                System.out.println(rackEntry.getKey()+" "+rackEntry.getValue().getRackNumber());
            }
            System.out.println("--------------------------");
        }
    }
}
