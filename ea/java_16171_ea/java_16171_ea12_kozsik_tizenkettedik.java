package java.lang;
public class Object {
	protected Object clone() throws CloneNotSupportedException {
		if( this instanceof Cloneable ){
			return // do magic: sekély másolat
		} else throw new Clone...
	}
	public boolean equals( Object that ){   // nem olyan, mint clone
		return this == that;
	}
	public int hashCode(){ ... }
	// eyt használja a HashMap, a HashSet...
}

lekérdezi a this dinamikus típusát
létrehoz ennek a típusnak megfelelő tárhellyel rendelkező új objektumot
átmásolja a this által hivatkozott objektumból az adatokat

sekély másolás - shallow copy

mély másolás: 

// régi implementáció (technikailag módosított törzs), újradeklarálva
class Point implements Cloneable {
	int x, y;
	@Override public Point clone(){
		try { return (Point)super.clone(); }
		catch( CloneN... e ){
			assert false;
			retrun null;
		}
	}
	
	@Override public boolean equals( Object that ){   // sekély/mély
		if( that instanceof Point ){
			// that dinam. típusa a Point altípusa
			// különböző osztályú obj.-ok is lehetnek egyenlők
			// ArrayList és LinkedList cool
			// máskor esetleg nem kívánatos
			Point p = (Point) that;
			return p.x == x && p.y == y;
		} else return false;
	}
	@Override public boolean equals( Object that ){   // sekély/mély
		if( that != null && that.getClass().equals(getClass()) ){
			// azonos osztályba tartozó obj-ok lehetnek egyenlők
			Point p = (Point) that;
			return p.x == x && p.y == y;
		} else return false;
	}
	@Override public int hashCode(){
		return x + y;  // konzisztens az equals-zal
	}
}

final Class Object.getClass()  dinamikus típus lekérdezése

final class java.lang.Class: egyedei reprezentálják a típusokat a JVM-ben
java.lang.String ábrázolása String.class objektummal, típusa Class
vájtfülűeknek: Class<String>, mert a Class egy generikus osztály

felüldefiniálásnál a paraméterek típusa nem változhat!
paraméter típusa változik => túlterhelés (overloading)

felüldef: dinamikus kötés (futási időben...,)
túlterh.: statikus kötés (fordítási időben választjuk ki az implementációt)

@Override annotáció: fordítási hiba, ha nem felüldefiniálás
(hanem pl. túlterhelés)

altípuson túlterhelés:
- technikailag megoldható
- kerülendő (ökölszabály)

class C {
	void m( Number n ){ ... }
	void m( Integer n ){ ... }
	// legális túlterhelés, bár Integer a Number altípusa
}

class Point implements Cloneable, Compararable<Point> {
	int[] coords = new int[2];
	@Override public Point clone(){
		try {
			// ez nem jó: Point cloned = new Point();
			Point cloned = (Point)super.clone(); }
			cloned.coords = new int[2];
			cloned.coords[0] = this.coords[0];
			...
			return cloned;
		catch( CloneN... e ){
			assert false;
			return null;
		}
	}
	
	@Override public boolean equals( Object that ){   // mély
		// this.coords és a that.coords tartalmilag egyenlő?
		if( that != null && that.getClass().equals(getClass()) ){
			Point p = (Point) that;
			return p.coords.length == coords.length
			    && p.coords[0] == coords[0]
			    && ...
		} else return false;
	}
	// lehetne sekélyt is, de ide az nem lenne megfelelő
	@Override public int compareTo( Point that ){
		return (that.x - x) * (y - that.y);
		// konzisztensd az equals-zal 
	}
	@Override public int compareTo( Point that ){
		return origótol vett távolság alapján -> nem konzisztens
		az equals-zal
	}
}

equals jelentése:

if( this osztálya A ){
	A-beli equals implementáció...
} else if( ...

helyette dinamikus kötés

tehát csak "egy" equals metódus van
(az equals metódusok felüldefiniált definícióinak "uniója")
ez legyen ekvivalenciareláció
reflexivitás általában könnyű
szimmetria és tranzitivitás nem triviális, főleg, ha különböző
osztályba tartozó objektumok is lehetnek egyenlők (ld. pl. insdtanceof)

- getClass  -> RST ok, de a Liskov helyettesítési elvet sérti picit
- instanceof + final class  -> RST ok, sérül a kiterjeszthetőség
- instanceof + final equals -> RST ok, de nem "igazi egyenlőségvizsgálat"
- öröklődés helyett kompozíció -> RST lehet ok, de az OOP sérül


immutable
sosem kell másolnom
(másolás: egymástól függetlenül módosítható objektumok)

String

new Point(1,1) == new Point(1,1)
false

new Point(1,1).equals( new Point(1,1) )
lehet true

referenciáknál egyenlőség (és nem azonosság!) vizsgálata: equals

"pityu" == "pityu"   jellemzően true
String p = "pityu";
String q = "pityu";  // p

new String("pityu") == new String("pityu")   jellemzően false

jobb az equals!!!

new Integer(3) == new Integer(3)    jellemzően true

new Integer(1113) == new Integer(1113)    jellemzően false

hashCode mindig szinkronban az equals metódussal!

ha a.equals(b), akkor a.hashCode() == b.hashCode()
ha !a.equals(b), akkor jó, ha minél több ilyen esetben a hashCode is eltér


package java.lang;
public interface Comparable<T> {
	int compareTo( T that );   // three-way comparison
}

parciális rendezés (antiszimmetria, tranzitivitás)

a compareTO metódus paramétere lehet a saját osztály, pl. Point
class Point implements Comparable<Point> ...
class Point3D extends Point implements Comparable<Point3D> ... NEM MEGY

