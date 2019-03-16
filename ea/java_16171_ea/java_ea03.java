2016.09.28.
3. Java EA

láthatósági módosítószó: befolyásolja h egy osztálynak a tagja kinek érhető el
-----------------------
- public: osztályból mindenki látja
- private: osztályból senki sem látja
- semmi: - félnyilvános (package-private/csomagszintű) láthatóság
		 - ugyanabban a csomagban elérhető, más csomagban nem
		 - csomagban osztály, benne félnyilvános tag - alcsomagokból már nem érhető el
- protected: (később)

csomagok:
---------
- logikai összetartozást fejez ki
- fizikai összetartozás a félnyilvános tagok mentén
- alcsomagra már nem ad hozzáférést (bár a logikai kapcsolat ott is fennáll)
- alkönyvtárakba szervezett programkód
- kis programoknál zavaró, kényelmetlen
	-> névtelen csomag: minden ebben a csomagban van
						nincs package utasítás
						minden osztály teljes neve = rövid névvel
- nagy programoknál segíti az átláthatóságot

változók, formális paraméterek tipizálására primitív típusok és osztályok is használhatók
osztály: recept arra hogyan működik az objektum

int i
i egész szám tárolására alkalmas

Rational r
r nem tárol racionális számot
osztály lepéldányosítása és hivatkozás egy objektumre
objektum példányosítás hatására jön létre: new Rational(2,5)

Rational r = new Rational(2,5) //összekapcsolva
létrehozott egy referenciát + egy objektumot, két dolgot összekapcsolta
referenciát ráállítom az objektumra


virtuális gép, program belső működése, adatok tárolása, változók tárolása:
--------------------------------------------------------------------------
- dinamikus tárhelyen (heap): objektumok (benne adattagok) reprezentálásba/tárolása (itt jönnek létre)
- statikus tárhelyen
- automatikus tárhelyen (execution stack / végrehajtási verem): metódushívások reprezentálása/nyilvántartása


program működése:
-----------------
- metódushívások láncolata/gráfja
- public static void main(String[]) - ezzel kezdődik
									- pontosan addig tart, amíg ez be nem fejeződik
									- közben a main által hívott metódusok futnak
(advanced: ennél picit pontosabban kellene fogalmani, pl. többszálú program)

execution stack:
- a program egy adott pontján éppen futó metódusok tárolása
- aktivációs rekord / activation record / stack frame:
	- minden metódushívásról/-aktiválásról bejegyzés/record készül a veremben
	- metódushívás		  -> új aktivációs rekord létrejön
	- metódusbefejeződés -> aktivációs rekordja törlődik a veremből
	- hívott mindig előbb fejeződik be, mint a hívó
	  addig a hívó törlődik
	  last in first out (LIFO) viselkedés a veremban

aktivációs rekord tartalma:
- technikailag: fordprog-on
- absztrakt értelemben, elvonatkoztatva a technikai részletektől: metódusok paraméterei + lokális változói

class Point {
	double x, y;
	double distance(Point that) { //2 paraméter: this, that
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return Math.sqrt(dx*dx + dy*dy)
	}
}
//meghívás
class Main{
	public static void main(String[] args) {
		Point p = new Point();
		Point q = new Point(); //nem írt konstruktort
		p.x = 3.14;
		System.out.println(p.distance(q));
	}
}
*végrehajtás: rajz*

ha nem írok egy osztályba konstruktort: automatikusan képződik egy
										csak ekkor képződik automatikusan
										fordítóprogram beilleszt a kódba egy ún. default konstruktort
										pl. Pointba bekerül: Point() {} //paraméter nélküli, "üres törzsű"

amikor a metódus meghívódik: 
- létrejönnek a lokális változói és a formális paraméterek(nek megfelelő lokális változók)
  ezeket használhatom, amíg a metódus fut
- lokális: csak abban a metódusban használhatom, csak ott érhetők el
- megszűnnek, amikor a metódus befejeződik és az aktivációs rekord törlődik
- lokális/automatikus változók autimatikusan létrjönnek és automatikusan megszűnnek metódusba való be-/kilépésnál
- ez az éllettartamuk (objektumok élettartama: new-tól gc-ig)

p.x: dereferálom a p referenciát (megkeresem a heap-en az objektumot)
	 és szelektálom az x mezőjét (az objektumon belül megkeresem az x adatot)
aliasing (paraméterátadás): ugyanarra az objektumra hivatkozhat több referencia is

amikor létrejön egy objektum: a JVM minden példánymezőjét inicializálja 0-ra
							  (osztályszintű mezők is valahogy így inicializálódnak)
lokális változó: inicializálatlan az első értékadásáig
				 fordprog véd az inicializálatlan változó használatától
				 fordíási hiba, ha olvasom a lokális változót értékadás előtt
				 szigorú szabály, ami visszadobhat "jó" programot azzal h nem helyes
				 át kell fogalmazni a programot h ne csak jó legyen hanem helyes is