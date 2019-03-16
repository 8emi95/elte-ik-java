/*
3. Készítsük el a publikus geometry.Circle osztályt, mely egy kört fog ábrázolni! Az osztály megvalósítja a  Figure interfész műveleteit.
a) Deklaráljunk három privát int adattagot, melyek a kör közepének koordinátáit és a kör sugarát tárolják!
b) Készítsünk egy konstruktort, mely paraméterül várja a kör középpontjának x, y koordinátáit és a kör sugarát, és ezekkel inicializálja az adattagokat!
c) Készítsünk egy alapértelmezett konstruktort is, mely a kör középpontját az origóba és a kör sugarát 1-re állítja!
d) Valósítsuk meg a Figure interfész műveleteit! Ezek a következők: move(), area(), compareTo() és  show().
A show() eredményére egy lehetséges példa: "Circle at (2,4) radius: 5"
*/

package geometry;

public class Circle implements Figure {
	private int x, y, r;

	public Circle(int r, int x, int y) {
		this.r = r;
		this.x = x;
		this.y = y;
	}

	public String show() {
		// return "Circle at (" + x + ", " + y + "), radius: " + r;
		return String.format("Circle at (%d, %d), radius: %d", x, y, r);
	}

	public void move(int dx, int dy) {
		x += dx,
		y += dy,
	}

	public double area() {
		return Math.PI * r * r;
	}

	public int compareTo(Figure f) {
		return this.area() ...;
	}
}