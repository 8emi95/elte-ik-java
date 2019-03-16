package polyhedra;

import java.util.Comparator;

class ByArea implements Comparator<Prism> {
    public int compare(Prism p1, Prism p2) {
        return (int)(p1.area() - p2.area());
    }
}