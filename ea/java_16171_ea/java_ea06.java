2016.10.19.
6. Java EA

-------------------------------------------------------------
overloading/túlterhelés:
-------------------------------------------------------------

egy osztályban több műveletet ugyanazzal a névvel, de különöpző paraméterezéssel:
- különböző számú formális paraméter
	pl. ArrayList:
		void add(elem)
		void add(elem, index)
- különböző deklarált/statikus típusú paraméterek (működik int és String pm-rel is)
	fordító ki tudja választani fordítási időben h melyiket hívjuk
	amíg nem használjuk rosszul, addig segíti a programozót
	egyfajta polimorfizmus/többalakúság: tudunk olyan kódot írni ami többféle típussal is működik
	ügyetlen használat: - bonyolult döntési szabály
						- akadályoz a kód megértésében
						- becsapja a programozót (furcsa programozói hibák)
						- nem lehet jó döntést hozni (fordítási hiba)
	pl. System.out.println(int)
		System.out.println(String)

konstruktorokat is túl lehet terhelni (nem csak metódusokat):
pl.
public class Point {
	private int x, y;
	public Point(int x, y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		x = 0; // amúgy is 0 (minden mező auto inicializálásra kerül)
		y = 0;
	}
}
// javított: általános esetre visszavezetem a speciális esetet (konsruktorból konstruktort hívok meg)
public class Point {
	private int x, y;
	public Point(int x, y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0, 0);
	}
}

operátorok túlterhelése:
- sok nyelven eleve túlterhelten vannak definiálva
	+ minden számtípusra másképp működik // (más processzorművelet 2 int és 2 short összeadásánál)
	+(int, int) más mint +(short, short) vagy +(String, String) vagy +(String,int)
- kevert aritmetika bonyolulttá teszi a szbályokat
	automatikus típuskonvertzió (coercion):
	3.14 + 1	-> 1 egészből lebegőpontos (1.0)
- a programozó nem terheti túl az operátorokat
- nem vezethet be új operátorokat sem


----------------------------------------------------
Milyen konstruktorok vannak egy osztályban?
----------------------------------------------------

- a programozó bevezet 1 vagy több konsit (felsorolja) -> pontosan ezek a konsik lesznek
- ha nem akk default (paraméter nélküli, üres törzsű) konstruktor jön létre
	class Point { int x, y; }
	jelentése:
	class Point { int x, y; Point(){} }
	// publikus osztály definiálásánál (default konsi láthatósága = osztály láthatósága)
	public class Point { int x, y; }
	jelentése:
	public class Point { int x, y; public Point(){} }

default konstruktor: paraméter nélküli = konstruktorral explicit módon nem rendelkező osztály
					 üres törzsű
					 nem írtuk meg!
					 létezhet pm nélüki öres törzsű konsi, ami nem default!

public class Circle {
	private int x, y;
	private double radius; // 0-ra inicializálódik alapból, aminek nincs értelme
}

public class Circle {
	private int x, y;
	private double radius;
	public Circle() {
		radius = 1.0;
	} // (inicializáló) konstruktor
}

public class Circle {
	private int x = 0, y = 0; // explicit 0-ra definiálom
	private double radius = 1.0;
	// inicializáló kifejezések
}

public class Circle {
	private int x, y;
	private double radius;
	{ // inicializáló blokk (lokális-, segédváltozókat is bevezethet; ha bonyolultabb számítás kell akk jó)
		x = 0;
		y = 0;
		radius = 1.0;
	}
}

egyszerű eset: inicializáló kifejezések
bonyolultabb és/vagy őaraméterezett logika: konstruktor
kerüljük: inicializáló blokk

class Mad {
	static int n;
	static { // statikus inicializátor blokk
		n = 1;
		for (int i = 1; i < 10; ++ i) {
			n *= i; // 10!-sal töltjük fel
		}
	}
}


név újrahasználása (újradeklarálás):
------------------------------------
- túlterhelés
- formális pm elfedi az attribútumot
	this.x = x // minősített névvel férek hozzá az elfedett jelentéshez

másik konvenció
public clas Point {
	private int x, y;
	public int x() { return x; }
	public void x(int x) { this.x = x; }
	// ...
}
Point p = new Point();
p.x(10);
p.y(5);
System.out.println(p.x());

műveletláncolás idiómája
public clas Point {
	private int x, y;
	public int x() { return x; }
	public Point x(int x) {
		this.x = x;
		return this;
	}
	public Point y(int y) {
		this.y = y;
		return this;
	}
}
Point p = new Point().x(10).y(5);

public clas Point {
	private int x, y;
	public int getX() { return x; }
	public Point setX(int x) {
		this.x = x;
		return this;
	}
	public Point setY(int y) {
		this.y = y;
		return this;
	}
}
Point p = new Point().setX(10).setY(5);


Point[] helyett java.util.ArrayList<Point>
				paraméterezett típus, Point típusparaméterrel
				java.util.ArrayList generikus típusból
				Point: aktuális paraméter
generikus: általános, típussal paraméterezhető
parametrikus polimorfizmus

// vhogy így van definiálva az ArrayList osztály
package java.util;
public class ArrayList<T> { // T: formális típusparaméter
	// jelezte h generikus osztálydefiníció, <>-rel jelezzük
	public void add(T elem) { ... }
	Public T get(int index) { ... }
}

import java.util.*; // * helyett ArrayList
...
ArrayList<Point# ps = new ArrayList<Point>();
Point p = new Point();
ps.add(0);
p = ps.get(0);



generikus típus még: (ArrayList is)
LinkedList<T>
T típusú elemek sorozata ez is
láncolt ábrázolás
pl hatékonyabb az add(elem, index)

(ˇadatszerkezet)
halmaz: egy objektum csak 1x lehet benne
		sorrend nem érdekes

sorozat: uaz az elem többször is
		 sorrend számít

standard könyvtár:
java.util.HashSet<T>	hasító adatszerkezet (hasításon alapszik)
java.util.TreeSet<T>	keresőfás ábrázolás
többtípusú... egy ...ben

Map: kulcs -> érték lekérdezés (kulcshoz értéket rendel hozzá)
(5-ös kulcshoz tartozó érték az 5-ös index tömbben)

tömb, ArrayList, LinkedList: int kulcs alapján működő leképzések

java.util.HashMap<K,V> (2 típuspm-t adok át, milyen kulcsok és milyen értékek)
java.util.TreeMap<K,V>

HashMap<String,Point> hm = new HashMap<String,Point>();
hm.put("pityu", new Point());
Point p = hm.get("pityu");



int[]
ArrayList<int> nincs -> geneikus típusok csak objektumtípusokkal paraméterezhetők
paraméterezett típusok: csak osztállyal paraméterezhetők, primitív típussal nem

csomagoló osztály / wrapper class: minden primitív típushoz tartozik
int -> java.lang.Integer, röviden Integer (nem kell import a java.lang-ra)
ArrayList<Integer> használandó ArrayList<int> helyett