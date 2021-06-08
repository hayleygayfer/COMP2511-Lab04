package gambit;

public class Square {
    private int row;
    private int col;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }

        Square s = (Square) obj;
        return s.getRow() == row && s.getCol() == col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}