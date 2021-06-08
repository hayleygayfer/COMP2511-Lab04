package gambit.pieces;

import java.util.ArrayList;
import java.util.List;

import gambit.Chessboard;
import gambit.Square;

public class King extends Piece {
    
    public King(Square location, PieceColour colour) {
        super(location, colour);
    }

    public List<Square> getPossibleMoves(Chessboard board) {
        List<Square> possibleMoves = new ArrayList<Square>();

        int row = getRow();
        int col = getCol();
        
        if (board.onBoard(row + 1, col) && !board.isOccupiedByPlayer(row + 1, col, getColour()));
            possibleMoves.add(new Square(row + 1, col));

        if (board.onBoard(row - 1, col) && !board.isOccupiedByPlayer(row - 1, col, getColour()));
            possibleMoves.add(new Square(row - 1, col));

        if (board.onBoard(row + 1, col - 1) && !board.isOccupiedByPlayer(row + 1, col - 1, getColour()));
            possibleMoves.add(new Square(row + 1, col - 1));

        if (board.onBoard(row + 1, col + 1) && !board.isOccupiedByPlayer(row + 1, col + 1, getColour()));
            possibleMoves.add(new Square(row + 1, col + 1));

        if (board.onBoard(row - 1, col + 1) && !board.isOccupiedByPlayer(row - 1, col + 1, getColour()));
            possibleMoves.add(new Square(row - 1, col + 1));

        if (board.onBoard(row - 1, col - 1) && !board.isOccupiedByPlayer(row - 1, col - 1, getColour()));
            possibleMoves.add(new Square(row - 1, col - 1));

        if (board.onBoard(row, col + 1) && !board.isOccupiedByPlayer(row, col + 1, getColour()));
            possibleMoves.add(new Square(row, col + 1));

        if (board.onBoard(row, col - 1) && !board.isOccupiedByPlayer(row, col - 1, getColour()));
            possibleMoves.add(new Square(row, col - 1));


        return possibleMoves;
    }



}