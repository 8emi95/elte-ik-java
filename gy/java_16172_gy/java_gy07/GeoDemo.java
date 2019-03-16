import geometry.*;
import java.util.LinkedList;

public class GeoDemo {
	public static Figure largestFigure(LinkedList<Figure> figs) { // nem muszáj publicnak lennie
		if (!figs.isEmpty()) {
			Figure max = null; // Figure max = figs.getFirst();
			for (Figure f : figs) { // for (int i 7 1; i < figs.size(); ++i) {
				if (max.compareTo(f) < 0) // (max.compareTo(figs.get(i)) < 0) { // max < figs.get(i) ???
					max = f; // max = figs.get(i);
				}
				return max;
			}
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		Figure f = new Circle(5, 1, 2);
		Figure f2 = new Square(2, 5, 5);

		if (f.compareTo(f2) > 0) { // 1, -1 helyett, 0 poz neg-at kapunk vissza
			// System.out.println(f.show() + " nagyobb, mint " + f2.show());
			System.out.println(String.format("%s nagyobb, mint %s", f.show(), f2.show()));
		} else if (f.compareTo(f2) == 0) {
			System.out.println(String.format("%s es %s terulete egyenlo", f.show(), f2.show()));
		} else {
			System.out.println(String.format("%s kisebb, mint %s", f.show(), f2.show()));
		}

		// f.sayHello(); // fordítási hiba: sayHello() nincs Figure interface-ben

		LinkedList<Figure> figs = new LinkedList<>();
		figs.add(f2);
		figs.add(new Circle(1, -2, 2));
		figs.add(f);

		Figure largest = largestFigure(figs);
		System.out.println(largest.show());

		HashSet<Figure> figsSet = new HashSet<>();
		figsSet.add(f2);
		figsSet.add(new Circle(1, -2, 2));
		figsSet.add(f);

		largest = largestFigure(figsSet);
		System.out.println(largest.show());
	}
}