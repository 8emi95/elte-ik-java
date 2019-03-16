package snake.parts;
import snake.Game;
import snake.Snake;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.util.Direction;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeHead extends SnakeTail implements Snake
{
    private final Game game;
    private SnakeTail tail;

    //position ~ positionOfHead
    public SnakeHead(Position position, Position positionOfTail, Game game) {
        super(position);
        this.game = game;
        this.tail = new SnakeTail(positionOfTail);
    }

    @Override
    public void move(Direction dir) throws CollisionException {
        switch (dir) {
            case UP: {
                super.position = move(super.position.getRow() - 1, super.position.getColumn());
                break;
            }
            case DOWN: {
                super.position = move(super.position.getRow() + 1, super.position.getColumn());
                break;
            }
            case RIGHT: {
                super.position = move(super.position.getRow(), super.position.getColumn() + 1);
                break;
            }
            case LEFT: {
                super.position = move(super.position.getRow(), super.position.getColumn() - 1);
                break;
            }
        }
    }

    @Override
    public void move(Direction dir, int times) throws CollisionException{
        if(times > 0) {
            for (int i = 0; i < times; i++) {
                move(dir);
            }
        }
    }

    private Position move(int row, int column) throws CollisionException{
        Position position;
        try {
             position = new Position(row, column);
            if(tail.isAt(position)) {
                throw new CollisionException(); // snake collided with itself
            }
            else {
                if(game.getApple() != null && position.equals(game.getApple().getPosition())) {
                    SnakeTailPart snakeTailPart = new SnakeTailPart(super.position,tail);
                    tail = snakeTailPart;
                    game.ateApple();
                }
                else {
                    tail.moveTo(super.position);
                }
            }
        } catch (InvalidIndexException e) {
            throw new CollisionException();
        }
        return position;
    }

    @Override
    public void print(PositionMap<Character> map) {
        map.put(position, '@');
        tail.print(map);
    }
}
