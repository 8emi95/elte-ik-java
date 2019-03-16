package circles;
import points.Point;

public class Circle{
	private double radius;
	private Point center;
	
	public void translate(Point p){
		center.translate(p);
	}
	
	public double getRadius(){ return radius; }
	public void setRadius(double r){ 
		if(r < 0){
			throw new IllegalArgumentException();
		}
		radius = r; 
	}
	
	public Point getCenter(){ 
		Point p = 
			new Point(center.getX(), 
					  center.getY());
					  
	//	Point p = new Point();
	//	p.setX(center.getX());
	//	p.setY(center.getY());
		return p; 
	}
	
	public void setCenter(Point p){ 
		this.center = new Point(p.getX(), p.getY());
		
	//	this.center = new Point();
	//	this.center.setX(p.getX());
	//	this.center.setY(p.getY());
		 
	}
}
