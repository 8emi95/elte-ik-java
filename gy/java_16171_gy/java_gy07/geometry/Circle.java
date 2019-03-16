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
	public double area() {
		return r * r * Math.PI;
	}
	
	public String show() {
		// return "Cirlce(" + r + ", " + x + ", " + y + ")";
		return String.format("Circle(%s, %s, %s)", r, x, y);
	}
	
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
}