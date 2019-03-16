// 1. Készítsük el a publikus geometry.Movable interfészt! Ez deklarálja a move() metódust, mely paraméterül vár két int típusú távolságot (függőleges és vízszintes), és nincs visszatérési értéke.

package geometry;

public interface Movable {
	void move(int dx, int dy);
}