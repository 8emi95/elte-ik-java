package snake.util;

import java.util.Map;
import java.util.HashMap;

public class PositionMap<T> {
    final Map<Position, T> map;
    final T defaultValue;

    public PositionMap(T defaultValue) {
        this.map = new HashMap<>();
        this.defaultValue = defaultValue;
    }

    public void put(Position pos, T element) {
        map.put(pos, element);
    }

    public T get(Position pos) {
        T ret = map.get(pos);
        if (ret != null) {
            return ret;
        } else {
            return defaultValue;
        }
    }
}