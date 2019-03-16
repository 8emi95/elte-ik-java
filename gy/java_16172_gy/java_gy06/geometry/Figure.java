/*
2. Készítsük el a publikus geometry.Figure interfészt! Ez kiterjeszti a fenti Movable és a  java.lang.Comparable<Figure> interfészt az alábbi metódusokkal:
a) Egy double visszatérési típusú area(), mely kiszámolja a síkidom területét.
b) Egy String visszatérési típusú show(), mely visszaadja a síkidom szöveges reprezentációját.
c) Valamint a Comparable interfész compareTo() metódusának adjunk egy alapértelmezett definíciót! Ez a síkidomokat területük alapján hasonlítja össze. Az a nagyobb síkidom, amelyiknek a területe nagyobb.
*/

package geometry;
										// Figure-t összehasonlítja másik <Figure>-rel
public interface Figure extends Movable, Comparable<Figure> { // automatikusan tartalmazza Movable:move()
	double area();
	String show();
}