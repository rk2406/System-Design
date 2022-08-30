import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        while(true){
            Board.print();
            System.out.println("Enter source square");
            String src= sc.next();
            System.out.println("Enter destination square");
            String dest= sc.next();
            Moves.makeMove(src,dest);
            if(src.equals("Exit") || dest.equals("Exit")) break;
        }

    }
}