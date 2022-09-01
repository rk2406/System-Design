package services;

import models.*;

import java.util.*;

public class UserTracker {

    public static Map<Integer, List<Book>>  userBookMap= new HashMap<>();

    public static void borrowBook(Book book, User user, Library library){
        if(userBookMap.containsKey(user.getUserId()) && userBookMap.get(user.getUserId()).size()>5){
            System.out.println(user.getName()+" exceeded max limit");
            return;
        }
        HashMap<Integer,Rack> bookRackMap = BookCopy.bookCopies.get(book.getBookId());
        if(bookRackMap.isEmpty()){
            System.out.println("Book unavailable for User"+user.getUserId());
            return;
        }

        int bookCopyId= bookRackMap.entrySet().iterator().next().getKey();
        List<Book> books= userBookMap.get(user.getUserId());
        if(books!=null )books.add(book);
        else {
            books= new ArrayList<>();
            books.add(book);
        }
        userBookMap.put(user.getUserId(), books);

        user.getBooksBorrowed().put(bookCopyId,book);
        BookTracker.removeBook(book.getBookId(),library);
    }

    public static void returnBook(Book book, User user, Library library){
        int bookCopyId=-1;
        for (Map.Entry<Integer, Book> entry : user.getBooksBorrowed().entrySet()) {
            if (Objects.equals(book, entry.getValue())) {
                bookCopyId= entry.getKey();
            }
        }
        user.getBooksBorrowed().remove(bookCopyId);

        userBookMap.get(user.getUserId()).remove(book);

        BookTracker.addBook(book,library,bookCopyId);

    }
    public static void printTransactions(){
        for(Map.Entry<Integer,List<Book>> entry: userBookMap.entrySet()){
            System.out.println("User"+entry.getKey()+" has ");
            for(Book book: entry.getValue()){
                System.out.println(book.getTitle());
            }
            System.out.println("----------------------------");
        }

    }

    public static  void printTransactionByUser(User user){
        System.out.println("User"+user.getUserId()+" has ");
        for(Map.Entry<Integer,Book> bookEntry: user.getBooksBorrowed().entrySet()){
            System.out.println(bookEntry.getKey()+" "+ bookEntry.getValue().getTitle());
        }
    }


}
