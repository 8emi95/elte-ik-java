package snake.util;

import java.util.HashMap;
import java.util.Map;

public class PositionMap<T>{
	private final Map<Position, T> map;
	private final T defaultValue;
	
	public PositionMap(T defaultValue){
		this.defaultValue = defaultValue;
		this.map = new HashMap<Position, T>();
	}
	
	public void put(Position pos, T element){
		map.put(pos, element);
	}
	
	public T get(Position pos){
		if(map.get(pos) != null)
			return map.get(pos);
		else
			return defaultValue;
	}
}