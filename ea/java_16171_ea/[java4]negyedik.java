class Point {
	int x,y;
}

Point p = new Point();
p.x == 0

attribútum nullaszerű értékkel inicializálva
egész: 0
lebegőp. : 0.0
boolean: false
char: \u0000
referencia: null

void m(){  // forditasi hiba (statikus szemantikai szabaly megsertese)
	Point p;
	System.out.println(p.x);
}

void m(){  // minden ok
	Point p = new Point();
	System.out.println(p.x);
}

void m(){ // futasi hiba: NullPointerException (dinamikus szemantikai szabaly megsertese)
	Point p = null;
	System.out.println(p.x);
}


void m( Point p ){
	System.out.println(p.x);
}

m(new Point())				m(null)

public class Person {
	String name;
	int age;
}

new Person().age == 0
new Person().name == null

// dokumentacios megjegyzes kovetkezik...
/**
	Mutable implementacio.
	Tipusinvarians: age >= 0 & name != null
*/
// a tipusinvarianst a muveletek megorzik
public class Person {
	private String name;
	private int age;
	public Person( String name, int age ){
		// elofeltetel ellenorzese
		if( name == null ) throw new IllegalArgumentException("...");
		if( age < 0 ) throw new IllegalArgumentException("...");
		this.name = name;
		this.age = age;
	}
	public void setAge( int age ){
		if( age < 0 ) throw new IllegalArgumentException("...");
		this.age = age;
	}
	public void setName(){
		if( name == null ) throw new IllegalArgumentException("...");
		this.name = name;
	}
	public int getAge(){ return age; }
	public String getName(){ return name; }
}

Person pityu = new Person("Kis Istvan", 24);
pityu.setName("Kis István");
// imperativ stilus

private void muvelet( int parameter ){
	assert parameter != 0;
	...
}

/**
	Immutable implementacio.
	A Person objektumok belso allapota nem valtozhat meg a letrehozas
	utan.
	Tipusinvarians: age >= 0 & name != null
*/
public class Person {
	private final String name;
	private final int age;
	public Person( String name, int age ){
		// elofeltetel ellenorzese
		if( name == null ) throw new IllegalArgumentException("...");
		if( age < 0 ) throw new IllegalArgumentException("...");
		this.name = name;
		this.age = age;
	}
	public int getAge(){ return age; }
	public String getName(){ return name; }
}

Person pityu = new Person("Kis Istvan", 24);
pityu = new Person("Kis István",pityu.getAge());

// funkcionalis stilus


public class Point {
	private final int x,y;
	public Point( int x, int y ){
		this.x = x;
		this.y = y;
	}
	public int getX(){ return x; }
	public int getY(){ return y; }
}


public class Point {
	private final int[] coords;
	public Point( int x, int y ){
		coords = new int[]{x, y};
	}
	public int getX(){ return coords[0]; }
	public int getY(){ return coords[1]; }
	public int[] coords(){ return coords; }
}

Point p = new Point(1,1);
int[] c = p.coords();
c[0] = 5;
p.getX() == 5

a coords() metódus engedi kiszökni a Point belső állapotát
amin keresztül direkt manipulálható kívülről a belső állapot
sérti az OOP elveket (private)
itt most az immutable designt is tönkreteszi

public class Point {
	private final int[] coords;
	public Point( int x, int y ){
		coords = new int[]{x, y};
	}
	public int getX(){ return coords[0]; }
	public int getY(){ return coords[1]; }
	public int[] coords(){ return new int[]{coords[0],coords[1]}; }
	// masolatot adok vissza, raadasul erdemes mely masolatot csinalni
	// HF: lehet ezen gyengiteni?
}

Point p = new Point(1,3);
Point q = p;

elettartam vege: ha egy referencian keresztul sem erheto el az objektum
garbage collector begyujtheti



tömb: egy objektum, a heapen tárolódik
tömb típus: speciális "osztály", speciális szintaxissal
