import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] GRID_TO_SOLVE = {
                {9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0},
        };
        Board board=new Board(9,GRID_TO_SOLVE);
        Player rk= new Player(1,"Rupasa");
        Player hv=new Player(2,"Harsh");
        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.offer(rk);
        playerQueue.offer(hv);
        Sudoku game= new Sudoku(board,playerQueue);
        game.takeTurn(2,0,1);
        game.takeTurn(4,0,2);
        game.takeTurn(2,0,1);
        game.takeTurn(4,0,2);
    }
}