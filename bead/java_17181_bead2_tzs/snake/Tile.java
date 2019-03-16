package snake;
import snake.util.Position;
import snake.util.PositionMap;

public interface Tile {
    Position getPosition();
    void print(PositionMap<Character> map);
}