import java.util.Objects; // ?

class Point implements Comparable {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

    @Override public boolean equals(Object o) { // megörökölt obj-et vár, ezt kell felülírni
        // return x == p.x && y == p.y; // csak ennyivel Point p (Object o) pm nem jó
        if (o != null && o.getClass() == getClass()) {
            Point p = (Point) o;
            return x == p.x && y == p.y;
        } else {
            return false;
        }
    }

    // 1. Ha felüldefiniálod az equlas()-t akk definiáld felül a hashCode()-ot is
    // 2. Ha x.equlas(y) akk x.hashCode() == y.hashCode()
    @Override public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override public int compareTo(Point p) {
        if (x == p.x) {
            return y - p.y;
        } else {
            return x - p.x;
        }
    }
}