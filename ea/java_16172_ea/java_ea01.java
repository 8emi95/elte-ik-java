2017.02.16.
1. Java EA

- imperatív: változók értékadása
- objektum-orientált: ???

forráskód felépítése:
---------------------
csomag (package)
osztály, ???, típusdefiníció - osztály (absztrakt, konkrét)
							 - interfész
							 - felsorolási típus???
							 - annotáció típus???
tagok - mező (adattag)
	  - metódus (művelet) ??
	  - tagosztály
konstruktor, inicializáló blokkok (HF...)

utasítások: (<- konsi, metódus)
- értékadás
- elágazás (if, switch case)
- ciklus (while, do-while, for)
- blokk utasítás
- kivételkezelés
- nem strukturált utasítások: break, continue


forrásfájl.java ----------------------- fordítási egység ------------------> több fordítási egységből áll
	ˇfordítás [javac]						ˇ 									a forráskódja a programnak
bájtkód.class							egyből több class,
	ˇfuttatás [java]			egymástül függetlenül fordíthatók
Java Virtual Machine értelmezi


class Date {
	int year; // változódeklaráció
	int month;
	int day;
	void nextDay() {
		if (day < 2x) {
			day++;
		} // elágazás
	}
}

<osztálydefiníció> := class <azonosító> <törzs>
osztálynév: camel-case, nagybetűvel kezdődik
<törzs> := "{" (tag | konsi | ...)* "}"
<tag> := <mező> | <metódus> |<osztálydefiníció>
<metódus> := <típus> <azonosító> "(" (formális paraméter)* ")" <metódustörzs>
metódusnév: camel-case, kisbetűvel kezdődik

class
...
Date date; // referencia
date = new Date(); // a ref. által hivatkozott obj ...
date.year = 2017; // Date osztályból jött létre
date.nextDay();


típusok:
--------
- primitív:
	- logikai: boolean (T/F)
	- egész: kettes komplemens ábrázolás (1 bit előjelbit, többi helyiérték)
		- byte (8 bit) -128..+127
		- short (16 bit)
		- int (32 bit)
		- long (64 bit) -2^63..(2^63)-1
	- lebegőpontos:
		- float (32 bit)
		- double (64 bit)
	- karakter: char (16 bit) Unicode
- referencia: típusdefinícióval megadott (pl. Date)
tömb típus
int[]
new -> dinamikus tárhelyen allokál (heap)

...

class TestDate {			// parancssori argumentumok
	public static void main(String[] args) {
		Date date;
		date = new Date();
		date.year = 2017;
		date.nextDay();
	}
}


adatabsztrakció = egységve zárás (enkapszuláció) + információ elrejtés
információ elrejtés: típus in???ét és belső megvalósítását elválasztjuk (láthatósági szavakkal)
	exportált, kívülről látható 	"kívülről érdektelen részleteket" elrejtjük
										-> absztrakció (el???hoztatás) alapja

láthatósági szavak:
- public: nyilvános
- protected: package + öröklődésd
- package private: félnyilvános
- private: rejtett

adatabsztrakció: a processzorban használt adatok konzisztens(?) ???jának megőrzése
típusinvariáns: logikai állítás, amely karakterizációja az objektum legális belső álláspontjait
					- ???
					- ???

class Date {
	private int year;
	private int month;
	private int day;

	public void nextDay() {...}
	public void setMonth() { return month; }
	public void setMonth(int month) {
		if (day < 29 || ...) {
			month = nextMonth;
		} else {
			throw new IllegalArgumentException();
		}
	}
}

pl mezők private, műveletek egy része public, ha a típusuinvariánsra vigyáznak
ökölszabály

szűk interfész
kevés interakció a típusok között
$
kisebb komplexitás
könnyebb a karbantartás
olcsóbb a szoftver előállítása