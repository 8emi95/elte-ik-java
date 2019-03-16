package snake.parts;

import snake.util.Position;
import snake.util.PositionMap;
import snake.Tile;

public class SnakeTail implements Tile{
	private Position position;
	
	public SnakeTail(Position param){
		this.position = param;
	}
	
	@Override
	public Position getPosition(){
		return this.position;
	}
	
	protected void moveTo(Position param){
		this.position = param;
	}
	
	protected boolean isAt(Position param){
		if(this.position == param){
			return true;
		}
		return false;
	}
	
	@Override
	public void print(PositionMap<Character> map){
		map.put(this.getPosition(), '~');
	}
}