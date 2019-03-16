2016.09.14.
1. Java EA

kto.web.elte.hu
12:15-
ézh: mindegyik kb 100 fõs, utolsó pót-pót

*******************************************

objektumorientált nyelv (osztály, objektum)
programnyelv: ne gépi kódban kelljen programozni, könnyebb így, más programozók megértsék

cél: humán - számítógép }	kommunikáció
	 humán - humán		}

OOP



------------------------------
Java:
------------------------------

- imperatív: utasításokból építjük fel (funkcprog is megjelenik)
- osztályalapú: osztálydefiníciók elemi egységei a programnak
- objektumelvű: compiler típushibákat jelez
- statikusan típusozott:

2 programnyelv igazából:
"Java" = Java + JVM (Java Virtual Machine)
java virtuális gép (JVM) tartozik hozzá, Java nyelven írjuk, közös nyelvre lefordítja (JVM nyelvére), interpreter...


									program végrehajtása:
kód -> gépi kód -> gép				- fordítás + végrehajtás	}		=> Java ezek kombinációja
kód -> interpreter					- interpretálás				}

						fordítás						interpretálás
java forráskód ------------------------> bájtkód ---------------------> JVM-ben futtajuk; nem gépi kódot készítünk, de néha csinál
source code				javac			(JVM kód)						java 						JIT (just-in-time) compilation
programszöveg			(compiler)		.class fájlok					osztálybetöltő:				gépi kód futás közben
.java forrásfájlok														megkeresi az osztályokat
																		dinamikus szerkesztés

	  //név
class Hello {		 //név  //paraméterek (itt 1 db)             osztálydefiníció
	public static void main(String[] args) { //metódusdefiníció: - paraméterlista
		System.out.println("Hello!");		 //					 - utasítás (törzsben)
	} //System.out = szabványos kimenetre printel egy stringet
}	  //println = bekezdés a végére

kifejezés -> utasítás -> metódus -> osztály

névtelen csomagban osztálydefiníció, osztálynév = rövid név
fordítás: javac fájlnév					^
		  pl. javac Hello.java	  -> Hello.class	//.java kiterjesztés!
		  case-sensitive névegyezés
futtatás: java osztálynév //.class NEM kell
		  pl. java Hello


??? interpretálás lassabb, fordítás ..., futtatás ...
OOP több memóriát használ



------------------------------
Fordító/Compiler:
------------------------------

programszöveg értelmes?
ha nem  -> fordítási hibák
ha igen -> kódgenerálás (gépi kód)
		-> kódoptimalizálás //jobban optimalizál a legtöbb programozónál

ökölszabály: ne optimalizáljunk kézzel/"idő előtt"

értelmes programszöveg:
-----------------------
programnyelv definiálása szabályokkal (JLS - Java Language Specification)
- lexikális: milyen elemi építőkockák (tokenek)?
- szintaktikus: mit, hogyan lehet építeni? EBNF
- szemantikus: építmény értelmes?
- (parciálisan eldönthető)

EBNF:			//vagy
<stm> ::= <if-stm> | <assingm> | <while-stm>

			//kifejezés	//utasítás
<if-stm> ::= if (<expr>) <stm>
			 [else <stm>]
			//ˇtoken/kulcsszó

<while-stm> ::= while (<expr>) <stm>



------------------------------
Csomagok:
------------------------------

package first;
class Hello {
	//...
}

csomagokba szervezhetjük az osztálydefiníciókat, névtér
first.Hello nevű osztályokat definiál
osztálynév = [osztályt tartalmazó csomag neve (first)].[osztály rövid neve (Hello)]

néhány osztályból állónál nem kell csomag
több 100 osztálynál rövid név nem lehet azonos -> csomag kell
hu.elte.inf.kto -> csomagnév, ha ki akarja rakni netre, fejlesztő oldala
			   .datastruct -> adatszerkezet		}	alcsomag alnévtérben
			   .sorting -> rendező				}

csomagnevek hierarchiájának megfelelő könyvtárszerkezet
cd work //ebben dolgozunk, belépünk mappába
mkdir hu
mkdir hu/elte
gedit hu/elte/Hello.java //munkakönyvtárból dolgozunk, nem cd-zünk bele, fordító innen indul
javac hu/elte/Hello.java //fordítás
java hu.elte.Hello //futtatás

package hu.elte;
class Hello {
	//...
}


class Date {
	int year, month, day; // 3 mező, attribútumok
/*
	void nextDay() {
		if (month == 12 && day == 31) { //metódus, megnézni milyen nap, utolsónál hónap más stb
			year = year + 1;
			month = 1;
			day = 1;
		} else if {
			//HF
		}
	}
*/
	void printHu() { //hu?
		// System.out.print(year);
		// System.out.print(".");
		// System.out.print(month);
		// System.out.print(".");
		// System.out.print(day);
		// System.out.print(".");

		System.out.println(year + "." + month + "." + day + ".");
	}
}

java Date //nem tudja futtatni, csak fordítani lehet
		  //ugyanolyan kinézetű main metódus kell, public static void main(String[] args)
		  //így csak egy nagyobb program része lehet