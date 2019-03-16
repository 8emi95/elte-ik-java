package polyhedra;

public final class Cube extends Prism {
	private double side;

	public Cube(double side) {
		super(side);
		this.side = side;
	}

	public double area() {
		return side * side;
	}

	public String toString() {
		return String.format("Cube(%5.2f)", side);
	}
}
