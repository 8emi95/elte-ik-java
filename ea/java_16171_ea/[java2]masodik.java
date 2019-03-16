szabályok, konvenciók és idiómák

objektum				osztály
--------				-------
adatok egy csoportja			típus: az azonos szerkezetű objektumok
az alapműveletekkel együtt		leírására (programozó által def-ált)
					v.ö. primitív típus
OOP					int, short, byte, long  // egész
					float, double // lebegőpontos
- egységbe zárás (encasulation)		char   // 2 bájton ábrázolt
  összetartozó adatok és műveletek	boolean // true. false
  egy szintaktikus egységbe

- információ elrejtése
  egymás között művelethívásokkal
  "üzenetet küldenek"


class Point {
	int x, y;	// adattagok
	void move( int dx, int dy ){	// metódus (alprogram, művelet)
		x += dx;
		y += dy;
	}
}


osztály --------> objektum
	példányosítás, instantiation

new Point()

egy kifejezés, melynek értéke egy objektum a Point osztályból
mellékhatásként megkonstruálja az objektumot

példányosítás: konstruálás, inicializáció is

class Point {
	int x, y;	// adattagok
	void move( int dx, int dy ){	// metódus (alprogram, művelet)
		x += dx;
		y += dy;
	}
	Point( int initialX, int initialY ){   // konstruktor
		// formális paraméterek, formálisparaméter-lista
		x = initialX;
		y = initialY;
	}
}

new Point(1,7)    // aktuális paraméterek


new Point(1,7).x
System.out.println( new Point(1,7).x );

new Point(1,7).move(5,5)

Point p;			int x;     // típusként használjuk az osztályt
p = new Point(1,7);

Point q = new Point(1,7);	int y = 1;
p.move(5,5);
System.out.println( p.x );

q.move(1,4);			jelentés: move(q,1,4)  (nem helyes Javában)

kitüntetett paraméter: a metódust tartalmazó osztályba tartozó objektum


class Point {
	int x, y;	// adattagok
	void move( int dx, int dy ){	// metódus (alprogram, művelet)
		this.x += dx;     // ez a hivatalos
		this.y += dy;
		x += dx;    // csak egy rövidítés
		/*
			a this a kitüntetett (plusz egy) paraméter
		*/

	}

	Point( int x, int y ){   // a formális par. elfedi az adattagot
		// formális paraméterek, formálisparaméter-lista
		this.x = x;
		// adattag = formális paraméter
		// egyértelmű jelölés
	}
}

class Dummy {
	int x;
	static void sayHello(){
		System.out.println("hello");
	}
}

nincs kitüntetett paraméter
a metódusom belül nincs this
amikor meghívjuk, nem kell átadni Dummy osztályú objektumot paraméterként
ennek nincs paramétere

Dummy.sayHello();   // hívás
// qualified name, minősített név: osztálynév.metódusnév

package alma.fa;
class Dummy {
	int x;
	static void sayHello(){
		System.out.println("hello");
	}
}


alma.fa.Dummy.sayHello();   // hívás
// osztálynév is minősített, csomagnévvel


package alma.fa;
class Dummy {
	int x;
	static void sayHello(){
		System.out.println("hello " + x);  // fordítási hiba
		System.out.println("hello " + this.x);  // ezt jelenti
		// nincs this!!!!
	}
}

alma.fa.Dummy d = new alma.fa.Dummy();
d.sayHello();     // félrevezető, buta jelölés
alma.fa.Dummy.sayHello();   // ezt jelenti; nem ugyanolyan, mint a p.move(1,3)

package alma.fa;
class Dummy {
	static int x;
	static void sayHello(){
		System.out.println("hello " + x);  // értelmes
		System.out.println("hello " + alma.fa.Dummy.x);  // ezt jelenti
		System.out.println("hello " + this.x);  // nem ezt jelenti!
		// az utóbbi még mindig értelmetle, nincs this
	}
}

alma.fa.Dummy.x		az osztály változója, adattagja, attribútuma
az x egy osztályszintű adattag, nem példányszintű, mint a Point-ban
a sayHello osztályszintű metódus, nem példányszintű, mint a move

p.x      minden Point objektumban van egy x mező
Dummy.x	 csak egy x mező van, a Dummy objektumoktól függetlenül, a Dummy osztályban

OOP
- egységbe zárás
- információ elrejtésének elve

osztály: interfész és megvalósítás
interfész: amit kívülről látunk belőle. "hogyan kell használni?", exportált
megvalósítás: elvonatkoztathatunk tőle, kifelé nem érdekes implementációs részletek

program komplexitásának csökkentése: szűk interfészek

programnyelvi támogatás: public és private


class Point {
	private int x, y;	// adattagok
	public void move( int dx, int dy ){	// metódus (alprogram, művelet)
		this.x += dx;     // ez a hivatalos
		this.y += dy;
		x += dx;    // csak egy rövidítés
		/*
			a this a kitüntetett (plusz egy) paraméter
		*/

	}

	public Point( int x, int y ){ 
		this.x = x;
		this.y = y;
	}
}

mező: inkább private
metódus, konstruktor: inkább public
szokott lenni

Point p = new Point(1,2);
p.move(3,4);
p.x nem legális
lekérdező művelet kell

public int getX(){
	return x;      // this.x
}


konvenció: getMezőnév névvel definiáljuk a lekérdező műveletet

setter/getter műveleteket adhatok egy osztályhoz
ez egy idióma (megoldási módszer)

public void setX( int x ){
	this.x = x;
}


class Rational {
	int numerator, denominator;
}

Rational r = new Rational();
r.numerator = r.denominator = 0;
/*
r.denominator = 0;
r.numerator = 0;
*/

értelmetlen típusérték, nem szeretnénk 0 nevezőt megengedni

class Rational {
	private int numerator, denominator;
	public Rational( int numerator, int denominator ){
		if( denominator == 0 ){
			// hibajelzés
			throw new IllegalArgumentException("Denominator is zero!");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public void setDenominator( int denominator ){
		if( denominator == 0 ){
			// hibajelzés
			throw new IllegalArgumentException("Denominator is zero!");
		}
		this.denominator = denominator;
	}
	// ...
}

a klienskódban nem tudjuk rosszul használni, nulla nevezőjű törtet létrehozni
a típusinvariáns betartásáról a beállító műveletek gondoskodhatnak


