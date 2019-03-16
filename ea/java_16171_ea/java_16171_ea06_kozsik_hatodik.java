overloading, túlterhelés
egy osztályban több művelet ugyanazzal a névvel, de különböző paraméterezéssel:
- különböző számú formális paraméter, pl. ArrayList:
  void add( elem )
  void add( elem, index )

- különböző deklarált típusú (különböző "statikus" típusú) paraméterek

System.out.println(int)
System.out.println(String)

- fordító ki tudja választani fordítási időben, melyiket hívjuk
- amíg nem használjuk rosszul, addig segíti a programozót:
  egyfajta polimorfizmus
  polimorfizmus = többalakúság (szó szerint)
                = több típussal működik valami (prog. lang.)
- ügyetlen használat:
  - bonyolult döntési szabály, akadályoz a kód megértésében
  - becsapja a programozót (furcsa programozói hibák)
  - nem lehet jó döntést hozni, fordítási hiba

konstruktor túlterhelése

public class Point {
	private int x, y;
	public Point( int x, int y ){
		this.x = x;
		this.y = y;
	}
	public Point(){
		x = 0;   // amugy is 0
		y = 0;
	}
}

public class Point {
	private int x, y;
	public Point( int x, int y ){
		this.x = x;
		this.y = y;
	}
	public Point(){
		this(0,0);
	}
}

a Java-beli operátrorok is túl vannak terhelve
+(int,int) más, mint +(short,short) vagy +(float,float) vagy +(String,String)
vagy +(String,int)

3.14 + 1   kevert aritmetika, tovább bonyolítja a szabályokat
automatikus típuskonverziók (coercion)

a programozó nem terhelheti túl az operátorokat
és nem vezethet be új operátorokat sem


Milyen konstruktorok vannak egy osztélyban?
- a programozó bevezet 1 vagy több konstruktor
- ha nem, akkor default konstruktor

class Point { int x, y; }
jelentése: 
class Point { int x, y; Point(){} }

public class Point { int x, y; }
jelentése: 
public class Point { int x, y; public Point(){} }

a default konstruktor: paraméter nélküli és üres törzsű
paraméter nélküli és üres törzsű konstruktor: nem feltétlenül default

public class Circle {
	private int x, y;
	private double radius;
}

ez így béna, mert radius = 0.0

public class Circle {
	private int x, y;
	private double radius;
	public Circle(){
		radius = 1.0;   // konstruktor
	}
}

public class Circle {
	private int x = 0, y = 0;
	private double radius = 1.0;   // inicialiozalo kifejezes
}

public class Circle {
	private int x, y;
	private double radius;
	{  // inicializalo blokk
		x = 0;
		y = 0;
		radius = 1.0;
	}
}

egyszeru eset: inicializalo kif.
bonyolultabb es/vagy parameterezett logika: konstruktor
keruljuk az inicializalo blokkokat

class Mad {
	static int n;
	static {
		n = 1;
		for( int i=1; i<10; ++i ){
			n *= i;
		}
	}
}

név újtahasználása (újradeklarálás)
- túlterhelés
- formális paraméter elfedi az attribútumot
  this.x = x   minősített névvel férek hozzá az elfedett jelentéshez

másik konvenció

public class Point {
	private int x, y;
	public int x(){ return x; }
	public void x( int x ){ this.x = x; }
	...
}

Point p = new Point();
p.x(10);
p.y(5);
System.out.println( p.x() );

műveletláncolás idiómája

public class Point {
	private int x, y;
	public int x(){ return x; }
	public Point x( int x ){
		this.x = x;
		return this;
	}
	public Point y( int y ){
		this.y = y;
		return this;
	}
	...
}

Point p = new Point().x(10).y(5);

public class Point {
	private int x, y;
	public int getX(){ return x; }
	public Point setX( int x ){
		this.x = x;
		return this;
	}
	public Point setY( int y ){
		this.y = y;
		return this;
	}
	...
}

Point p = new Point().setX(10).setY(5);

///////////////////////

Point[]    -    java.util.ArrayList<Point>
                paraméterezett típus, Point típusparaméterrel
                a java.util.ArrayList generikus típusból
		(Point: aktuális paraméter)

generikus: általános, típussal paraméterezhető
parametrikus polimorfizmus

package java.util;
public class ArrayList<T> {    // T: formális típusparaméter
	public void add( T elem ){ ... }
	public T get(int index){ ... }
	...
}

import java.util.*;
...
ArrayList<Point> ps = new ArrayList<Point>();
Point p = new Point();
ps.add(p);
p = ps.get(0);

///////

LinkedList<T>
T típusú elemek sorozata ez is
láncolt ábrázolás
például hatékonyabb az add(elem,index)


sorozat: ugyanaz többször is, és a sorrend releváns

halmaz: egy objektum csak egyszerwsen szerepel az adatszerkezetben
        a sorrend nem érdekes

standard könyvtár:
java.util.HashSet<T>    hasításon alapszik
java.util.TreeSet<T>    keresőfás ábrázolás

////////////////////

Map: kulcs -> érték leképezés

tömb, ArrayList, LinkedList: int kulcs alapján

java.util.HashMap<K,V>
java.util.TreeMap<K,V>

HashMap<String,Point> hm = new HashMap<String,Point>();
hm.put("pityu",new Point());
Point p = hm.get("pityu");



int[]      ArrayList<int> nincsen

paraméterezett típusok: csak osztállyal paraméterezhetők, primitív típussal nem

primitív típus -> csomagoló osztály (wrapper class)
int -> java.lang.Integer, röviden Integer (nem kell import a java.lang-ra)
...

ArrayList<Integer>  használandó ArrayList<int> helyett


