2017.03.30.
7. Java EA

public class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this(0, 0);
	}
	public int getX() {			// }
		return x;				// }
	}							// } getter/setter k???
	public void setX(int x) {	// }
		this.x = x;				// }
	}							// }

	// egy másik konvenció
	public int x() {
		return x;
	}
	public void x(int x) {
		this.x = x;		// x(3) rekurzív hívás
	}					// x() lekérdezés?
}						// this.x ???
						// x paraméter

metódusnevek és változónevek egybeeshetnek, a zárójel (aktuálisparaméter-lista) megkülönbözteti őket egymástól

Point p = new Point(1, 7);
p.setX(5);
p.setY(3);
p.getX();

Point p = new Pint(1, 7);
p.x(5);
p.x();

// ...Point...
public Point setX(int x) {
	this.x = x;
	return this;
}

p.setX(5); setY(3);
	ˇ
Point referencia = (ekviv) p


java.lang.Strig;
"alma"
immutable:
műveletek: lekérdezések, új stringeket konstruálunk, nem módosítják az objektumot

str.replace(5, 'c')
nem (str -> [5?])

úgy értelmes h:
String str2 = str.replace(5, 'c');
str -> []
	   [c]

int[] t = ...;
String str = "";
for (int i : t) {
	str += i;	// str = str + i
}				// az i-t Stringgé alakítja é a két stringet összefűzi

str -/-> ""
	-/-> "3", "7"
	-/-> "37", "0"
	---> "570"
a + ereménye kuka!


java.lang.StringBuilder; // java.lang.StringBuffer konkurens is
mutable karaktersorozatok
karaktersorozat objektum megváltoztatását célző műveletek (?)
(erre kialakított belső reprezentáció, más mint a Stringgé)
int[] t = ...
StringBuilder sb = new StringBuilder();
for (int i : t) {
	sb.append(i);
}
String str = sb.toString();
kevesebb temporális objektum, hatékonyabb kód

sb.append(i). append(j).append(k); // mert class StringBuilder
public StringBuilder append(int i) {
	//...
	return this;
} // múveletté a??ás idiómája

"hello" ..... "hello"
reprezentáció megosztható két független előfordulás között
gazdaságos: nem kell kétszer (többször) eltárolni ugyanazt az értéket

jelentésmegőrző átalakítás inmutable esetben

viszont az általa hivatkozott objektum módosítható (ha mutable)

final + inmutable ~ konstans
változó csak egyszer kap értéket		adat nem változhat
primitív típus: a kettő ugyanaz
reereknciák esetén
final referencia... // éééés letörölte 2 perc után

int i = 5;
int j = 5; // i == j igaz
Point p = new Point();
Point q = new Point(); // p == q igaz
Point r = q; // alias, r == q igaz

"hello" == "hello" // lehet h egyenlő (valszeg igen)
String s = "hello"; // referenciák, mégis s == z lehet igaz, s == h kisebb eséllyel lehet igaz
String z = "hello";
String h = z + "";
String t = new String("hello"); // s == t valszeg nem igaz
nincs értelme Stringeket ==-vel összehasonlítani
s.equals(z) értelmes megoldás, a karaktersorozatok megegyeznek-e


java.lang.Integer
		 .Long
		 .Byte
		 .Short
		 .Boolean
		 .Float
		 .Double
		 .Cahracter
// a primitív típusok csomagoló (wrapper) osztályok

Point[] ~ ArrayList<Point>
int[]     ArrayList<int> nincs, típusparaméterben nem lehet primitív típus csak referencia típus
Integer[] ~ ArrayList<Integer>
technikailag nem felelnek meg egymásnak, de hsználatban igen

Integer n = new Integer(5); // i[] -> [5]
int j = 3; // j[3]
class Integer {
	private final int val;
	public Integer(int val) { this.val = val; }
	public int intValue() { return this.val; }
	public static final int MAX_VALUE = (2^31)-1; // elnevezási konvenció
}

Integer i = new Integer(3); // int -> Integer
int j = i.intValue(); // Integer -> int
i = new Integer(j); // int -> Integer
auto-(un)boxing
auto-boxing: automatikus int -> Integer		// } compiler végzi
auto-unboxing: automatikus Integer -> int	// } jobboldalit i?hatjuk, de baloldali készül belőle

Integer i = 2; // autoboxing
int j = i; // autounboxing
"szintaktikus fűszer" (syntactic sugar)

Integer a = 5;
Integer b = 9;
Integer c = a + b;
a[] -> [5]
b[] -> [9]
c[] -> [14]
sokkal komplikáltabb és lassabb a dinamikus memóriakezelés miatt, a dereferencing és szelekció miatt

int a = 5;
int b = 9;
int c = a + b;
a[5] b[9] c[14]
számoláshoz ezt használjuk


ArrayList<Integer> v = ...;
v.add(12);
// a fordító ezt csinálja belőle: v.add(new Integer(12));
int i = v.get(0);
// a fordító ezt csinálja belőle: int i = i.get(x).intValue();
// int <- i.get(x)
// Integer <- i.get(x).intValue()


Integer i = 5;
Integer j = 5; // i == j
Integer u = -2923;
Integer v = -2923; // u != v
nem szerencsés (nem értelmes) ==-vel hasonlítgatni
u.equals(v) igaz // } ezt kell használni
i.equals(j) igaz // }

int i = 5;
i.equals(5);
első ránézésre értelmetlen
metódusa objektumoknak van, nem primitív típusú értékeknek
de: auto-boxing, new Integer(i).equals(new Integer(5))
sokkal kevése hatékony, mitn i == 5
ne éljünk vissz az auto-(un)boxinggal