2017.02.23.
2. Java EA

public osztály }
	   metódus } bárhonna hivatkozható
	   mező    }
	   ...     }

public NAH						osztály	}
félnyilvános (package private)	metódus	} csak a definíciót tartalmazó csomagban
								mező	}
								...		}

package misc;
public class Date {
	private int year;
	// ...
	package int setYear() {...}
	// ...
	int hel???(...) {...}
} // misc csomagban van, más csomagból is használható

class Date {
	private int year;
	// ...
} // névtelen csimagba kerül, csak ebben a csomagban használható

osztály teljes neve: a csomagnévvel minősített név
osztály rövid neve: a deklarációban szereplő név, a csomagnév nélkül

csomagok rendszere hierarchikus, alcsomagok használatók
server.data.types csomagnév
server.data.types.Employee

fejlesztők globálisan egyedk névtereket próbálnak használni, ehhez "mélyen hierarchikus" csomagnevek
hu.elte.kto.analyzer.server...
hu.elte.kto -> fejlesztő (cég, termék) azonosítása
kül forrásból származó kódok összeépítésénél nem lesznek névkonfliktusok

csoamag nem csak névtér, azaz a program logikai tájolása, hanem a forráskód fizikai szervezésének is alapja
prg					kód a fájlrendszerben
---					---------------------
csomag				könyvtár
alcsomag			alkönyvtár
...					
fordítási egység	forrásfájl

fordítási egység
----------------
- opcionális: package utasítás
- 0, 1 v. több improt utasítás
import java.util.List;
- egy (esetleg több) típusdefiníció (pl osztálydefiníció)
legfeljebb egy publikus (többi félnyilvános segédosztály, - típus), ennek neve = forrásfájl neve
- általában 1 típus 1 fájlban
- érdemes mindig egyszer??? on ~ fh.

java csomag és alcsomagjai szabványos programkönyvtár egy része

dolgoznak egy projekten, egy munkakönyvtár (working directory)
C:\Users\kto\nalyzer
/home/kto/analyzer
ezen belül a csomaghierarchiát tükrözi a könyvtárhierarchia
a negfelelő alkönyvtárba tesszük a forrsáfjálokat és bájtkódokat

WD
- server
	- data
		- types
			- Employee.java
			- Employee.class
- client
	- web
	- gui

C:\Users\kto\analyzer> dir     ~kto/analyzer $
server
client
C:\Users\kto\analyzer> javac server\data\types\Employee.java // javac "teljes elérési út" VAN kiterjesztés
C:\Users\kto\analyzer> java server\data\types\Employee // java "osztály neve" NINCS kiterjesztés
nem cd-zünk beljebb!


belső állapot ~ típusinvariáns
műveletek ~ megőrzik, konzisztens állapotból konzisztens állapotba
konstrukció ~ alőállítja (konzisztens állapotot)
pl. konstruktorban -> metódusnév?

package misc; // misc.Date
public class Date {
	private int year;
	// ...
	public void setYear(int y) {
		if (month == 2 && day == 29 && !isLeapYear(y)) {
			throw new IllegalArgumentException();
		}
		year = y;
	}
}

public class Date {
	public Date(int y, int m, int d) {
		// ellenőrzések, throw new Illegal...
		year = y;
		month = m;
		day = d;
	}
	private int year, month, day;
}

new Date(2017, 2, 23); // konstruktor hívása


public class Date {
	// nincs konsi
}

new Date();
   v 			// fordító
public class Date {
	public Date() {}
	// ...
}
a generált konsit nevezik "default konstruktornak"
minden osztályban van konsi
- explicit (mi írtuk)
pm élküli v pm-es (igény szerint)
- implicit: default
pm nélküli
létrehozás: mint pl metódusoknál


					konsi 			vs.			metódus
szintaktika		nincs return type			van return type (void, int, ...)
használat 		csak new-val				egy már létrehzott objektumon hívható meg

class Date {
	private int year = 2000;
	private int month = 1;
	private int day = 1;
	// nem írok konsit
	// konsi felül tudja írni ezeket az étékeket
}

a new Date() során lefut a default konsi és "közben" beállítódnak a mezők az inicializáló kifejezésben megadott értékre, vagy ha nincs ilyen akk nullaszerű értékre
0, 00, '\n000', false, referenciáknál null

class dfgdfg??? {
	// ???
}
private int year = 0, month = 0, day = 0;


class Date {
	private int year, month, day;
	{year = 2022;}
	// nem metódus, nem konsi, hanem inicializátor blokk (ált ne mhasználjuk)
}



metódus:
--------
- specifikációs rész (láthatóság, return type, náv, formális pm, stb)
- törzs {...}
	utasítássorozat
	- változódeklaráció
	- értékadás
	- ciklus :	- while (elöltesztelős)
				- do-while (hátultesztelős)
				- for (léptető)
				- inhanced for (adatszerkezetet bejáró)
	- elágazás:	- if
				- switch
	- assert
	- return int
	- throw (kivétel kiváltása)
	- break, continue (nem strukturált prog) -> ritkán, jó okkal

if ( x > 0)
	--x;

if ( x > 0) {
	--x;
} // uaz, de ez preferált, plusz fáradság, kevesebb hiba


if (x > 0)
	--x;
	++y; // tördelés és jelentés különbözik
=>
if (x > 0)
	--x;
++y;
=>
if (x > 0) {
	--x;
}
++y;
!=>
if (x > 0) {
	--x;
	++y;
}


if (x > 0) {
	--x;
} else {
	if (x < 0) {
		++x;
	}
}

if (x > 0) {
	--x;
} else if (x < 0) {
		++x;
	}
}

if-then-else probléma (chellenyi? elve?/else?)
if (x > 0)
	if (y > 0)
		x += y;
else
	x = 0;
=>
if (x > 0)
	if (y > 0)
		x += y;
	else
		x = 0;
// tördelés és a jelentés nincs összehangban -> programozói hiba