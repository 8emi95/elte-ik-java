2016.10.12.
5. Java EA

stack:																heap (dinamikus tárhely):
------																-------------------------
- primitív típusú változók											- objektumok, bennük primitív típusú változók
- referencia típusú változók															 referencia típusú változók
(lokális, paraméter) 												//

hatókör: az a blokk, amelben a deklaráció szerepel 					technikai részlet a JVM implementációjával kapcsolatban:
																	statikus mezők is itt vannak, elkülönítve (vájtfülűeknkek)


{
	int i = 1;
	{
		int j = 2;
		int i = 2; // fordítási hiba: van már egy másik lokális i a hatókörben
				   // újradeklaráció meg van tiltva lokális változókra
	}
	// j itt már nem használható
	{
		int j = 2; // másik j, független a hatókörük, nem tudják zavarni egymást, diszjukt az előző j hatókörével
	}
}

class Point {
	int x;
	Point(int x) {
		// a formális x paraméter hatóköre a metódus törzse ({-ekkel határolt rész)
		// itt az x neve formális paraméterre utal
		// elfedi a példányváltozót
		this.x = x; // az attribútumra minősített névvel (this.x) hivatkozhatok
	}
	void setX(int x) {this.x = x;}
}


a lokális változó élettartama a hatókörrel esik egybe				objektum élettartama new-tól kezdődik és
																	addig tart, amíg a garbage collector fel nem számolja az objektumot
																	(szemétgyűjtésig)
																	"dinamikus változók"

"automatikus" váltzók:												gc: ha az objektumot már nem lehet elérni a programból
- automatikusan létrejönnek a blokkba belépéskor					egy alison sem
- automatikusan megszűnnek a blokkból kilépéskor 					pl. stop-the-world gc
- aktivációs rekordban vannak tárolva								pl. mark-and-sweep
																		stack változókból tranzitíven elérhető objektumok megjelölése,
																		majd az összes többi felszabadítása

																		tömbök = objektumok, heapen tárolódnak
																		tömb típusok = majdnem? speciális? osztályok

new int[4]; // heapen lefoglal 4 helyet
int[] t; // referencia egy tömbre, még nem hivatkozik semmire (int t[] - C)
int[] t = new int[4]; // de ráállíthatjuk egy tömb objektumra a referenciát
int n = ...;
int[] v = new int[n]; // futási időben meghatározott érték is lehet a méret
					  // méret lekérdezése

length, mint egy public final attribútum a tömb típusban
t.length

// idióma tömb bejárására
for (int i = 0; i < t.length, ++i) {
	... t[i] ... // vigyázzunk arra h az i-t ne változtassuk meg itt
}

// enhanced for-loop
for (int m: t) {
	... m ...
}

futtatható rendszer ellenőrzi az indexeket
java.lang.ArrayIndexOutOfBoundsException kivételt váltja ki
dinamikus szemantikai hiba


void reverse(int[] src, int[] dst) {
	assert src != null;
	assert dst != null;
	assert src.length == dst.length; // csak akkor lehet lekérdezni a length-et ha nem null
	assert src != dst; // csak így működik jól (ÁBRA)
	for (int i = 0; j = src.length-1; i < src.length; ++i, --j) {
		dst[j] = src[i];
	}
}

int[] t = null; //t.length NullPointerException kivételt vált ki (null egy nem létező tömböt jelent)
int[] t = new int[0]; // length = 0

int[] t = {1, 2, 3, 4, 5};
int[] t = new int[4]{1, 2, 3, 4, 5};


(ÁBRA)
reverse(t,t) // t-t megfordítom
aliasing megzavarhat bennünket, ha a hívott kód nem volt felkészülve rá
programozási hibák


paraméterátadás Javában
primitív típusú paraméterek: érték szerinti paraméterátadás (pass-by-value)
							 az aktuális paraméter értéke bemásolódik a formális paraméternek megfelelő lokális változóba a hívott metódus aktivációs rekordjában
referencia típusú paraméterek: a referencia értéke másolódik, azaz
							   alias jön létre az aktuális paraméterre
							   (hasonlít más nyelvekben a cím szerinti átadáshoz, pass-by-reference)
							   a hívó s a hívott osztozik az objektumon, ami át lett adva
							   megosztás szerinti paraméterátadás (pass-by-sharing)

referenciák tömbje

Point[] ps = new Point[3]; // 3 null referenciát tartalmaz a tömb

Point[] ps = new Point[3];
ps[0] = new Point(1,1);
ps[1] = new Point(1,1);
ps[2] = new Point(1,1);

Point[] ps = {new Point(1,1), new Point(1,1), new Point(1,1)}; // rövidebben

Point[] ps = new Point[3]; // another way
ps[0] = new Point(1,1);
ps[1] = ps[0]; // aliasing
ps[2] = ps[0];

mutable Point esetlb nem ugyanaz!!!
immutable esetben sem, de ott nem zavaró

int[][] matrix = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}} // int tömb elemű tömb
// tömbök tömbje (jagged array)
// hasonlóan használható, mint más nyelvekben a többdimenziós tömb (Javában nincs többdimenziós tömb)

a tömbök mérete ficx, létrehozáskor megadandó, utána nem változtatható

int[] t = new int[4]; // ...
ha szeretném 5-re növelni a méretét
t = new int[5]; // nullákkal feltöltött
új, nagyobb tömb allokálható
adatmozgatás, költségek!
aliasing problémát okozhat

int[] t = new int[4];
int[] tmp = t;
t = new int[5];
t[0] = tmp[0]; // csak a t referenciát módosítja

másik adatsorozat-típus:
java.util.ArrayList

indexelés helyett (ArrayList műveletei)
.get(int)
.set(int, value)
.add(value) // hozzáad, méret változha
.add(int, value) // beszúr vhová

import java.util.ArrayList;
ArrayList<Point> ps;
ArrayList<Point> ps = new ArrayList<Point>();