package chess;

public class ChessBoard {

    private int[][] spaces;

    protected static final int BOARD_LENGTH = 8;

    protected ChessBoard() {
        spaces = new int[BOARD_LENGTH][BOARD_LENGTH];
        int val = 0;
        for (int row = 0; row < BOARD_LENGTH; row++) {
            for (int col = 0; col < BOARD_LENGTH; col++) {
                spaces[row][col] = val++;
            }
        }
    }

    protected int[][] getSpaces() {
        return spaces;
    }

    protected int calculateBishopMoves(int src, int dest) {

        if (src == dest)
            return 0;

        int srcRow = src / BOARD_LENGTH;
        int srcCol = src % BOARD_LENGTH;
        int destRow = dest / BOARD_LENGTH;
        int destCol = dest % BOARD_LENGTH;
        int srcTotal = srcRow + srcCol;
        int destTotal = destRow + destCol;

        if (srcTotal % 2 != destTotal % 2) {
            return -1;
        }

        int slope = Math.abs((destRow - srcRow) / (destCol - srcCol));

        if (slope == 1) {
            return 1;
        }

        return 2;
    }
}
