package snake;

import snake.exception.CollisionException;
import snake.util.Direction;

public interface Snake extends Tile
{
    void move(Direction direction) throws CollisionException;
    void move(Direction direction, int times) throws CollisionException;
}