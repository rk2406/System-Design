import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {
    private Dice dice;
    private Queue<Player> players;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    int boardSize;

    Map<String, AtomicInteger> currentPos;

    Board(Dice dice, Queue<Player> players, List<Jumper> snakes, List<Jumper> ladders, int boardSize,Map<String, AtomicInteger> currentPos) {
        this.dice = dice;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
        this.boardSize = boardSize;
        this.currentPos= currentPos;
    }

    void startGame(){
        while(players.size()>1){
            Player player= players.poll();
            AtomicInteger pos= currentPos.get(player.getName());
            int diceValue= dice.rollDice();
            int nextPos= pos.get() +diceValue;
            if(nextPos>boardSize) players.offer(player);
            else if(nextPos==boardSize) System.out.println(player.getName()+" has won the game");
            else{
                AtomicInteger nextCell= new AtomicInteger(nextPos);
                AtomicBoolean isLadder= new AtomicBoolean(false);
                snakes.forEach(snake->{
                    if(snake.getStart()==nextPos){
                        nextCell.set(snake.getEnd());
                    }
                });

                if(nextCell.intValue()!=nextPos) System.out.println(player.getName()+" snake");
                ladders.forEach(ladder->{
                    if(ladder.getStart()==nextPos){
                        nextCell.set(ladder.getEnd());
                        isLadder.set(true);
                    }
                });
                if(nextCell.intValue()!=nextPos && isLadder.get()==true) System.out.println(player.getName()+" ladder");
                if(nextCell.equals(boardSize)) System.out.println(player.getName()+" has won the game");
                else{
                    currentPos.put(player.getName(),nextCell);
                    System.out.println(player.getName()+" at position "+nextCell);
                    players.offer(player);
                }
            }
        }
    }

}
