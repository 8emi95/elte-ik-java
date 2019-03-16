package snake.util;
import snake.exception.InvalidIndexException;

public class Position
{
    public static final int SIZE_OF_BOARD = 10;
    private final int row;
    private final int column;

    public Position(int row, int column) {
        if(row >= 0 && row < SIZE_OF_BOARD && column >= 0 && column < SIZE_OF_BOARD) {
            this.row = row;
            this.column = column;
        }
        else {
            throw new InvalidIndexException();
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isSame(Position position) {
        return position != null && this.column == position.column && this.row == position.row;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) return isSame((Position) obj);
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public String toString() {
        return this.row + " " + this.column;
    }
}