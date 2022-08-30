import java.util.ArrayList;
import java.util.List;

public class Piece {
    private char color;
    private char code;

    Piece(char color, char code) {
        this.color = color;
        this.code = code;
    }

    char getColor() {
        return color;
    }

    char getCode() {
        return code;
    }

    void setColor(char color) {
        this.color = color;
    }

    void setCode(char code) {
        this.code = code;
    }

    static  boolean isValidSquare(int x, int y){
        return x>=0 && x< Board.size && y>=0 && y<Board.size;
    }

    static List<int[]> getKingValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();
        if(isValidSquare(srcX+1,srcY)) allValidSquares.add(new int[]{srcX+1,srcY});
        if(isValidSquare(srcX-1,srcY)) allValidSquares.add(new int[]{srcX-1,srcY});
        if(isValidSquare(srcX,srcY-1)) allValidSquares.add(new int[]{srcX,srcY-1});
        if(isValidSquare(srcX,srcY+1)) allValidSquares.add(new int[]{srcX,srcY+1});
        if(isValidSquare(srcX-1,srcY-1)) allValidSquares.add(new int[]{srcX-1,srcY-1});
        if(isValidSquare(srcX+1,srcY+1)) allValidSquares.add(new int[]{srcX+1,srcY+1});
        if(isValidSquare(srcX+1,srcY-1)) allValidSquares.add(new int[]{srcX+1,srcY-1});
        if(isValidSquare(srcX-1,srcY+1)) allValidSquares.add(new int[]{srcX-1,srcY+1});

        return  allValidSquares;
    }

    static boolean isEmptySquare(int x,int y){
        return Board.chessBoard[x][y].getCode() =='-' && Board.chessBoard[x][y].getColor() =='-';
    }
    static List<int[]> getQueenValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();

        for(int i=0;i<Board.size;i++){
            if(isValidSquare(i,srcY)) allValidSquares.add(new int[]{i,srcY});
            if(!isEmptySquare(i,srcY)) break;
        }

        for(int i=0;i<Board.size;i++){
            if(isValidSquare(srcX,i)) allValidSquares.add(new int[]{srcX,i});
            if(!isEmptySquare(srcX,i)) break;
        }

        for(int i=srcX-1,j=srcY-1;i>=0 && j>=0;i--,j--){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        for(int i=srcX+1,j=srcY+1;i<Board.size && j<Board.size;i++,j++){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        for(int i=srcX-1,j=srcY+1;i>=0 && j<Board.size;i--,j++){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j))  break;
        }

        for(int i=srcX+1,j=srcY-1;i<Board.size && j>=0;i++,j--){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        return  allValidSquares;
    }

    static List<int[]> getBishopValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();

        for(int i=srcX-1,j=srcY-1;i>=0 && j>=0;i--,j--){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        for(int i=srcX+1,j=srcY+1;i<Board.size && j<Board.size;i++,j++){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        for(int i=srcX-1,j=srcY+1;i>=0 && j<Board.size;i--,j++){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        for(int i=srcX+1,j=srcY-1;i<Board.size && j>=0;i++,j--){
            if(isValidSquare(i,j)) allValidSquares.add(new int[]{i,j});
            if(!isEmptySquare(i,j)) break;
        }

        return  allValidSquares;
    }

    static List<int[]> getRookValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();

        for(int i=srcX+1;i<Board.size;i++){
            if(isValidSquare(i,srcY) ) allValidSquares.add(new int[]{i,srcY});
            if(!isEmptySquare(i,srcY)) break;
        }

        for(int i=srcY+1;i<Board.size;i++){
            if(isValidSquare(srcX,i)) allValidSquares.add(new int[]{srcX,i});
            if(!isEmptySquare(srcX,i)) break;
        }

        for(int i=srcX-1;i>=0;i--){
            if(isValidSquare(i,srcY)) allValidSquares.add(new int[]{i,srcY});
            if(!isEmptySquare(i,srcY)) break;
        }

        for(int i=srcY-1;i>=0;i--){
            if(isValidSquare(srcX,i)) allValidSquares.add(new int[]{srcX,i});
            if(!isEmptySquare(srcX,i)) break;
        }

        return  allValidSquares;
    }

    static List<int[]> getKnightValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();

        if(isValidSquare(srcX-2,srcY-1)) allValidSquares.add(new int[]{srcX-2,srcY-1});
        if(isValidSquare(srcX-2,srcY+1)) allValidSquares.add(new int[]{srcX-2,srcY+1});
        if(isValidSquare(srcX+2,srcY-1)) allValidSquares.add(new int[]{srcX+2,srcY-1});
        if(isValidSquare(srcX+2,srcY+1)) allValidSquares.add(new int[]{srcX+2,srcY+1});
        if(isValidSquare(srcX-1,srcY-2)) allValidSquares.add(new int[]{srcX-1,srcY-2});
        if(isValidSquare(srcX+1,srcY-2)) allValidSquares.add(new int[]{srcX+1,srcY-2});
        if(isValidSquare(srcX+1,srcY+2)) allValidSquares.add(new int[]{srcX+1,srcY+2});
        if(isValidSquare(srcX-1,srcY+2)) allValidSquares.add(new int[]{srcX-1,srcY+2});

        return  allValidSquares;
    }

    static List<int[]> getPawnValidMoves(int srcX, int srcY){
        List<int[]> allValidSquares= new ArrayList<>();
        if(Board.chessBoard[srcX][srcY].getColor()=='W'){
            if(srcX==Board.size-2 && Board.chessBoard[srcX-1][srcY].getCode()=='-' && Board.chessBoard[srcX-2][srcY].getCode()=='-') allValidSquares.add(new int[]{srcX-2,srcY});
            else{
                if(isValidSquare(srcX-1,srcY-1) && Board.chessBoard[srcX-1][srcY-1].getCode()!='-') allValidSquares.add(new int[]{srcX-1,srcY-1});
                if(isValidSquare(srcX-1,srcY+1) && Board.chessBoard[srcX-1][srcY+1].getCode()!='-') allValidSquares.add(new int[]{srcX-1,srcY+1});
                if(isValidSquare(srcX-1,srcY) && Board.chessBoard[srcX-1][srcY].getCode()=='-') allValidSquares.add(new int[]{srcX-1,srcY});
            }
        }
        else if(Board.chessBoard[srcX][srcY].getColor()=='B'){
            if(srcX==1 && Board.chessBoard[srcX+1][srcY].getCode()=='-' && Board.chessBoard[srcX+2][srcY].getCode()=='-') allValidSquares.add(new int[]{srcX+2,srcY});
            else{
                if(isValidSquare(srcX+1,srcY-1) && Board.chessBoard[srcX+1][srcY-1].getCode()!='-') allValidSquares.add(new int[]{srcX+1,srcY-1});
                if(isValidSquare(srcX+1,srcY+1) && Board.chessBoard[srcX+1][srcY+1].getCode()!='-') allValidSquares.add(new int[]{srcX+1,srcY+1});
                if(isValidSquare(srcX+1,srcY) && Board.chessBoard[srcX+1][srcY].getCode()=='-') allValidSquares.add(new int[]{srcX+1,srcY});
            }
        }
        return allValidSquares;
    }
}
