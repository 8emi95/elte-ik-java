package snake;

import java.util.*;

import snake.util.*;
import snake.exception.CollisionException;
import snake.exception.InvalidIndexException;
import snake.parts.*;

public class Game{
	private final List<Apple> apples;
	private final Snake snake;
	
	public static ArrayList<Apple> toApples(List<String> lines){
		ArrayList<Apple> result = new ArrayList<>();
		if(lines != null){
			for(String s : lines){
				String[] array = s.split(" ");
				if(array.length == 2){
					try{
						int x = Integer.parseInt(array[0]);
						int y = Integer.parseInt(array[1]);
						try{
							Position pos = new Position(x,y);
							Apple app = new Apple(pos);
							result.add(app);
						}catch(Exception e){}
						
					}catch(NumberFormatException e){}
				}
			}
		}else{
			throw new IllegalArgumentException();
		}
		return result;
	}

	public Game(List<String> apples){
		this.apples = this.toApples(apples);
		this.snake = new SnakeHead(new Position(0,1), new Position(0,0), this);
	}
	
	public Apple getApple(){
		if(apples.isEmpty()){
			return null;
		}
		return apples.get(0);
	}
	
	public void ateApple(){
		apples.remove(apples.get(0));
	}
	
	public String play(List<String> moves) {
		StringBuilder sb = new StringBuilder();
		try{
			for(String s : moves){
				String[] tomb = s.split(" ");
				if(tomb.length == 1){
					try{
						snake.move(Direction.valueOf(tomb[0]));
						printState(sb);
					}catch(IllegalArgumentException e){}
				}else if(tomb.length == 2){
					try{
						try{
							snake.move(Direction.valueOf(tomb[0]), Integer.parseInt(tomb[1]));
							printState(sb);
						}catch(IllegalArgumentException e){}
					}catch(NumberFormatException e){}
				}
			}
			return sb.toString();
		}catch(CollisionException e){
			sb.append("GAME OVER");
			return sb.toString();
		}
	}
	
	private void printState(StringBuilder sb){
		PositionMap<Character> pm = new PositionMap<>(' ');
		if(apples != null){
			snake.print(pm);
			if(this.getApple() != null){
				this.getApple().print(pm);
			}
			for(int r = 0; r < Position.SIZE_OF_BOARD; r++){
				for(int c = 0; c < Position.SIZE_OF_BOARD; c++){
					Position pos = new Position(r,c);
					sb.append(pm.get(pos));
					if(c == Position.SIZE_OF_BOARD - 1){
						sb.append(System.lineSeparator());
					}
				}
			}
			sb.append("==========");
			sb.append(System.lineSeparator());
		}
	}
}