package game.utils;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Position implements Comparable<Position> {
/*
	private int y;
	private int x;

	public static final int MIN_X{ x = 1; }
	public static final int MIN_Y{ y = 1; }
	public static final int MAX_X{ x = 8; }
	public static final int MAX_Y{ y = 8; }
*/
	private int y, x;

	public static final int MIN_X = 1;
	public static final int MIN_Y = 1;
	public static final int MAX_X = 8;
	public static final int MAX_Y = 8;
	public static final Position INITIAL_POSITION = new Position(1, 1);
	public static final Position WINNING_POSITION = new Position();

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private Position() {
		Random rand = new Random();
		int x = rand.nextInt(MAX_X) + 1;
		int y = rand.nextInt(MAX_Y) + 1;
	
		while (x == INITIAL_POSITION.getX()) {
			x = rand.nextInt(MAX_X) + 1;
		}

		while (y == INITIAL_POSITION.getY()) {
			y = rand.nextInt(MAX_Y) + 1;
		}

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isInside() {
		return this.getX() > 0 && this.getX() < 9 && this.getY() > 0 && this.getY() < 9;
	}

	public List<Position> neighbours() {
		ArrayList<Position> nb = new ArrayList<Position>();
		if (this.getX() - 1 > 0) {
			nb.add(new Position((this.getX()-1), this.getY()));
		}
		if (this.getX() + 1 < 9) {
			nb.add(new Position((this.getX()+1), this.getY()));
		}
		if (this.getY() - 1 > 0) {
			nb.add(new Position(this.getX(), (this.getY()-1)));
		}
		if (this.getY() + 1 < 9) {
			nb.add(new Position(this.getX(), (this.getY()+1)));
		}
		return nb;
	}

	@Override public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}

	@Override public boolean equals(Object pos) {
		return (this.getX() == ((Position)pos).getX() && this.getY() == ((Position)pos).getY());
	}

	@Override public int hashCode() {
		return (this.getX() + this.getY() * 100);
	}

	public int compareTo(Position pos) {
		if (this.getX() == pos.getX()) {
			return Integer.compare(this.getY(), pos.getY());
		} else {
			return Integer.compare(this.getX(), pos.getX());
		}
	}
}