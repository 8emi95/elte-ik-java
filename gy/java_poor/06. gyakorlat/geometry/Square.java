package geometry;

public class Square implements Figure {
    private int x, y;
    private final int side;

    public Square (int side, int x, int y) {
	this.side = side;
	this.x = x;
	this.y = y;
    }

    public void move(int dx, int dy) {
	x += dx;
	y += dy;
    }

    public double area() {
	return side * side;
    }

    public String show() {
	return String.format("Square topleft at (%d, %d), side: %d", x, y, side);
    }

    public int compareTo(Figure f) {
	Double d = area() - f.area(); // auto-boxing
	return d.intValue();
    }
}
