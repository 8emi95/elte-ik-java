package geo;

public class Point {
    private int x,y;
    public Point(int x_, int y_) {
        x = x_;
        y = y_;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
