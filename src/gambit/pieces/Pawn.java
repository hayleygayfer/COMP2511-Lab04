package gambit.pieces;

import java.util.ArrayList;
import java.util.List;

import gambit.Chessboard;
import gambit.Square;

public class Pawn extends Piece {

    public Pawn(Square location, PieceColour colour) {
        super(location, colour);
    }

    public List<Square> getPossibleMoves(Chessboard board) {
        List<Square> possibleMoves = new ArrayList<Square>();
        int row = getRow();
        int col = getCol();

        int oneSquare;
        int twoSquares;
        if (getColour().equals(PieceColour.Black)) {
            oneSquare = 1;
            twoSquares = 2;
        } else {
            oneSquare = -1;
            twoSquares = -2;
        }
        System.out.println(getColour());

        // Move forward 1 or 2 squares if vacant
        if (!board.isOccupied(row + oneSquare, col)) {
            if (!board.isOccupied(row + twoSquares, col)) {
                possibleMoves.add(new Square(row + twoSquares, col));
            }
            possibleMoves.add(new Square(row + oneSquare, col));
        }

        // Take another piece diagonally left or right
        if (board.onBoard(row + oneSquare, col + oneSquare) && board.isOccupiedByOpponent(row + oneSquare, col + oneSquare, getColour())) {
            possibleMoves.add(new Square(row + oneSquare, col + oneSquare));
        }

        if (board.onBoard(row + oneSquare, col - oneSquare) && board.isOccupiedByOpponent(row + oneSquare, col - oneSquare, getColour())) {
            possibleMoves.add(new Square(row + oneSquare, col - oneSquare));
        }
    
        return possibleMoves;
    }
}