package snake.util;

import java.util.HashMap;
import java.util.Map;

public class PositionMap<T>
{
    final Map<Position, T> map;
    final T defaultValue;

    public PositionMap(T defaultValue) {
        this.defaultValue = defaultValue;
        map = new HashMap<>();
    }

    public void put(Position pos, T element) {
        map.put(pos, element);
    }

    public T get(Position pos) {
        if(map.get(pos) != null) {
            return map.get(pos);
        }
        return  defaultValue;
    }
}