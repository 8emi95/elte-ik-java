stack						heap = dinamikus tárhely

primitív típusú változók			objektumok, bennük
referencia típusú változók			  primitív típusú változók   
(lokális, paraméter)                              referencia típusú változók

hatókör: az a blokk, amelyben			technikai részlet a JVM 
a deklaráció szerepel 				implementációjáról:
						   statikus mezők is itt,
						   elkülönítve (vájtfülűeknek)
// egymásba ágyazott blokk utasítások
{
   int i = 1;
   {
      int j = 2;
      int i = 2;  // forditasi hiba, van mar egy masik lokalis i hatokorben
                  // ujradeklaracio meg van tiltva lokalios valtozokra
   }
   // itt j mar nem hasznalhato
   {
      int j = 2;
      // ez egy masik j, aminek diszjunkt
      // a hatokore az elozo hatokorevel

   }
}

class Point {
	int x;
	Point( int x ){
		// a formalis x hatokore a metodus torzse
		// itt az x nev a formalis parameterre utal
		// elfedi a peldanyvaltozot
		this.x = x;
		// az attributumra minositett nevvel hivatkozhatok
	} 
	void setX( int x ){ this.x = x; }
}


lokális változó élettartama				objektum élettartama
a hatókörrel esek egybe					new-val kezdődik, és
							szemétgyűjtésig tart
"automatikus" változók,					"dinamikus változók"
automatikusan létrejönnek a blokkba belépéskor
automatikusan megszűnnek a blokkból kilépéskor		gc: garbage collector
aktivációs rekordban vannak tárolva			ha az objektumot már
							nem lehet elérni a
							programból
							egy aliason sem

							pl. stop-the-world gc
							concurrent gc

							pl. mark-and-sweep
					stack változókból tranzitíven elérhető
					objektumok megjelölése, majd a jelöletlen
					objektumok felszabadítása


tömbök - objektumok, heapen tárolódnak
tömb típusok - majdnem? speciális? osztályok

new int[4]

int[] t   referencia		int t[]

int[] t = new int[4];

int n = ...
int[] v = new int[n];
futási időben meghatározott érték is lehet a méret

méret lekérdezése

length , mint egy public final attribútum a tömb típusban

t.length

// idioma tomb bejarasara
for( int i = 0; i < t.length; ++i ){
	... t[i] ...
	// vigyazunk arra, hogy az i-t ne valtoztassuk meg itt
}

// enhanced for-loop

for( int m: t ){
	... m ...
}

futtató rendszer ellenőrzi az indexeket
java.lang.ArrayIndexOutOfBoundsException kivételt vált ki
dinamikus szemantikai hiba


void reverse( int[] src, int[] dst ){
	assert src != null;
	assert dst != null;
	assert src.length == dst.length;
	assert src != dst;	// ezt is kossuk ki, hogy jol mukodjon
	for( int i=0, j=src.length-1; i<src.length; ++i, --j ){
		dst[j] = src[i];
	}
}

int[] t = null;
... t.length ... kivételt vált ki

int[] t = new int[0];

int[] t = {1,2,3,4,5};
int[] t = new int[5]{1,2,3,4,5};

reverse(t,t)
aliasing megzavarhat bennunket, ha a hivott kod nem volt felkeszulve ra
programozasi hibak

paraméterátadás Javában
primitív típusú paraméterek: érték szerinti paraméterátadás (pass-by-value)
	az aktuális paraméter értéke bemásolódik a formális paraméternek
	megfelelő lokális változóba a hívott metódus aktivációs rekordjában
referencia típusú paraméterek: a referencia értéke másolódik, azaz alias
	jön létre az aktuális paraméterre
	(hasonlít más nyelvekben a cím szerinti átadáshoz, pass-by-reference)
	a hívó és a hívott osztozik az objektumon, ami át lett adva
	megosztás szerinti paraméterátadás (pass-by-sharing)


referenciák tömbje

Point[] ps = new Point[3];
harom null referenciat tartalmaz a tomb

Point[] ps = new Point[3];
ps[0] = new Point(1,1);
ps[1] = new Point(1,1);
ps[2] = new Point(1,1);

Point[] ps = {new Point(1,1),new Point(1,1),new Point(1,1)};

Point[] ps = new Point[3];
ps[0] = new Point(1,1);
ps[1] = ps[0];    // aliasing
ps[2] = ps[0];

mutable Point esetén nem ugyanaz!!!!
immutable esetben sem, de ott nem zavaró

int[][] matrix ={ {1,0,0}, {0,1,0}, {0,0,1} };

tömbök tömbje (jagged array)
picit olyasmi, hasonlóan használható, mint más nyelvekben a többdimenziós tömb

a tömbök mérete fix, létrehozáskor megadandó, utána nem változtatható

int[] t = new int[4];
...

ha szeretném 5-re növelni a méretét:
t = new int[5];  // nullakkal feltoltott

új, nagyobb tömb allokálható
adatmozgatás, költségek!
aliasing problémát okozhat

int[] t = new int[4];
int[] tmp = t;
t = new int[5];
t[0] = tmp[0]; ...


másik adatsorozat típus:

java.util.ArrayList

indexelés helyett
.get(int)
.set(int, value)
.add(value)          // méret változhat
.add(int,value)

import java.util.ArrayList;

ArrayList<Point> ps;

ArrayList<Point> ps = new ArrayList<Point>();


