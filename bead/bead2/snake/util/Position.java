package snake.util;

import java.util.Objects;

import snake.exception.InvalidIndexException;

public class Position {
    public static final int SIZE_OF_BOARD = 10;
    private final int row;
    private final int column;

    public Position(int row, int column) {
        if (row >= 0 && row < SIZE_OF_BOARD && column >= 0 && column < SIZE_OF_BOARD) {
            this.row = row;
            this.column = column;
        } else {
            throw new InvalidIndexException();
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public boolean isSame(Position position) {
        if (position != null && this.row == position.row && this.column == position.column) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getRow(), this.getColumn());
    }

    @Override
    public boolean equals(Object object) {
        if (this != null && 
            object != null && 
            this.getClass() == object.getClass() &&
            this.isSame((Position) object)) {
            return true;
        }
        return false;
    }
}