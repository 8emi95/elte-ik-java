package polyhedra;

public abstract class Prism {
	private double height;

	public Prism(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public abstract double area();
    
	public final double volume() {
		return area() * height;
	}
}
