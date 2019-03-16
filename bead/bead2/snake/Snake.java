package snake;

import snake.util.Direction;
import snake.exception.CollisionException;

public interface Snake extends Tile {
    void move(Direction direction) throws CollisionException;
    void move(Direction direction, int times) throws CollisionException;
}