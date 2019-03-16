package snake.parts;

import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTailPart extends SnakeTail
{
    private final SnakeTail next;

    public SnakeTailPart(Position position, SnakeTail next) {
        super(position);
        if(next == null) {
            throw new IllegalArgumentException();
        }
        this.next = next;
    }

    @Override
    protected void moveTo(Position position) {
        next.moveTo(this.position);
        super.moveTo(position);
    }

    @Override
    protected boolean isAt(Position position) {
        if(this.position.equals(position)) {
            return true;
        }
        else {
            return next.isAt(position);
        }
    }

    @Override
    public void print(PositionMap<Character> map) {
        map.put(position, '#');
        next.print(map);
    }
}
