2017.03.02.
3. Java EA

a két osztály közül melyiknek van konstruktora?

public class Point {
	public double x, y;
}
public class Line {
	Public double a, b;
	public void line(aVal, bVal) {
		a = aVal;
		b = bVal;
	}
}

a) Point
b) Line
c) mindkettő - HELYES
d) egyik sem


változódeklaráció:
- mező -> objektum része
- lokális -> metódusban

hatókör/scope: az a blokk, amely közvetlenül tartalmazza a deklarációt

void dummy(int n) {															// }
	int x = 3; 											// }				// }
	for (int i = 0; i < n; ++i) {	// }				// }				// }
		System,out.println(i);		// } i hatóköre		// } x hatóköre		// } n hatóköre
	}								// }				// }				// }
	int u = 5;, v = u; // ???
	int p = p; // ???
}														// }				// }

void foo() {
	// ...
	{
		int x;	// }
		// ...	// } hatókör
	}			// }
	// ...
}

void foo() {
	int x;
	{
		int x;	// fordítási hiba
		// ...
	}
	// ...
}

memóriagazdálkodás: kisebb hatókör miatt rövidebb ideig foglalja a memóriát a "nagy" változó
kid? komplexitásának csökkentett?, olvashatóság? // kozsik írása kvára nem olvasható
{
	int i = 0;
	while (i < n) { ... ++i; }
}

lokális váktozó hatókörében ugyanazzal a névvel nem lehet másikat deklarálni, azaz nem lehet egy lokális változót egy másikkal "elfedni" (hide, shadow)

public class Point {
	private int x, y; // this.x -> private int x, this.x = x (utóbbi) -> public Point(int x, ...)
	public Point(int x, int y) { // elfedjük az objektummezőket -> a közelebbi deklaráció "látható"
		this.x = x; // this.x objektummező: minősített névvel mégis hozzáférünk a beksp deklarációben bevezetett, a belsővel elfedett váltózóhoz, kiterjesztett láthatóság (extended visibility)
		this.y = y;
	}
	public void setX (int x) {
		this.x = x;
	}
}

Javabeans? konvenció
objektum property: a setter és getter mentén
public void setValami(int valami) {...}	// } int típusú "valami" property
public int getValami() {...}			// }
egy lehetséges megvalósítása:
priate int valami; // this valami = valami


this: kulcsszó
metódusban és ?ban az "aktuális" objektumot azonosítja
p.move(3, 7) // move-on belül a p-ben a this
new Point(3, 7) // konsin belül az épp létrehozott obj lesz a this
minden példánymetódusnak "eggyel több" paramétere van <- a formálisparaméter-listához képest


class Bar {
	int p;
	static int s;
}

minden Bar objektumban ("példányban") van egy p mező (példányszintű mező),
de csak egy s mező jön létre és ugyanazt használja az összes Bar objektum, azaz az s a Bar osztályhoz tartozik (statikus, avagy osztályszintű mező)

java.lang.Math.PI
PI -> statikus mező, "konstans", egy final mező
java.lang -> Object, Class, String ..., "import" utasítás nélkül is vövid névvel hivatkozható minden benne lévő típusdefiníció
java.lang.Math = Math

package java lang;

public class Math {
	public static final double PI = 3.1415926545;
}


mutable/módosítható design (impertív stílus)
public class Point {
	private int x, y;
	public Point(int x, int y) {...}
	public void setX(int x) { this.x = x; }
	public int setX() { return x; }
	// ...
	public void move(int dx, int dy) {
		x += dx;
		y += dy,
	}
}

immutable/módosíthatatlan design (funkcionális stílus)
public class Point {
	private final int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int setX() { return x; }
	// ...
	public void move(int dx, int dy) {
		return new Point(x + dx, y + dy);
	}
}

Point p = new Point(1, 1);
p = p.move(3, 3); // <- szekvenciális esetben is: megbízhatóbb programok, kevesebb hiba
- pazarló megoldás: memória foglalás minden "módosító" műveletnél, végrahajtási időben és memóriahasználatban overhead?
- nem is "annyira", ilyen a JVM
- hatékonyabb párhuzmos konzisztens??? programozásban


létrehozás, inicializáció:
- amikor new-val létrehozunk egy objektumot, létrejönnek a példánymezők benne 
- inicializálás azononnal
	1) minden mező 0-szerű értékkel (nem létezik? memóriaszemetet)	// }
	2) inicializáló kifejezések (inicializáló ? is)					// } final mező?e pontosan egy értékadás
	3) konstruktoron keresztül										// }

objektummezők:
- létrejön, amikor az osztál "betöltődik" a JVM-be
- inicializálódnak ugyanakkor
	1) 0-szerű érték
	2) inicializáló kifejezések (statikus inicializátor blokk)
- amíg a py? tart

lokális változó:
- létrejön, amikor belépünk a deklarációjának a hatókörébe
- inicializáció 0-szerű értéke NINCS, nem olvasható a változó értéke, amíg értéket nem kap a programban -> fordítóprogram kényszeríti ki
- megszűnik, amikor kilépünk a hatókörből

void foo() {
	int n;
	++n; // fordítási hiba
}
"?atív" ellenőrzés
a fordtó visszautasíthat "értelmes" programokat h szerinte nem garantélt a helyes viselkedés


void akarmi??? {
	//blabla letörölte....
}