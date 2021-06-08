package gambit.pieces;

import java.util.ArrayList;
import java.util.List;

import gambit.Chessboard;
import gambit.Square;

public class Bishop extends Piece {
    
    public Bishop(Square location, PieceColour colour) {
        super(location, colour);
    }

    public List<Square> getPossibleMoves(Chessboard boardState) {
        List<Square> possibleMoves = new ArrayList<Square>();

        int row = getRow();
        int col = getCol();
        int i = row + 1;
        int j = col + 1;

        while (boardState.onBoard(i, j)) {
            System.out.println("heyyy");
            if (boardState.isOccupiedByPlayer(i, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, j));
            
            if (boardState.isOccupiedByOpponent(i, j, getColour())) {
                break;
            }
            i++;
            j++;
        }

        i = row + 1;
        j = col - 1;

        while (boardState.onBoard(i, j)) {
            System.out.println("heyyy2");
            if (boardState.isOccupiedByPlayer(i, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, j));
            
            if (boardState.isOccupiedByOpponent(i, j, getColour())) {
                break;
            }
            i++;
            j--;
        }

        i = row - 1;
        j = col + 1;

        while (boardState.onBoard(i, j)) {
            System.out.println("heyyy3");
            if (boardState.isOccupiedByPlayer(i, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, j));
            
            if (boardState.isOccupiedByOpponent(i, j, getColour())) {
                break;
            }
            i--;
            j++;
        }

        j = col - 1;
        i = col - 1;

        while (boardState.onBoard(i, j)) {
            System.out.println("heyyy4");
            if (boardState.isOccupiedByPlayer(i, j, getColour())) {
                break;
            }
            
            possibleMoves.add(new Square(i, j));
            
            if (boardState.isOccupiedByOpponent(i, j, getColour())) {
                break;
            }
            i--;
            j--;
        }

        return possibleMoves;
    }



}