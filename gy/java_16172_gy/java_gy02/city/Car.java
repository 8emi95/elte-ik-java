/*
2. Írjunk egy autókat ábrázoló Car osztályt! Az autókról eltároljuk a rendszámukat (String), hogy hány ajtósak (int) és a tulajdonosukat (Person). Készítsünk hozzá konstruktort is, mely inicializálja a mezőket!

a) Adjunk a Car osztályhoz egy isFamilyCar metódust, amely eldönti, hogy egy autó családi vagy sem! Családinak mondjuk a járművet, ha 5 ajtaja van.

b) Készítsünk egy isValid nevű metódust, mely logikai igazat ad vissza, ha az adott Car objektum érvényes! Ez akkor teljesül, ha
- a rendszám nem egy üres szöveg (ennek eldöntésére használjuk String.isEmpty() metódust),
- az ajtók száma 3 vagy 5,
- a tulajdonos nem egy üres referencia, vagyis nem null,
- a tulajdonos felnőttkorú a mostani évben.

c) Valósítjuk meg a Car objektukot szöveggé alakítását egy toString metódussal! Például egy "ABC-123" rendszámú, ötajtós, Roger Federer tulajdonában álló autó esetén állítsuk elő a következő szöveget: "ABC-123 5 doors, owner: Roger Federer"
*/

package city; // csomagdeklaráció

public class Car { // láthatóság!!!
	String license;
	int numOfDoors;
	Person owner;

	public Car(String license_, int numOfDoors_, Person owner_) {
		license = license_;
		numOfDoors = numOfDoors_;
		owner = owner_;
	}

	/*boolean isFamilyCar() {
		return numOfDoors = 5;
	}*/

	public boolean isValid() {
		return !license.isEmpty() 
			&& (numOfDoors == 3 || numOfDoors == 5) 
			&& (owner != null) 
			&& (owner.isAdult(2017));
	}

	public String toString() {
		return license + " " + numOfDoors + " doors, owner: " + owner.toString(); // + owner;
	}

}