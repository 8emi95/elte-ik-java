package snake.parts;

import java.lang.*;

import snake.Snake;
import snake.Game;
import snake.util.Position;
import snake.util.PositionMap;
import snake.util.Direction;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.parts.SnakeTail;

public class SnakeHead extends SnakeTail implements Snake{
	private final Game game;
	private SnakeTail tail;
	
	public SnakeHead(Position position, Position positionOfTail, Game game){
		super(position);
		this.game = game;
		this.tail = new SnakeTail(positionOfTail);
	}
	
	@Override
	public void move(Direction dir, int times)throws CollisionException{
		if(times > 0){
			for (int i = 0; i < times; i++){
				move(dir);
			}
		}
	}
	
	@Override
	public void move(Direction dir) throws CollisionException{
		switch(dir){
			case UP:
				move(this.getPosition().getRow() - 1, this.getPosition().getColumn());
			break;
			case DOWN:
				move(this.getPosition().getRow() + 1, this.getPosition().getColumn());
			break;
			case RIGHT:
				move(this.getPosition().getRow(), this.getPosition().getColumn() + 1);
			break;
			case LEFT:
				move(this.getPosition().getRow(), this.getPosition().getColumn() - 1);
			break;
		}
	} 
	
	private void move(int row, int column) throws CollisionException{
		try{
			Position pos = new Position(row,column);
			if(tail.isAt(pos)){
				throw new CollisionException();
			}else{
				if(game.getApple() == null || !pos.equals(game.getApple().getPosition())){
					tail.moveTo(this.getPosition());
					this.moveTo(pos);
				}else{
					tail = new SnakeTailPart(this.getPosition(), tail);
					game.ateApple();
					this.moveTo(pos);
				}
				
			}
		}catch(InvalidIndexException e){
			throw new CollisionException();
		}
		
		
	}
	
	@Override
	public void print(PositionMap<Character> map){
		map.put(this.getPosition(), '@');
		tail.print(map);
	}
}