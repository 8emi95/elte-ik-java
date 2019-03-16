import java.util.Objects;

class Point implements Comparable<Point> {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
    
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == getClass()) {
			Point p = (Point) o;
			return x == p.x && y == p.y;
		} else 
			return false;
	}

	// Java törvények:
	//   1. Ha felüldefiniálod az equals()-t, akkor definiáld felül a hashCode()-t is
	//   2. Ha x.equals(y), akkor x.hashCode() == y.hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public int compareTo(Point p) {
		if (x == p.x)
			return y - p.y;
		else
			return x - p.x;
	}
}
