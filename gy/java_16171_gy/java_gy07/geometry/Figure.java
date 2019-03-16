/*
2. Készítsük el a publikus geometry.Figure interfészt! Ez kiterjeszti a fenti Movable és a  java.lang.Comparable<Figure> interfészt az alábbi metódusokkal:
a) Egy double visszatérési típusú area(), mely kiszámolja a síkidom területét.
b) Egy String visszatérési típusú show(), mely visszaadja a síkidom szöveges reprezentációját.
c) Valamint a Comparable interfész compareTo() metódusának adjunk egy alapértelmezett definíciót! Ez a síkidomokat területük alapján hasonlítja össze. Az a nagyobb síkidom, amelyiknek a területe nagyobb.
*/

// double -> Double: auto-boxing
// Double -> double: auto-unboxing

package geometry;
// minden ami Movable-ben (move) + Comparable-ben (compareTo) van... még hozzáadunk műveleteket
interface Figure extends Movable, Comperable<Figure> {
	double area();
	String show();
	default int compareTo(Figure f) {
		// return area() - f.area(); // pozitív legyen a nagyobb.... NEM JÓ INT MIATT
		// return Double.compare(area(), f.area());
		Double d = area(); // fordító primitívből referencia típust készít (double -> Double), auto-boxing, fordítva auto-unboxing
		return d.compareTo(d.area()); // paraméternél is auto-boxing		
	}
}