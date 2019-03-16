package snake;

import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.parts.SnakeHead;
import snake.util.Direction;
import snake.util.Position;
import snake.util.PositionMap;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private final ArrayList<Apple> apples;
    private final Snake snake;

    public static ArrayList<Apple> toApples(List<String> lines) {
        ArrayList<Apple> apples = new ArrayList<>();
        if(lines == null) {
            throw new IllegalArgumentException();
        }

        for(String elem : lines) {
            try {
                String[] tags = elem.split(" ");
                if(elem.matches("[0-9]\\s[0-9]")) {
                    int row = Integer.parseInt(tags[0]);
                    int column = Integer.parseInt(tags[1]);
                    Position position = new Position(row, column);
                    apples.add(new Apple(position));
                }
            }
            catch (InvalidIndexException e) {}
        }
        return apples;
    }

    public Game(List<String> apples) {
        this.apples = toApples(apples);
        snake =  new SnakeHead(new Position(0,1), new Position(0,0), this);
    }

    public Apple getApple() {
        if(!apples.isEmpty()) {
            return apples.get(0);
        }
        return null;
    }

    public void ateApple() {
        apples.remove(getApple());
    }

    public String play(List<String> moves) {
        StringBuilder sb = new StringBuilder();
        for(String step : moves) {
            if(step.matches("[A-Z]+")) {
                try{
                    Direction dir = Direction.valueOf(step);
                    snake.move(dir);
                    printState(sb);
                } catch(IllegalArgumentException e) {} catch (CollisionException e){
                    sb.append("GAME OVER");
                    return sb.toString();
                }

            }
            if(step.matches("[A-Z]+ (-|)[0-9]+")) {
                try {
                    String[] dirAndRepeat = step.split(" ");
                    Direction dir = Direction.valueOf(dirAndRepeat[0]);
                    int times = Integer.parseInt(dirAndRepeat[1]);
                    snake.move(dir, times);
                    printState(sb);
                } catch (CollisionException c){
                    sb.append("GAME OVER");
                    return sb.toString();
                } catch (IllegalArgumentException i) {}
            }
        }
        return sb.toString();
    }

    private void printState(StringBuilder stringBuilder) {
        PositionMap<Character> positionMap = new PositionMap<>(' ');
        snake.print(positionMap);
        if(!apples.isEmpty()) getApple().print(positionMap);

        for(int i = 0; i < Position.SIZE_OF_BOARD ;i++) {
            for(int j = 0; j < Position.SIZE_OF_BOARD; j++) {
                Position pos = new Position(i,j);
                stringBuilder.append(positionMap.get(pos));
            }
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append("==========");
        stringBuilder.append(System.lineSeparator());
    }
}