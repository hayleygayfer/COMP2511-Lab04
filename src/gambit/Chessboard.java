package gambit;

import java.util.ArrayList;
import java.util.List;

import gambit.pieces.Piece;
import gambit.pieces.PieceColour;

public class Chessboard {
    private static final int BOARD_SIZE = 8;
    private Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];
    private List<Piece> pieces = new ArrayList<Piece>();
    
    public void setupBoard() {
        
    }

    private Piece getPieceAt(int row, int col) {
        for (Piece piece : pieces) {
            if (piece.getCol() == col && piece.getRow() == row) {
                return piece;
            }
        }
        return null;
    }

    public boolean isOccupied(int row, int col) {
        return getPieceAt(row, col) != null;
    }

    public boolean onBoard(int row, int col) {
        return row >= 0 && col >= 0 && row < BOARD_SIZE && col < BOARD_SIZE;
    }

    public boolean isOccupiedByPlayer(int row, int col, PieceColour colour) {
        return isOccupied(row, col) && !isOccupiedByOpponent(row, col, colour);
    }

    public boolean isOccupiedByOpponent(int row, int col, PieceColour colour) {
        return isOccupied(row, col) && !getPieceAt(row, col).getColour().equals(colour);
    }
}