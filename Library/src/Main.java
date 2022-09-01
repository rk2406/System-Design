import constants.BookType;
import models.Book;
import models.Library;
import models.Rack;
import models.User;
import services.BookTracker;
import services.RackTracker;
import services.UserTracker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book prideAndPrejudice = new Book(12,"Pride and Prejudice","Jane Austen", BookType.DRAMA);
        Book origin = new Book(34,"Origin","Dan Brown",BookType.SCI_FI);
        Book nagas = new Book(78,"the Secret of Nagas","Amish Tripathi",BookType.FANTASY);

        int numRacks=20;
        int rackCapacity=5;
        List<Rack> racks=new ArrayList<>();
        for(int i=1;i<=numRacks;i++){
            racks.add(new Rack(i,rackCapacity));
        }

        Library library= new Library(racks,numRacks);

        BookTracker.addBook(prideAndPrejudice,library,-1);
        BookTracker.addBook(prideAndPrejudice,library,-1);
        BookTracker.addBook(origin,library,-1);
        BookTracker.addBook(nagas,library,-1);
        BookTracker.addBook(origin,library,-1);
        BookTracker.addBook(nagas,library,-1);
        BookTracker.addBook(origin,library,-1);
        BookTracker.addBook(nagas,library,-1);

        System.out.println("*************************");
        RackTracker.printLibrary(library);

        BookTracker.removeBook(prideAndPrejudice.getBookId(), library);

        System.out.println("*************************");
        RackTracker.printLibrary(library);

        User user1= new User(001, "RK");
        User user2= new User(002, "HV");

        UserTracker.borrowBook(origin,user2,library);
        UserTracker.borrowBook(prideAndPrejudice,user1,library);

        System.out.println("*************************");
        UserTracker.printTransactions();

        System.out.println("*************************");
        RackTracker.printLibrary(library);

        UserTracker.returnBook(prideAndPrejudice,user1,library);

        System.out.println("*************************");
        UserTracker.printTransactions();

        System.out.println("*************************");
        RackTracker.printLibrary(library);
    }
}