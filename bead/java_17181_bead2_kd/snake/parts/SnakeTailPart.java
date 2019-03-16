package snake.parts;

import snake.parts.SnakeTail;
import snake.util.Position;
import snake.util.PositionMap;

public class SnakeTailPart extends SnakeTail{
	private final SnakeTail next;
	
	public SnakeTailPart(Position position, SnakeTail next){
		super(position);
		
		if(next != null){
			this.next = next;
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	protected void moveTo(Position param){
		next.moveTo(this.getPosition());
		super.moveTo(param);
	}
	
	@Override
	protected boolean isAt(Position param){
		if(param.equals(this.getPosition())){
			return true;
		}
		return next.isAt(param);
	}
	
	@Override
	public void print(PositionMap<Character> map){
		map.put(this.getPosition(), '#');
		next.print(map);
	}
}