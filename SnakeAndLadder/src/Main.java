import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Dice dice= new Dice(1);

        Player rk = new Player("Rupasa",1);
        Player hv= new Player("Harsh",2);
        Queue<Player> playerQueue= new LinkedList<>();
        playerQueue.offer(rk);
        playerQueue.offer(hv);

        Jumper snake1= new Jumper(10,2);
        Jumper snake2= new Jumper(99,32);
        List<Jumper> snakes=new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);

        Jumper ladder1= new Jumper(5,25);
        Jumper ladder2= new Jumper(49,80);
        List<Jumper> ladders=new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        Map<String, AtomicInteger> currentPos= new HashMap<>();
        currentPos.put("Rupasa",new AtomicInteger(0));
        currentPos.put("Harsh",new AtomicInteger(0));
        Board board= new Board(dice,playerQueue,snakes,ladders,100,currentPos);
        board.startGame();
    }
}