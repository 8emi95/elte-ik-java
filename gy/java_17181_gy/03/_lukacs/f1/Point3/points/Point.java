package points;

public class Point{
	private double x;
	private double y;
	
	public double getX(){ return x; }
	public double getY(){ return y; }
	
	public void setX(double x){ this.x = x; }
	public void setY(double y){ this.y = y; }
	
	public Point(){ 	}
	
	public Point(double x, double y){
		this.setX(x);
		this.setY(y);	
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	public void translate(Point p){
		// x = x + p.x;   
		x += p.x;
		// y = y + p.y;
		y += p.getY();
	}
}
