/*
4. Készítsük el a publikus geometry.Square osztályt, melynek egy objektuma egy négyzetet fog ábrázolni! Ez az osztály is megvalósítja a Figure interfész műveleteit.
a) Deklaráljunk három privát, int típusú adattagot, melyek a négyzet bal felső sarkának koordinátáit és a négyzet oldalának hosszát ábrázolják!
b) Definiáljunk egy konstruktort, mely paraméterül várja az adattagok kezdeti értékét, és ezekkel inicializálja az objektumot!
c) Definiáljunk egy alapértelmezett konstruktort, mely a bal felső sarkot az origóba, az oldal hosszát 1-re állítja.
d) Valósítsuk meg a Figure interfész műveleteit! Ezek a következők: move(), area() és show().
   A show() eredményére egy lehetséges példa: "Square at (1,-2) side: 3"
*/

package geometry;

public class Square implements Figure {
	private int a;
	private int x, y;

	public Square(int a, int x, int y) {
		this.a = a;
		this.x = x;
		this.y = y;
	}
	
	public double area() {
		return a * a;
	}
	
	public String show() {
		// return "Square(" + a + ")";
		return String.format("Square(%d, %d, %d)", a, x, y);
	}
	
	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}
}