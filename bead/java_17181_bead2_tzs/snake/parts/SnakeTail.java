package snake.parts;

import snake.Tile;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTail implements Tile
{
    protected Position position; //a SnakeTailPart leszármazik belőle ezért nem lehet private

    public SnakeTail(Position position) {

        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void print(PositionMap<Character> map) {
        map.put(position, '~');
    }

    protected void moveTo(Position position) {
        this.position = position;
    }

    protected boolean isAt(Position position) {
        return this.position.equals(position);
    }
}