package unsw.crown;

import java.util.List;

public interface CheckerStrategy {
    public List<Position> validPositions(Checkerboard board, Position position);
}
