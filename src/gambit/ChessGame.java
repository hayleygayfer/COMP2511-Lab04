package gambit;

import gambit.pieces.*;

public class ChessGame {
    public static void main(String[] args) {
        Chessboard board = new Chessboard();
        Knight k = new Knight(new Square(0, 0), PieceColour.Black);
        Knight k2 = new Knight(new Square(4, 4), PieceColour.Black);
        System.out.println(k2.getPossibleMoves(board));
        Pawn p = new Pawn(new Square(7,7), PieceColour.White);
        Pawn p2 = new Pawn(new Square(6,7), PieceColour.White);
        System.out.println(p.getPossibleMoves(board));
        Rook r1 = new Rook(new Square(4, 4), PieceColour.Black);
        System.out.println(r1.getPossibleMoves(board));
        Bishop b1 = new Bishop(new Square(4, 4), PieceColour.White);
        System.out.println(b1.getPossibleMoves(board));
        King kg = new King(new Square(3, 3), PieceColour.Black);
        System.out.println(kg.getPossibleMoves(board));
        Queen q = new Queen(new Square(4, 4), PieceColour.White);
        System.out.println(q.getPossibleMoves(board));
    }
}