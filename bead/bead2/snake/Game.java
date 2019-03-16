package snake;

import java.util.List;
import java.util.ArrayList;

import snake.util.Position;
import snake.util.PositionMap;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.util.Direction;
import snake.parts.SnakeHead;

public class Game {
    private final ArrayList<Apple> apples;
    private final Snake snake;

    public static ArrayList<Apple> toApples(List<String> lines) {
        ArrayList<Apple> appleList = new ArrayList<Apple>();
        if (lines == null) {
            throw new IllegalArgumentException();
        } else {
            for (String line : lines) {
                String[] splitLine = line.split(" ");
                if (splitLine.length == 2) {
                    try {
                        appleList.add(new Apple(new Position(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]))));
                    } catch (NumberFormatException e) {
                    } catch (InvalidIndexException e) {}
                }
            }
        }
        return appleList;
    }

    public Game(List<String> apples) {
        this.apples = toApples(apples);
        snake = new SnakeHead(new Position(0, 1), new Position(0, 0), this);
    }

    public Apple getApple() { 
        if (!apples.isEmpty()) {
            return apples.get(0);
        } else {
            return null;
        }
    }

    public void ateApple() {
        apples.remove(getApple());
    }

    public String play(List<String> moves) {
        StringBuilder sb = new StringBuilder();
        try {
            for (String move : moves) {
                String[] splitMoves = move.split(" ");
                if (splitMoves.length == 1) {
                    try {
                        Direction direction = Direction.valueOf(splitMoves[0]);
                        snake.move(direction);
                        printState(sb);
                    } catch (IllegalArgumentException e) {}
                } else if (splitMoves.length == 2) {
                    try {
                        Direction direction = Direction.valueOf(splitMoves[0]);
                        snake.move(direction, Integer.parseInt(splitMoves[1]));
                        printState(sb);
                    } catch (IllegalArgumentException e) {}
                }
            }
        } catch (CollisionException e) {
            sb.append("GAME OVER");
            return sb.toString();
        }
        return sb.toString();
    }

    private void printState(StringBuilder state) {
        PositionMap<Character> map = new PositionMap<>(' ');
        snake.print(map);

        if (!apples.isEmpty()) {
            getApple().print(map);
        }

        for (int i = 0; i < Position.SIZE_OF_BOARD; ++i) {
            for (int j = 0; j < Position.SIZE_OF_BOARD; ++j) {
                state.append(map.get(new Position(i, j)));
            }
            state.append(System.lineSeparator());
        }
        state.append("==========");
        state.append(System.lineSeparator());
    }
}