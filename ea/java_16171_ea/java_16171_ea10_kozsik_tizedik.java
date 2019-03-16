class Base {}
EKVIVALENS
class Base {
	Base(){}
}
EKVIVALENS
class Base extends Object {
	Base(){
		super();   // Object-beli konstruktor
	}
}

class Sub extends Base {
	int x;
	Sub( int x ){
		super();
		this.x = x;
	}
	Sub(){   // overloaded
		super();
		x = 1;
	}
}
EKVIVALENS
class Sub extends Base {
	int x;
	Sub( int x ){
		super();
		this.x = x;
	}
	Sub(){   // overloaded
		this(1);
	}
}

-------------------

class Base {
	int y;
	Base( int y ){
		this.y = y;
	}
}

class Sub extends Base {
	int x;
	Sub( int x ){
		super(x);
		this.x = x;
	}
	// az alábbi konstruktor hibás
	Sub( ){				Sub(){ super(); this.x = 1; }
		this.x = 1;                  // értelmetlen super()
	}
}

-----------------------

Konstruktor szintaktikus képe:
- this-hívással kezdődik vagy super-hívással vagy egyikkel sem
- this és super hívás előtt más utasítás nem állhat

Konstruktor szemantikus képe:
- ha nem super vagy this hívással kezdődik, a fordító betesz az elejére
  egy super() hívást (paraméter nélküli konstruktor hívása!)


class Base {
	int y;
	Base( int y ){
		this.y = y;
	}
}

class Sub extends Base {}
ez is fordítási hiba, mert ezzel ekvivalens:
class Sub extends Base {
	Sub(){  		// default konstruktor kanonikus alakja
		super();
	}
}

------------------------------------------------------------------------
------------------------------------------------------------------------


statikus típus				dinamikus típus
--------------				---------------
statikus típusellenőrzés		dinamikus kötés
					dinamikus típusellenőrzés
					(altípusa a statikus típusnak)
						konkrétabb, pontosabb

statikus típusell.: biztonság (fordítási időben kiderülnek a hibák)
dinamikus típusell.: növeli a típusrendszer rugalmasságát
			pontosabb típusok ismeretében pontosabb döntések


	(típus)kif	típusellenőrzés és -kényszerítés

Base v = new Sub();

v		stat. típus: Base, din. típus: Sub
(Sub)v		stat. típus: Sub, din. típus: Sub

futási idejű (dinamikus) típusellenőrzés a dinamikus típus alapján
itt most ok

v = new Base();		// din. típus is Base
(Sub)v			// elbukik a dinamikus típusellenőrzés
			// futási hiba: ClassCastException kivétel lép fel

(String)v	értelmetlen, nem sikerülhet, fordítási hiba

downcast: statikusan bázistípusú kifejezést altípusára kényszerítünk
		explicit type-cast művelettel történik   (T)kif
		dinamikus típusellenőrzést indukál:
			futás közben megnézzük, hogy kif dinamikus típusa
			megfelel-e T-nek, azaz T-nek altípusa-e
upcast: cast nélkül is használhatok statikusan altípusban tartozó kifejezést
	bázistípusúba tartozóként

kif instanceof típus

ez egy logikai kifejezés
igaz, ha "kif" castolható "típus"-ra

if( kif instanceof T ){
	T v = (T) kif;     // nem vált ki ClassCastException-t
}

------------------------------------------------------------------------
------------------------------------------------------------------------

private	    <	package-private	    <     protected      < public

csak abban a def-ban
pl. class def-ben

		félnyilvános
		ugyanabban a csomagban

					  ugyanabban a csomagban is
					  és más csomagban lévő
					  leszármazott típusban

							   nyilvános
							   mindenhonnan

------------------------------------------------------------------------
------------------------------------------------------------------------

absztrakt osztály

abstract class C {}

típusként használhatom, de nem példányosítható (mint interface)

C v;  // ok
v = new C();  // fordítási hiba

