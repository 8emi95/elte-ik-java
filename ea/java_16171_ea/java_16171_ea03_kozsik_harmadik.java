láthatóságai módosítószo
- public
- private
- nincs semmi: félnyilvános (package-private, csomagszintű) láthatóság
  ugyanabban a csomagban elérhető a tag
 
csomag: logikai összetartozás, fizikai összetartozás a félnyilvános tagok mentén
alcsomagra már nem ad hozzáférést (bár logikai kapcsolat ott is fennáll)
- protected (majd később)

csomagok - akönyvtárakba szervezett programkód
kis program esetén zavaró, kényelmetlen lehet
   -> névtelen csomag, minden ebben a csomagban
      (ha nincs package utasítás a kódban)
      osztály teljes neve == a rövid névvel
      a public nem bír jelentőséggel
nagy program esetén segíti az átláthatóságot

változók, formális paraméterek tipizálására primitív típusok és osztályok is
osztály: egyben recept arra nézve, hogyan működik az objektum

int i
i egész szám tárolására alkalmas

Rational r
r nem tárol racionális objektumot
hivatkozás egy objektumra
az objektum a példányosítás hatására jön létre: new Rational(2,5)

Rational r = new Rational(2,5)    összekapcsolva
létrejön egy referencia és egy objektum, és a kettő összekapcsolódik
a referenciát ráállítom az objektumra

virtuális gép, program belső működése, adatok tárolása
- dinamikus tárhelyen (heap)
- statikus tárhelyen
- automatikus tárhelyen (stack, végrtehajtási verem)

objektumok (és benne az adattagok) a heapen jönnek létre
élettartam: new-tól gc-ig
lásd ábra

program működése: metódushívások láncolata, gráfja
public static void main( String[] )
ezzel kezdődik, és pontosan addig tart, amíg be nem fejeződik
közben a main által hívott metódusok futnak
(advanced: ennél picit pontosabban kellene fogalmazni, pl. többszálú prg)

a prg egy adott pontján éppen futó metódusok tárolása: execution stack
minden metódushívásról (aktiválásról) bejegyzés (record) készül a veremben
aktivációs rekord (activation record, stack frame)
metódus hívása: új aktivációs rekord
metódus befejeződése: az aktivációs rekordja törlődik a veremből
a hívott előbb fejeződik be, mint a hívó
last in first out viselkedés LIFO - verem

lásd: ábra

stack: metódushívások nyilvántartása
heap: objektumok/adatok tárolása

aktivációs rekord tartalma:
- technically: fordítóprogramok című tárgy
- absztrakt értelemben, erlvonatkoztatva a technikai részletektől:
  metódusok paraméterei és lokális változói

class Point {
	double x, y;
	double distance( Point that ){
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return Math.sqrt( dx*dx + dy*dy );
	}
}

class Main {
	public static void main( String[] args ){
		Point p = new Point();
		Point q = new Point();
		p.x = 3.14;
		System.out.println( p.distance(q) );
	}
}

végrehajtás: lásd ábra

ha nem írok egy osztályba konstruktort, automatikusan képződik egy
(és csak ekkor képződik ilyen), a fordítóprogram beilleszt a kódba
egy ún. default konstruktort.
pl. a Pointba bekerül:

Point(){}

paraméter nélküli, "üres törzsű"

amikor a metódus meghívódik, létrejönnek a lokális változói és a formális
paraméterek(-nek megfelelő lokális változók)
használhatom ezeket, amíg a metódus fut
lokális, azaz csak abban a metódusban használhatók
megszűnnek, amikor a metódus befejeződik, és törlődik az aktivációs rekord
automatikus változók, automatikusan létrejönnek és megszűnnek metódusba való
be- és kilépésnél
ez az élettartamuk

p.x: dereferálom a p referenciát (megkeresem a heapen az objektumot) és
     szelektálom az x mezőjét (az objektumon belül megkeresem az x adatot)

ugyanarra az objektumra hivatkozhat több referencia is: aliasing
(paraméterátadás)


amikor létrejön egy objektum, a JVM minden példánymezőjét inicializálja 0-ra
(az osztályszintű mezők is valahogy így inicioalizálódnak)
lokális válzotó: inicializálatlan az első értékadásáig
  a fordítóprg véd az inicializálatlan változó használatától
  fordítási hiba, ha olvasom a lokális változót értékadás előtt
  szigorú szabály, ami visszadobhat "jó" programot azzal, hogy nem helyes
  át kell fogalmazni a programot, hogy ne csak jó legyen, hanem helyes is


