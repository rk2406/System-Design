package services;

import models.Book;
import models.BookCopy;
import models.Library;
import models.Rack;

import java.util.*;

public class BookTracker {
    private static final Random random= new Random();

    public static void addBook(Book book, Library library,int bookCopyId){
        boolean bookAdded= false;
        List<Rack> racks= library.getRacks();
        for (Rack rack : racks) {
            if(rack.getCurrentBookNum() > rack.getCapacity()) continue;

            HashSet<Integer> books = rack.getBook();
            if (!books.contains(book.getBookId())) {
                books.add(book.getBookId());

                int key=bookCopyId!=-1?bookCopyId:random.nextInt(1000);

                bookAdded=true;

                if(BookCopy.bookCopies.containsKey(book.getBookId())){
                    BookCopy.bookCopies.get(book.getBookId()).put(key,rack);
                }
                else{
                    HashMap<Integer,Rack> bookRackMap = new HashMap<>();
                    bookRackMap.put(key,rack);
                    BookCopy.bookCopies.put(book.getBookId(), bookRackMap);
                }

                rack.setCurrentBookNum(rack.getCurrentBookNum()+1);

                break;
            }
        }
        if(!bookAdded){
            System.out.println("Library out of capacity");
            return;
        }
        library.setRacks(racks);
    }


    public static  void removeBook(int bookId,Library library){
        if(!BookCopy.bookCopies.containsKey(bookId)) {
            System.out.println("Incorrect book id");
            return;
        }

        int bookCopyId=BookCopy.bookCopies.get(bookId).entrySet().iterator().next().getKey();
        int rackNumber = BookCopy.bookCopies.get(bookId).get(bookCopyId).getRackNumber();

        BookCopy.bookCopies.get(bookId).remove(bookCopyId);

        Rack rack= library.getRacks().get(rackNumber-1);
        rack.getBook().remove(bookId);
        rack.setCurrentBookNum(rack.getCurrentBookNum()-1);

    }
}