feladata: leszármaztathatok belőle
("konkrét", azaz nem abstract leszármaztott példányosítható)
statikus típus lehet interface és abstract class is
dinamikus típus csak "konkrét" osztály lehet

- absztrahál, közös ősosztályként viselkedik (interface is ilyen)
- részleges implementáció megadására jó

abstract class C {
	protected int x;
	public void add( int v ){ x += v; }
}

ez a kód beleörököltethető a leszármazott osztályokba
ezzel a kód redundanciája csökkenthető (kevesebb ismétlődés)

öröklődés
  - altípusok bevezetése => altípusos polimorfizmus
    is-a reláció a típusok között, emberi gondolkodás, OO modellezés
  - kódöröklés
    megírt kód beleörököltethető más osztályokba (redundancia csökk.)

lehetnek benne absztrakt metódusok
abstract
csak példánymetódus lehet ilyen
(a JVM-ben ugyanúgy van implementálva az absztrakt metódus megvalósítása
konkrét leszármazottakban, mint a felüldefiniálás)
(felüldefiniálás: dinamikus kötés, azaz annak az objektumnak a dinamikus
típusa alapján választom ki a végrehajtandó kódot futási időben a különböző
felüldefiniált változatok közül, amelyikre meghívták)
(csak példánymetódusnálé van híváshoz használt objektum)

abstract class Hasáb {
	double magasság;
	double térfogat(){
		return alapterület() * magasság;
	}
	abstract double alapterület();
}

félkész osztály, nem példányosítható, mert van abstract művelete

class Henger extends Hasáb {
	double sugár;
	double alapterület(){ return sugár * sugar * Math.PI; }
}

class Kocka extends Hasáb {
	double alapterület(){ return magassag * magassag; }
}

a térfogat() metódust felparamétereztük az alapterület() metódussal

abstract class				interface

abstract példánymetódus 		abstract példánymetódus
konkrét példánymetódus			hasonló: default implement. példánym.
statikus metódus			statikus metódus
példányszintű és			-
osztályszintű mezők			-


egyszeres öröklődés:			többszörös öröklődés:
egy osztálynak csak			egy interfacenek lehet több
egy szülőosztálya			szülőinterfésze, és egy
					osztály megvalósíthat több interfészt

-> egyszeres kódöröklés			-> többszörös altípusképzés

többszörös öröklődés problémái: alapvetően a kódöröklés vonatkozásában
(nehéz jól definiálni...)
altípusképzés szempontjából ok

egyszerű matrad a nyelv,
de bonyolult OO modellek létrehozhatók benne (többszörös is-a reláció)

már az öröklődésnek is vannak problémái
- ugyan ez az alapgondolata az OOP-nek
- mégis óvatosan használjuk

ha mi magunk megtervezünk (öröklődéssel) egy osztályhierarchiát, az ok
más által írt kódból örökölni veszélyes

öröklődés helyett kompozíció használata (design pattern)

class Base {
	void m(){}
}

class Sub extends Base {
}

helyette

class Base {
	void m(){}
}

class Sub {
	private Base base = new Base();    // komponens
	void m(){ base.m(); }
}

hasonló hatás öröklődés nélkül, sokkal macerásabb, nincs altípusképzés
sokszor ezt a megoldást preferáljuk


interface Base {
	abstract void m();
}

class Impl implements Base {
	void m(){}
}

class Sub implements Base {
	private Impl impl = new Impl();    // komponens
	void m(){ impl.m(); }
}

///// 

final osztály: nem származtathatunk belőle
kódöröklés kiküszöbölése

interface Base {
	abstract void m();
}

final class Impl implements Base {
	void m(){}
}

final class Sub implements Base {
	private Impl impl = new Impl();    // komponens
	void m(){ impl.m(); }
}

//////

final metódus: nem definiálható felül

final void m(){}

leszármazott osztályban nem lehet új implementációt hozzárendelni

