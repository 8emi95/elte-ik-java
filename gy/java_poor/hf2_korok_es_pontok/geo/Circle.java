package geo;

public class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public boolean inside(Point p) {
        int x = p.getX();
        int y = p.getY();
        return radius >= Math.sqrt(x * x + y * y);
    }

    public String toString() {
        return "Circle, radius: " + radius;
    }
}
