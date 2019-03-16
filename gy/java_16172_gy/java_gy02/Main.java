/*
3. Helyezzük el a Person és a Car osztályokat egy city nevű csomagba! Ehhez mozgassuk át a forrásfájlokat egy újonnan létrehozott city könyvtárba és írjuk a fájlok elejére a csomag deklarációt.

4 .Írjunk egy main metódust! Helyezzük el ezt egy Main osztályban, melyet tegyük a program csomagba! A main metódus törzsében hozzunk létre egy személy és egy autó objektumot, majd írassuk ki az utóbbit a szabványos kimenetre!
*/

/*
3. Helyezzük el a Person és a Car osztályokat egy city nevű csomagba! Ehhez mozgassuk át a forrásfájlokat egy újonnan létrehozott city könyvtárba és írjuk a fájlok elejére a csomag deklarációt.
*/

import city.*; // csomagdeklaráció

class Main {
	public static void main(String[] args) {
/*		Person p = new Person("Roger", "Federer", 1985);
		Person q = new Person("Rafael", "Nadal", 1987);

		//Person.isUpperCase = true;

		System.out.println(p);
		System.out.println(q);

		Car c = new Car("ABC", 5, null);
		System.out.println(c.isValid());*/


		Person p = Person.makePerson("Roger", "Federer", 1981);
		Person q = Person.makePerson("Rafael", "Nadal", 1986);
		Car c = new Car("ABC-242", 5, p);
		Car c2 = new Car("CDE-424", 3, q);
		// Person.isUpperCase = true;
		System.out.println(p);
		System.out.println(q);
		System.out.println(c);
		System.out.println(c2);
	}
}