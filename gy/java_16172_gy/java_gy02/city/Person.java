/*
1. Készítsünk egy Person osztályt, mely egy személyt fog ábrázolni! A személyekről nyilvántartjuk a vezeték- és keresztnevüket (két String), illetve a születésük évét (int). Legyen egy konstruktora is, mely átveszi az adattagok kezdeti értékeit paraméterül!

a)
Adjunk a Person osztályhoz egy isAdult metódust! Ez egy évszámot vár és logikai igazat ad vissza, ha az adott személy felnőtt korú az adott évben, hamisat, ha kiskorú.

b) Tegyük lehetővé, hogy egy Person objektumot szöveggé alakíthassunk! Ehhez készítsünk egy toString metódust, mely egymás után fűzi a vezeték- és keresztnevet egy szóközzel elválasztva.

c) Vegyünk fel egy osztályszintű logikai adattagot, melynek hatására egycsapásra minden személy nevét nagybetűkkel írja ki a toString!


5. Írjuk át a Person konstruktorát egy makePerson nevű statikus metódussá, mely létrehoz egy Person típusú objektumot! Ehhez létre kell hozni egy inicializálatlan Person típusú objektumot és be kell állítani az adattagjait. A makePerson paramétere legyen a személy vezeték- és keresztneve és születési éve!
*/

package city; // csomagdeklaráció

public class Person { // láthatóság!!!
	String firstName, lastName;
	int yearOfBirth;
	static boolean isUpperCase; // = false;

/*	public Person(String firstName_, String lastName_, int yearOfBirth_) {
		firstName = firstName_;
		lastName = lastName_;
		yearOfBirth = yearOfBirth_;
		// Person(String firstName, ...) {firstName = firstName; } // this kell
	}*/

	public boolean isAdult(int year) {
		return (year - yearOfBirth) >= 18;
	}

	public String toString() {
		if (isUpperCase) {
			return firstName.toUpperCase() + " " + lastName.toUpperCase();
		} else {
			return firstName + " " + lastName;
		}
	}

	public Person makePerson(String firstName_, String lastName_, int yearOfBirth_) {
		if (yearOfBirth_ >= 1900 && yearOfBirth_ <= 2017 && !firstName_.isEmpty() && !lastName_.isEmpty()) {
			Person p = new Person();
			p.firstName = firstName_;
			p.lastName = lastName_;
			p.yearOfBirth = yearOfBirth_;
			return p;
		} else {
			return null;
		}
	}

	/*public String show() {
		return firstName + " " + lastName; // Person.@54e4545 ír ki
	}*/

	//

}