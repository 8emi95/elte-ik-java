import java.util.Objects;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point translate(int dx, int dy) {
		return new Point(x + dx, y + dy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Point)) {
			return false;
		}
		Point oth = (Point) obj;
		return x == oth.x && y == oth.y;
	}

}
