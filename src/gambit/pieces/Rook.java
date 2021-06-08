package gambit.pieces;

import java.util.ArrayList;
import java.util.List;

import gambit.Chessboard;
import gambit.Square;

public class Rook extends Piece {
    
    public Rook(Square location, PieceColour colour) {
        super(location, colour);
    }

    public List<Square> getPossibleMoves(Chessboard boardState) {
        List<Square> possibleMoves = new ArrayList<Square>();

        int row = getRow();
        int col = getCol();
        int i = row + 1;
        int j = col + 1;

        while (boardState.onBoard(i, col)) {
            if (boardState.isOccupiedByPlayer(i, col, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, col));
            
            if (boardState.isOccupiedByOpponent(i, col, getColour())) {
                break;
            }
            i++;
        }

        i = row - 1;

        while (boardState.onBoard(i, col)) {
            if (boardState.isOccupiedByPlayer(i, col, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, col));
            
            if (boardState.isOccupiedByOpponent(i, col, getColour())) {
                break;
            }
            i--;
        }

        while (boardState.onBoard(row, j)) {
            if (boardState.isOccupiedByPlayer(row, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(row, j));
            
            if (boardState.isOccupiedByOpponent(row, j, getColour())) {
                break;
            }
            j++;
        }

        j = col - 1;

        while (boardState.onBoard(row, j)) {
            if (boardState.isOccupiedByPlayer(row, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(row, j));
            
            if (boardState.isOccupiedByOpponent(row, j, getColour())) {
                break;
            }
            j--;
        }

        return possibleMoves;
    }



}