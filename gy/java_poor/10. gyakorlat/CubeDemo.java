import java.util.*;
import polyhedra.*;

public class CubeDemo {
	public static void main(String[] args) {
		List<Prism> prisms = new ArrayList<>();
		prisms.add(new Cube(4));
		prisms.add(new Cube(1));
		prisms.add(new Cylinder(4, 0.5));
		prisms.add(new Cube(2));

		System.out.println(prisms);
		Collections.sort(prisms, new ByVolume());
		System.out.println(prisms);
		Collections.sort(prisms, new ByArea());
		System.out.println(prisms);
	}
}
