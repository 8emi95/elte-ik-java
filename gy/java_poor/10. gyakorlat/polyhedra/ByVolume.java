package polyhedra;

import java.util.Comparator;

public class ByVolume implements Comparator<Prism> {
	public int compare(Prism p1, Prism p2) {
		return (int)(p1.volume() - p2.volume());
	}
}
