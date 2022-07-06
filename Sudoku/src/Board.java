import java.util.ArrayList;

public class Board {
    private int size;
    private int empty=0;

    private int[][] grid;

    Board(int size, int[][] grid) {
        this.size = size;
        this.grid = grid;
    }

    int getSize() {
        return size;
    }

    int getEmpty() {
        return empty;
    }

    int[][] getGrid() {
        return grid;
    }

    public int[][] setGrid(int[][] grid,int row, int col, int number) {
        grid[row][col]=number;
        this.grid = grid;
        return this.grid;
    }

    void display(){
        int[][] grid= this.grid;
        for(int i=0;i< size;i++){
            for(int j=0;j< size;j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }
    }
}
