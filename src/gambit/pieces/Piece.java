package gambit.pieces;

import java.util.List;

import gambit.Square;
import gambit.Chessboard;

public abstract class Piece {
    private Square location;
    private PieceColour colour;

    public Piece(Square location, PieceColour colour) {
        this.location = location;
        this.colour = colour;
    }

    public void move(Square to) {
        this.location = to;
    }

    public int getRow() {
        return location.getRow();
    }

    public int getCol() {
        return location.getCol();
    }

    public PieceColour getColour() {
        return colour;
    }

    public abstract List<Square> getPossibleMoves(Chessboard boardState);
    
}