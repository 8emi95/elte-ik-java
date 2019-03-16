2016.10.05.
4. Java EA

// (referenciákkal a heapen tárolt dógokra lehet hivatkozni)

class Point {
	int x, y; // 0-ra vannak inicializálva
}
Point p = new Point();
p.x == 0

attribútum nullszerű értékkel inicializálva
egész: 0
lebegőpontos: 0.0
boolean: false
char: \u0000
referencia: null


void m() { // m művelet
	Ponit p; // létrehoz egy p referenciát
	System.out.println(p.x);
	// fordítási hiba (statikus szemantikai szabály megsértése)

	Point p = new Point(); // inicializálva van, compiler nem panaszkodhat h...
	System.out.println(p.x);
	// minden oké

	Point p = null; // compiler: p kapott már értéket, nem baj h null, nem szól érte, csak az érdekli h definiált-e a p értéke
	System.out.println(p.x);
	// futási hiba (dinamikus szemantikai szabály megsértése)
	// kivétel formájában kapjuk meg (NullPointerException - 60% ilyen)
	// szemantikus hiba, de ezt nem a compiler szűri ki, hanem futás közben derül ki
}

void m(Point p) { // még nem derül ki h jól van-e megírva az, ami meghívja a metódust
	System.out.println(p.x);
}
m(new Point()) // így jó
m(null) // NullPointerException-t dob


public class Person {
	String name; // referencia típusú mező
	int age; // primitív típusú mező
}
new Person().age == 0
new Person().name == null

// dokumentációs megjegyzés
/**
	Mutable impelentáció.
	típusinvariáns: age >= 0 & name != null
*/
// műveletek megőrzik a típusinvariánst: ha műv kezdetén teljesül az invariáns akk végrehajtás után is teljesüljön (közben nem biztos h teljesül)
// sok ellenőrzés költséges, lassítja programot
public class Person {
	private String name;
	private int age;
	public Person(String name, int age) { // konstruktort úgy lehetne megírni h csak érvényes adatokkal legyen jó, előfeltétel ellenőrzése
		if (name == null) throw new IllegalArgumentException("...");
		if (age < 0) throw new IllegalArgumentException("...");
		this.name = name;
		this.age = age;
	}
	public int getAge() {return age;} // lekérdező művelet kell
	public String getName() {return name;}
	public int setAge(int age) { // int age?
		if (age < 0) throw new IllegalArgumentException("...");
		this.age = age;
	}
	public String setName() { // String name nem kell?
		if (name == null) throw new IllegalArgumentException("...");
		this.name = name;
	}
}

Person pityu = new Person("Kis Istvan", 24);
pityu.setName("Kis Istvan");
// imperatív stílus

public void muvelet(int parameter) {
	assert parameter != 0;
	...
}

/**
	Immutable implementáció
	a person objektumok belső állapota nem változhat meg a létrehozás után
	típusinvariáns: age >= 0 & ame != null
*/
public class Person {
	private final String name; // final: egyszer inicializáljuk és utána sose változtatjuk meg az értékét
	private final int age;
	public Person(String name; int age) {
		// előfeltétel ellenőrzése
		if (name == null) throw new IllegalArgumentException("...");
		if (age < 0) throw new IllegalArgumentException("...");
		this.name = name;
		this.age = age;
	}
	public int getAge() {return age;}
	public String getName() {return name;}
}

Person pityu = new Person("kis Istvan", 24);
pityu = new Person("Kis Istvan", pityu.getAge())
// funckionális sítlus

public class Point {
	private final int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
}

// tömbben tárolom intet
public class Point {
	private final int[] coords;
	public Point(int x, int y) {
		coords = new int[] {x, y};
	}
	public int getX() {return coords[0];}
	public int getY() {return coords[1];}
	public int[] coords() {return coords;}
}

Point p = new Point(1,1);
int[] c = p.coords();
c[0] = 5;
p.getX() == 5

a coords() metódus engedi kiszökni a Point belső állapotát
amin keresztül direkt manipulálható kívülről a belső állapot(a az obejtumnak)
sérti az OOP-elveket (private)
itt most az immutable designt is tönkreteszi

public class Point {
	private final int[] coords;
	public Point(int x, int y) {
		coords = new int[] {x, y};
	}
	public int getX() {return coords[0];}
	public int getY() {return coords[1];}
	public int[] coords() {return new int[]{coords[0], coords[1]};}
	// másolatokat ad vissza, ráadásul érdemes mély másolatot (deep copy) csinálni
	// HF: lehet ezen gyengíteni?
}

Point p = new Point(1, 3);
Point q = p;

élettartam vége: ha egy referencián keresztül sem érhető el az objektum
garbage collector begyűjtheti

tömb: egy objektum, a heapen tárolódik
tömb típus: speciális "osztály", speciális szintaxissal