package unsw.crown;

import java.util.List;

/**
 * @author Braedon Wooding, and @your name
 */
public interface CheckerStrategy {
    // what about rendering?
    // maybe some sort of 'renderSpecial' to add the crowns/duck icons.

    public void addValidPositions(List<Position> validPositions, Checkerboard board, Position position, Color color);
}
