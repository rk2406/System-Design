import java.util.List;

public class Moves {

    private static boolean findSquare(List<int[]> validSquares,int destX, int destY){
        for(int[] square: validSquares){
            if(square[0]==destX && square[1]==destY) return true;
        }
        return false;
    }
    private static boolean isValidMove(int srcX, int srcY, int destX,int destY, char piece){
        if(Board.chessBoard[srcX][srcY].getColor()== Board.chessBoard[destX][destY].getColor()) return false;
        switch (piece) {
            case 'K':
                List<int[]> validSquaresKing= Piece.getKingValidMoves(srcX,srcY);
                return findSquare(validSquaresKing,destX,destY);
            case 'Q':
                List<int[]> validSquaresQueen= Piece.getQueenValidMoves(srcX,srcY);
                return findSquare(validSquaresQueen,destX,destY);
            case 'B':
                List<int[]> validSquaresBishop= Piece.getBishopValidMoves(srcX,srcY);
                return findSquare(validSquaresBishop,destX,destY);
            case 'R':
                List<int[]> validSquaresRook = Piece.getRookValidMoves(srcX,srcY);
                return findSquare(validSquaresRook,destX,destY);
            case 'N':
                List<int[]> validSquaresKnight = Piece.getKnightValidMoves(srcX,srcY);
                return findSquare(validSquaresKnight,destX,destY);
            case 'P':
                List<int[]> validSquaresPawn = Piece.getPawnValidMoves(srcX,srcY);
                return findSquare(validSquaresPawn,destX,destY);
        }
        return false;
    }

    static void makeMove(String src, String dest){
        int srcY= src.charAt(0)-'a';
        int destY= dest.charAt(0)-'a';
        int srcX=Board.size-( src.charAt(1)-'0');
        int destX=Board.size-( dest.charAt(1)-'0');
        char piece= Board.chessBoard[srcX][srcY].getCode();
        if(isValidMove(srcX,srcY,destX,destY,piece)){
            Board.chessBoard[destX][destY].setColor(Board.chessBoard[srcX][srcY].getColor());
            Board.chessBoard[destX][destY].setCode(Board.chessBoard[srcX][srcY].getCode());
            Board.chessBoard[srcX][srcY].setColor('-');
            Board.chessBoard[srcX][srcY].setCode('-');
        }
        else {
            System.out.println("Invalid move");
        }
    }
}
