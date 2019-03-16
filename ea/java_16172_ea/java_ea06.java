2017.03.23.
6. Java EA

void m(int[] v, int n) {
	v[n++]++;
}
int[] x = {1, 2, 3};
int y = 2;
m(x, y);

a) fordítási hiba, mert m-ben net nem lehet megváltoztatni
b) {1, 2, 3}, 1
c) {1, 3, 3}, 2
d) {1, 3, 3}, 1 // EZ A JÓ
e) {1, 2, 4}, 2

x [] ----> [1][3][3]
y [1]



void m(int[] v, int n) {
	v[ = new inr[]{5, 6, 7};
}
int[] x = {1, 2, 3};
int y = 2;
m(x, y);

n []
v []		[5][6][7]
this []
-------
x [] -----> [1][3][3]
y []

garbage collector: heapből törli a már nem haszált (nem elérhető azon a stacken lévő változókból kiindulva a dereferencing és szelek?új? tranzitív lezártjácal nem érhető el) objetumokat

verem az aktivációs rekordokban
- primitív típusú értékek
- referenciák
heapen
- objektumok, benne
	- primitív típusú mezők // } (példánymezők)
	- referenciák			// }
- osztályok, bennük osztályszintű mezők (static erre utal)	// }
	- primitív típusú										// } technikailag ez is a heapen (?)
	- referencia											// }

automatikus tárolású adat: automatikusan létrejön, amikor belépünk a metódusba, és automatikusan megszűnnek, amikor kilépünk
dinamikus tárolású adat: new-val létrehozzuk, a szemétgyűjtő felszabadítja [heapn objektumok felsorolásra mutató nyíl]
statikus tárolású adat: koncenpcionálisan a teljes programvérgrehajtás az élettartam (statikus), technikailag ált. lista osztálybeli?te?, dinamikus szerkesztés???
koncenpcionálisan külön tárhely


kivétel:
--------
az aktuálisan futó metódus (v. verem tetejln van az aktivációs rekodrja) megszakad, abnormálisan véget ér, és visszatér a vezérlés a hívóba, azaz törlődik a legfelső aktivációs rekord
-> lekezeljük a kivételt és innen kezdbe normlisan  fut tovább - py? (mintha nem is lett vna kivétel)
-> vagy a hibából tovbbterjed a kivétel az őt hívóbaa stb
dobáljuk ki az aktivációs rekordokat, amíg ki nem ürül a vezév. a legutolsó aktivációs rekord a főprogramé (main), ha ez is abnormálisan véget ér -> stack trace

stack trace:
------------
a kivétel terjedése során kidobált aktivációs rekordból információ -> ebből következtethető vissza h hol, hogy lépett fel a kivétel

kivétel lekezelése: try-catch utasítás
-------------------
try {
	// itt fellépő E_i (???) kivétel kezelése [catch metódusokra mutató nyilak]
} catch(E1 e1) {
	// ...
} catch(E2 e2) {
	// ...
}

programnyelv szabályai definiálják a nyelvet
--------------------------------------------
- lexikális: milyen építőkockák vannak a nyelvben
while - kulcsszavak
java.lang.Array? - azonosítók
12.4 - literálok
pl. reguláris kifejezés, 3-as??? nyelvben
- szintaktikai: hogyan lehet összeépíteni az építőkockákat, milyen szerkezetek vannak
környezetfüggetlen nyelvtan while utasítás szintaxisa -> while (<kifejezés>) <utasítás>
pl. (E)BNF
- szemantikai: (legkomolyabb) értelmes-e a felépített struktúra, van-e "jelentése"
[negálás?]környezetfüggő nyelvtan
hatókör, láthatóság, típusosság, szemantikus elemző
-> statikus szemantikus szabályok (javában pl. típusellenőrzés fordítási időben)
-> dinamikus dinamikus szabályok (futási időban ellenőrizzük tömbindex legális-e)
t[54] t[n]
t.length a tömb hossza
0 <= 54 < t.length
ha t == null akk t.length értelmetlen
kivétel: dinamikus szemantikai hiba
ArrayIndexOutOFBoundsException

tömb bejárásához idióma
for (int i = 0; i < t.length; ++i) {
	t[i]...
}
vigyázzunk arra is h az i-t ne változatassuk meg a ciklus magjában

for (int v : t) {
	v...
}
nem ronthatom el az indexelést, enhanced for-logo
- tömb
- ArrayList

verang???: változó hosszú paraméterekkel
int sum(int ... nums) {
	int result = 0;
	for (int n : nums) {
		result += n;
	}
	return result;
}

sum(3, 7)
sum(1, 5, 9)
sum(9, 3, 2, 7, 5, 7, 8)
sum(1)
sum()

float sqrt(float f) {...}
double sqrt(double d) {...}
int sqrt(int n) {...}
3 kül metódus ugyanazzal a névvel, kül pm-listával - kb ugyanazt csinálják
túlterhelés/overloading

class Point {
	void setX(int x) { this.x = x; }
	void setX() { this.x = 0; }
}
Point p = ...;
p.setX(5);
p.setX();
túlterhelés: azonos név, de a formálispm-lista hossza vagy benne lévő típusok különböznek

class Point {
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() { x = y = 0; }
	// VAGY
	Point() { this(0, 0); } // másik konsi meghívása, csak a legelső utasítás lehet
}
túlterhelt konsi
pl. ált konsi több pm-rel és spéci kényelmi funkciójú konsi kevesebb pm-rel

operátortúlterhelés:
a nyelv operátorai is túl vannak terhelve
3 + 1
3.14 + 3.14
"al" + "ma"
"alma" + 5
5 + "alma"
kül +-műveletek, túl vannak terhelve
programozó nem terhelhet túl operátort (csak metódust és konsit)