package snake;

import snake.util.Position;
import snake.util.PositionMap;

public class Apple implements Tile{
	private final Position position;
	
	public Apple(Position param){
		this.position = param;
	}
	
	@Override
	public Position getPosition(){
		return this.position;
	}
	
	@Override
	public void print(PositionMap<Character> map){
		map.put(this.getPosition(), 'o');
	}
}