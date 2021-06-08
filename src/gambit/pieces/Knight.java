package gambit.pieces;

import java.util.ArrayList;
import java.util.List;

import gambit.Chessboard;
import gambit.Square;

public class Knight extends Piece {

    public Knight(Square location, PieceColour colour) {
        super(location, colour);
    }

    public List<Square> getPossibleMoves(Chessboard board) {
        List<Square> possibleMoves = new ArrayList<Square>();
        int row = getRow();
        int col = getCol();

        if (board.onBoard(row + 2, col + 1) && !board.isOccupiedByPlayer(row + 2, col + 1, getColour())) 
            possibleMoves.add(new Square(row + 2, col + 1));

        if (board.onBoard(row + 2, col - 1) && !board.isOccupiedByPlayer(row + 2, col - 1, getColour())) 
            possibleMoves.add(new Square(row + 2, col - 1));
        
        if (board.onBoard(row + 1, col + 2) && !board.isOccupiedByPlayer(row + 1, col + 2, getColour())) 
            possibleMoves.add(new Square(row + 1, col + 2));

        if (board.onBoard(row + 1, col - 2) && !board.isOccupiedByPlayer(row + 1, col - 2, getColour())) 
            possibleMoves.add(new Square(row + 1, col - 2));

        if (board.onBoard(row - 2, col + 1) && !board.isOccupiedByPlayer(row - 2, col + 1, getColour())) 
            possibleMoves.add(new Square(row - 2, col + 1));

        if (board.onBoard(row - 1, col + 2) && !board.isOccupiedByPlayer(row - 1, col + 2, getColour())) 
            possibleMoves.add(new Square(row - 1, col + 2));

        if (board.onBoard(row - 1, col - 2) && !board.isOccupiedByPlayer(row - 1, col - 2, getColour())) 
            possibleMoves.add(new Square(row - 1, col - 2));

        if (board.onBoard(row - 2, col - 1) && !board.isOccupiedByPlayer(row - 2, col - 1, getColour())) 
            possibleMoves.add(new Square(row - 2, col - 1));

        return possibleMoves;
    }
}