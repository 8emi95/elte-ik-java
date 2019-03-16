package snake.util;

import snake.exception.InvalidIndexException;

public class Position{
	public static final int SIZE_OF_BOARD = 10;
	private final int row;
	private final int column;
	
	public Position(int row, int column){
		if(row >= 0 && row < SIZE_OF_BOARD && column >= 0 && column < SIZE_OF_BOARD){
			this.row = row;
			this.column = column;
		}else{
			throw new InvalidIndexException();
		}
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return this.column;
	}
	
	public boolean isSame(Position pos){
		if(pos != null && this.row == pos.row && this.column == pos.column){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}else if(obj == null){
			return false;
		}else if(this.getClass() != obj.getClass()){
			return false;
		}
		
		Position p = (Position) obj;
		if((this.getRow() == p.getRow()) && (this.getColumn() == p.getColumn())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return java.util.Objects.hash(row, column);
	}
}