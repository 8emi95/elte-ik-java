package polyhedra;

public final class Cylinder extends Prism {
	private double radius;

	public Cylinder(double radius, double height) {
		super(height);
		this.radius = radius;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public String toString() {
		return String.format("Cylinder(r: %5.2f, h: %5.2f)", radius, getHeight());
	}
}
