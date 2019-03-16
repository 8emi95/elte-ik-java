package snake.parts;

import snake.Tile;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTail implements Tile {
    protected Position position;

    public SnakeTail(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    protected void moveTo(Position position) {
        this.position = position;
    }

    protected boolean isAt(Position position) {
        if (this.position.equals(position)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void print(PositionMap<Character> map) {
        map.put(this.getPosition(), '~');
    }
}