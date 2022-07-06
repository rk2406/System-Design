import java.util.Queue;

public class Sudoku {

    Board board;
    Queue<Player> players;

    Sudoku(Board board,Queue<Player> players) {
        this.board = board;
        this.players=players;
    }

    void takeTurn(int number, int row, int col){
        System.out.println(players.peek().getName() + " turn");
        int[][] grid= board.getGrid();
        if(grid[row][col]==board.getEmpty()) {
            if (isOk(row, col, number)) {
                Player player = players.poll();
                System.out.println(player.getName() + " enters " + number + " at row " + row + " and col " + col);
                board.setGrid(board.getGrid(), row, col, number);
                if (isSolved(board)) System.out.println(player.getName() + " won");
                else players.offer(player);
                board.display();
            } else {
                System.out.println("Try Again");
            }
        }
        else System.out.println("Not an empty cell");
    }

    boolean isSolved(Board board){
        int[][] grid= board.getGrid();
        int size= board.getSize();
        int empty= board.getEmpty();
        for(int i=0;i< size;i++){
            for(int j=0;j<size;j++){
                if(grid[i][j]==empty) return false;
            }
        }
        return true;
    }

    private boolean isInRow(int row, int number){
        int size= board.getSize();
        int[][] grid= board.getGrid();
        for(int i=0;i<size;i++){
            if(grid[row][i]==number) return true;
        }
        return  false;
    }

    private boolean isInCol(int col, int number){
        int size= board.getSize();
        int[][] grid= board.getGrid();
        for (int i=0;i<size;i++)
            if(grid[i][col]==number) return true;
        return false;
    }

    private boolean isInBox(int row,int col,int number){
        int[][] grid= board.getGrid();
        int r=row-row%3;
        int c=col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(grid[i][j]==number) return true;
            }
        }
        return false;
    }

    boolean isOk(int row, int col, int number){
        return !isInRow(row, number) && !isInCol(col,number) && !isInBox(row, col, number);
    }
}
