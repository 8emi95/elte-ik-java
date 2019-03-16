2016.09.21.
2. Java EA

szabályok, konvenciók és idiómák

objektum: adatok egy csoportja az alapműveletekkel együtt (adat + rajta értelmezett műveletek együttese)
osztály: típus - az azonos szerkezetű objektumok leírására (programozó által definiált)

egységbe zárás (encapsulation): összetartozó adatok és műveletek egy szintaktikus egységbe
információ elrejtése egymás között művelethívásokkal, "üzenetet küldenek"

v.ö. primitív típus:
--------------------
byte, short, int, long	// egész
float, double			// lebegőpontos
char					// 2 bájton ábrázolt
boolean					// logikai (true/false)

class Point {
	int x, y;	// adattagok
	void move(int dx, int dy) {	// metódus (alprogram, művelet)
		x += dx; // kifejezés
		y += dy;
	}
}

az osztály egy obj példánya
osztály -------------> objektum
		példányosítás, instantiation = konstruálás + inicializálás // (példányosítás: konstruálás, inicializáció is)
		jele: new Point()
			  egy kifejezés, melynek értéke egy objektum a Point osztályból
			  konstruálás: mellékhatásként megkonstruálja az objektumot
			  inicializálás: () között paraméterek

class Point {
	int x, y;	// adattagok
	void move(int dx, int dy) {	// metódus (alprogram, művelet)
		x += dx;
		y += dy;
	}	// formális paraméterek, formálisparaméter-lista
	Point(int initialX, int initialY) {   // konstruktor, NEM metódus
		x = initialX; // csak rövidítés (LEJJEBB (*))
		y = initialY;
	}
}

new Point(1,7) // aktuális paraméterek
// létrejön, inicializálás rögtön lefut
new Point(1,7).x // létrehozza Point obj-ot, x tagjára hivatkozik
System.out.println(new Point(1,7).x);
new Point(1,7).move(5,5)
Point p;			// típusként használjuk az osztályt, mint "int x;"
p = new Point(1,7); // feltöltjük
Point q = new Point(1,7);	// létrehozzuk, mint "int y = 1;"

p.move(5,5); // eltoljuk, 3 paraméter (p, 5, 5)
System.out.println(p.x); // kiírjuk az eltoltat
q.move(1,4); // q kitüntetett paraméter, metódushívás elején tüntetjük fel
			 // jelentés: move(q,1,4)  (nem helyes Javában)
kitüntetett paraméter: a metódust tartalmazó osztályba tartozó objektum


class Point {
	int x, y;	// adattagok
	void move(int dx, int dy) {	// metódus (alprogram, művelet)
		this.x += dx; // (*) ez a hivatalos, a this a kitüntetett (plusz egy) paraméter
		this.y += dy; // ha kontextusból kiderül, akkor nem kell "this"
	}
		// formális paraméterek, formálisparaméter-lista
	Point(int x, int y) {   // így 2 x van (1 adattag, 1 form. par.), a formális paraméter elfedi az adattagot
		this.x = x; // adattag = formális paraméter (egyértelmű jelölés)
		this.y = y;
	}
}

class Dummy {
	int x;
	static void sayHello() { // static: nincs kitüntetett (form?) paraméter
		System.out.println("hello"); //a metódusom belül nincs this
	} //amikor meghívjuk nem kell átadni Dummy osztályú objektumot paraméterként, ennek nincs paramétere
}

Dummy.sayHello();   // hívás
// qualified name / minősített név: osztálynév.metódusnév

package alma.fa; // Dummy-t beleteszem a csomagba, csomagnévvel minősítettem
class Dummy {
	int x;
	static void sayHello() {
		System.out.println("hello");
	}
}

alma.fa.Dummy.sayHello();   // hívás, osztálynév is minősített (csomagnévvel)

package alma.fa;
class Dummy {
	int x;
	static void sayHello() {
		System.out.println("hello " + x);  // fordítási hiba
		System.out.println("hello " + this.x);  // ezt jelenti, this-re hivatkozna DE nincs this!!!!
	}
}

alma.fa.Dummy d = new alma.fa.Dummy();
d.sayHello();     // félrevezető, buta jelölés (metódust objektumon meghívásnak tűnik)
alma.fa.Dummy.sayHello();   // ezt jelenti; nem ugyanolyan, mint a p.move(1,3)


osztályszintű: osztály része
példányszintű: osztályon hívjuk meg

package alma.fa;
class Dummy {
	static int x;
	static void sayHello() {
		System.out.println("hello " + x);  // értelmes
		System.out.println("hello " + alma.fa.Dummy.x);  // ezt jelenti
		System.out.println("hello " + this.x);  // NEM ezt jelenti! az utóbbi még mindig értelmetlen, nincs this
	}
}

alma.fa.Dummy.x // az osztály változója/adattagja/attribútuma
				// az x egy osztályszintű adattag, nem példányszintű, mint a Point-ban
//ma sayHello osztályszintű metódus, nem példányszintű, mint a move

p.x // minden Point objektumban van egy x mező
Dummy.x // csak egy x mező van, a Dummy objektumoktól függetlenül, a Dummy osztályban

OOP
- egységbe zárás
- információ elrejtésének elve: csak annyi látszódjon, amennyi feltétlen szükséges

osztály: interfész és megvalósítás
interfész: amit kívülről látunk belőle. "hogyan kell használni?", exportált
megvalósítás: elvonatkoztathatunk tőle, kifelé nem érdekes implementációs részletek
program komplexitásának csökkentése: szűk interfészek
programnyelvi támogatás: public és private

class Point {
	private int x, y; // x, y mezők elrejtése
	public void move(int dx, int dy) { // metódus nyilvános
		this.x += dx; // ez a hivatalos
		this.y += dy;
	}
	public Point(int x, int y) { // konstruktor nyilvános
		this.x = x;
		this.y = y;
	}
}

ÁLTALÁBAN így szokott lenni:
mező 				 -> inkább private
metódus, konstruktor -> inkább public

Point p = new Point(1,2);
p.move(3,4);
p.x // nem legális, lekérdező művelet kell (get)

public int getX() { // nyilvános, int típusú		konvenció: getMezőnév nével definiáljuk a lekérdező műveletet
	return x; // this.x
}
public void setX(int x) {
	this.x = x;
}
setter/getter műveleteket adhatok egy osztályhoz - ez egy idióma (megoldási módszer)


class Rational { // racionális számok, NEVEZŐ NEM LEHET NULLA
	int numerator, denominator;
}

Rational r = new Rational();
r.numerator = r.denominator = 0; //értelmetlen típusérték, nem szeretnénk 0 nevezőt megengedni
/*
r.denominator = 0;
r.numerator = 0;
*/

class Rational {
	private int numerator, denominator;
	public Rational(int numerator, int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("Denominator is zero!"); // hibajelzés
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public void setDenominator(int denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("Denominator is zero!"); // hibajelzés
		}
		this.denominator = denominator;
	}
	// ...
}
a klienskódban nem tudjuk rosszul használni, nulla nevezőjű törtet létrehozni
a típusinvariáns betartásáról a beállító műveletek gondoskodhatnak