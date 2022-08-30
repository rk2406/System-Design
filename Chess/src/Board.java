public class Board {
    static final int size=8;
    static Piece[][] chessBoard= {
            {
                new Piece('B','R'),
                    new Piece('B','N'),
                    new Piece('B','B'),
                    new Piece('B','Q'),
                    new Piece('B','K'),
                    new Piece('B','B'),
                    new Piece('B','N'),
                    new Piece('B','R'),

            },
            {
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),
                    new Piece('B','P'),

            },
            {
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),

            },
            {
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),

            },
            {
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),

            },
            {
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),
                    new Piece('-','-'),

            },
            {
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),
                    new Piece('W','P'),

            },
            {
                    new Piece('W','R'),
                    new Piece('W','N'),
                    new Piece('W','B'),
                    new Piece('W','Q'),
                    new Piece('W','K'),
                    new Piece('W','B'),
                    new Piece('W','N'),
                    new Piece('W','R'),

            },

    };

    static void print(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                String s = new StringBuilder().append(chessBoard[i][j].getColor()).append(chessBoard[i][j].getCode()).toString();
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }



}
