/* not really...
3. Készítsük el a Student nevű osztályt, mely szintén kiterjeszti a Person osztályt! Vegyük fel új privát adattagként egy kurzusokon elért eredményeket tároló LinkedList referenciát!

Definiáljuk a következő metódusokat:
- Egy konstruktort, mely paraméterül várja a hallgató nevét és címét, melyekkel inicializálja a Person osztályban deklarált adattagokat. Itt is használjuk a Person konstruktorát!
- addCourseGrade(), mely paraméterül vár egy osztályzatot, és a lista végéhez fűzi.
- getAverage(), mely egy szövegben adja vissza a diák átlagát.
- toString() metódus, mely felüldefiniálja a Person osztály metódusát úgy, hogy kiegészíti annak eredményét. Például: "Student: Hát Izsák (Székesfehérvár) wage: 30000".

Hozzunk létre egy rövid main() metódust a PersonDemo osztályban! Definiálunk egy Person változót, mely egy Teacher objektumra mutat! Növeljük meg a fizetését, és írjuk ki a képernyőre az objektum szöveges reprezentációját! Melyik raise() és toString() hívódott meg?
*/

import java.util.*;

class Student extends Person {
	private List<Integer> courses;
	// private List<int> courses; // NEM JÓ

	public Student(String name, String address, List<Integer> courses) {
		super(name, address); // legelső dolog: meghívni a szülő konsiját
		courses = new ArrayList<>(); // courses = null; NEM JÓ
		this.courses.addAll(courses);
	}

	@Override
	public String toString() {
		return "Student: " + super.toString();
	}

	@Override
	public void raise() {
		wage += 20000;
	}
}