package descartes;

public class Point {
    public int x;
    public int y;
    
    public static double getDistance(Point p1, Point p2) {
        //return Math.sqrt((p2.x-p1.x) * (p2.x-p1.x)  +  (p2.y-p1.y) * (p2.y-p1.y));
        return Math.sqrt(p2.x-p1.x * p2.x-p1.x +  p2.y-p1.y * p2.y-p1.y);
    }
}