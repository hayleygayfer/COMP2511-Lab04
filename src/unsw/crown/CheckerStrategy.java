package unsw.crown;

import java.util.List;

/**
 * @author Braedon Wooding, and @your name
 */
public interface CheckerStrategy {
    // what about rendering?
    // maybe some sort of 'renderSpecial' to add the crowns/duck icons.

    public List<Position> validPositions(Checkerboard board, Position position);
}
