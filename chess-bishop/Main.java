package chess;

public class Main {

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        int x = board.calculateBishopMoves(1, 8);
        System.out.print(x);
    }

}
