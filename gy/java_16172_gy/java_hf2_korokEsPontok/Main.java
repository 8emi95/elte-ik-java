import geo.*;

class Main {
    public static void main(String[] args) {
        Circle c = new Circle(1);
        Point p = new Point(1,1);
        System.out.println(p + " inside " + c + "?");
        if (c.inside(p))
            System.out.println("Yepp.");
        else
            System.out.println("Nope.");
    }
}
