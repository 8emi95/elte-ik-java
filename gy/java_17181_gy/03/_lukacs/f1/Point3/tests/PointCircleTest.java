package tests;
import points.Point;
import circles.Circle;


public class PointCircleTest {
	public static void main(String[] args){
		Point p = new Point(2.0, 3.0);
		
		// Point p = new Point();
		// p.setX(2.0);
		// p.setY(3.0);
		
		Circle c = new Circle();
		c.setCenter(p);
		
		System.out.println(c.getCenter());	
		
		Point p2 = new Point(1.0, 1.0);
		
		//Point p2 = new Point(1.0, 1.0);
		//p2.setX(1.0);
		//p2.setY(1.0);
		
		p.translate(p2);
		
		System.out.println(c.getCenter());	
		
		
		Point[] points = { p, c.getCenter(), p2 };
		
		/*
		Point[] points = new Point[3];	
		points[0] = p;
		points[1] = c.getCenter();
		points[2] = p2;
		*/
		
		System.out.println(centerOfMass(points));	
		
	}
	
	public static Point centerOfMass(Point[] points){
		double cx = 0.0;
		double cy = 0.0;
		
		for(Point p : points){
			cx += p.getX();
			cy += p.getY();
		}
		
		/*
		for(int i=0; i<points.length; ++i){
			cx += points[i].getX();
			cy += points[i].getY();
		}
		*/
		
		cx /= points.length; 
		cy /= points.length;
		
		return new Point(cx, cy);
		
		
	}
	
	
}



























