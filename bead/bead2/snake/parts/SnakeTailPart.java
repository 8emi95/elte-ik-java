package snake.parts;

import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTailPart extends SnakeTail {
    private final SnakeTail next;

    public SnakeTailPart(Position position, SnakeTail next) {
        super(position);
        if (next != null) {
            this.next = next;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected void moveTo(Position position) {
        next.moveTo(this.getPosition());
        super.moveTo(position);
    }

    @Override
    protected boolean isAt(Position position) {
        if (this.getPosition().equals(position)) {
            return true;
        } else {
            return next.isAt(position);
        }
    }

    @Override
    public void print(PositionMap<Character> map) {
        map.put(this.getPosition(), '#');
        next.print(map);
    }
}