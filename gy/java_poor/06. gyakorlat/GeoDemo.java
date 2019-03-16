import geometry.*;
import java.util.*;

public class GeoDemo {
    public static Figure largestFigure(Collection<Figure> figs) {
	Figure max = null;
	for (Figure f : figs) 
	    if (max == null || max.compareTo( f ) < 0)
		max = f;
	return max;
    }
    
    public static void main(String[] args) {
	Figure f = new Circle(5, 1, 2);
	Figure f2 = new Square(2, 5, 5);

	if (f.compareTo(f2) > 0) 
	    System.out.println(String.format("%s nagyobb mint %s", f.show(), f2.show()));
	else if (f.compareTo(f2) == 0)
	    System.out.println(String.format("%s es %s terulete egyenlo", 
					     f.show(),
					     f2.show()));
	else
 	    System.out.println(String.format("%s kisebb mint %s", f.show(), f2.show()));

	// f.sayHello(); // fordítási hiba: sayHello() nincs a Figure interfészben

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
