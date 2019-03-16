/*
5. Készítsük el a geometry csomagon kívül a FigureDemo osztályt! Definiáljuk az alábbi két metódust:
a) Egy statikus, Figure visszatérési típusú biggest metódust, mely paraméterül várja Figure referenciák listáját (elfogadunk ArrayList-et és LinkedList-et is, ezért várjunk paraméterül egy  List referenciát)!
   A metódus egy maximumkiválasztást valósít meg a síkidomokon, és visszaadja a listából a legnagyobb területű síkidom referenciáját. Két síkidom összehasonlításához használjuk a  compareTo() metódust! Használjunk iterátort a paraméter lista bejárására! Iterátort a lista  iterator() metódusával tudunk kérni.
b) Írjunk main() metódust a biggest() kipróbálására! Inicializáljunk egy List referenciát egy  LinkedList objektummal és töltsük föl néhány síkidommal. Írassuk is ki a legnagyobb síkidom szöveges reprezentációját!
*/

import geometry.*;

public class FigureDemo {
	public static void main(String[] args) {
		Figure f1 = new Circle(5, 1, 0); // statikus típus - Figure, dinamikus típus - Circle
		Figure f2 = new Square(3, 5, 5);
		System.out.println(f2.area());
		// System.out.println(f2.sayHello()); // komment?
	}
}