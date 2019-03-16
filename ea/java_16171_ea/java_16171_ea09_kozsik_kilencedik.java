OOP lényege: osztályok közötti örölődés

bázisosztály -> alosztály: különbségek megadásával új definíció

extends: megöröklök mindent + kiterjesztem,
                 azaz kibővítem, megváltoztatom
                                     |
				metódus felüldefiniálása
				override, redefine

objektum dinamikus típusa: a létrehozásához használt osztály

változó statikus típusa: a változó deklarálásához használt típus
változó dinamikus típusa: a hivatkozott objektum dinamikus típusa

kifejezés dinamikus típusa: a hivatkozott objektum dinamikus típusa

dinamikus kötés: egy metódus különböző imoplementációja közül a
dinamikus típushoz leginkább illeszkedőt választjuk ki futási időben,
és azt hajtjuk végre

a.m(p1,p2) 

compiler: ellenőrzi az értelmességét
az "a" változó statikus típusa, mondjuk A, tartalmazzon m metódust
(vagy ott definiált, vagy öröklött metódust), amelynek paraméterezése
megfelel, azaz p1 és p2 kifejezések statikus típusa megfelel a talált
m metódus formális paraméterei deklarált típusának
(túlterhelt m metódusok közötti választás fordítási időben)

X típus megfelel Y típusnak: X ugyanaz, mint Y, vagy X altípusa Y-nak

void m( int x, int y )... 
formális paraméterek: x, y

m(3,5)
aktuális paraméter: 3, 5


fordító dolga: ellenőrizni a statikus típusok alapján a metódushívás
  értelmességét

class B {
    void m( int x, int y ){}
    void m( int x ){}  // ez itt túlterhelés (overloading)
}

class A extends B {
    void m( int x, int z ){    // ez itt felüldefiniálás (overriding)
        System.out.println("A.m");
    }
    // itt is van egy megörökölt, de felül nem definiált m(int), túlterhelt
}


nem túlterhelés, mert ugyanaz a szignatúra
                        (név és formális paraméterek deklarált típusa)
			m(int,int)
lehet más a formális paraméter neve.

a.m(3,5)

T.fel, hogy a fordító elfogadta, azaz helyes (értelmes) ez a hívás, mert
mondjuk "a" deklarált típusa B vagy A.

Futás közben a futtató rendszer dönti el, hogy az üres törzs vagy a kiíró
törzs hajtódik-e végre. Az "a" dinamikus típusához leginkább illeszkedő
implementáció.

Ha "a" dinamikus típusa A, akkor a kiíró.
Ha "a" dinamikus típusa B, akkor az üres.

B a;   // statikus típus: B
a = new B();  // dinamikus típus: B
a.m(5,3)   üres törzsű, B-beli implementáció
a = new A();  // dinamikus típus: A
a.m(5,3)   kiíró törzsű, A-beli implementáció, mert az jobban illik a din.t-hoz

a dinamikus típus futás közben megváltozhat
(a statikus típus nem változik)

if( feltétel ){
  a = new A();
} else {
  a = new B();
}

// itt a fordító csak annyit tud, hogy a dinamikus típusa a-nak A vagy B
// futás közben már tudni fogjuk itt (lekérdezhetjük), hogy melyik

a.m(5,3)

a futtató rendszer tudja, melyik implementációt kell meghívni.

statikus típus szerepe: statikus típusellenőrzés, fordítás közben vizsgálom,
hogy értelmes-e a kód

dinamikus típus: futás közben választom ki a lehetséges értelmezések közül a
"legjobbat"

statikus típus: fordító számára ismert
dinamikus típus: futtató rendszer számára ismert

dinamikus típus altípusa a statikus típusnak (beleértve azt, hogy ugyanaz)

String s = new Object();
fordítási hiba, Object nem felel meg Stringnek
(az Object nem altípusa Stringnek)

Object s = new String();
értelmes, s dinamikus típusa String
(a String altípusa az Objectnek)

interfészt implementáló osztály altípusa az interfésznek
alosztály altípusa a bázisosztálynak
származtatott interfész altípusa a bázisinterfésznek

interface Iterable<T> ...
interface List<T> extends Iterable<T> ...
class AbstractList<T> implements List<T>
class ArrayList<T> extends AbstractList<T>

altípus <: reláció: részbenrendezés
- reflexív, pl. List<String> <: List<String>
- antiszimmetrikus
  különböző típusok nem lehetnek oda-vissza altípus relációban
- tranzitív, pl. ArrayList<String> <: Iterable<String>

ArrayList<String> <: AbstractList<String> <: List<String> <: Iterable<String>
speciális                                                          általános

fordítási hiba:
class A extends B ...   és    class B extends A ...

alfa = beta
m(beta)   és   m( alfa par )

beta kifejezés fordító által ismert típusa (statikus típusa) feleljen meg
(legyen altípusa) az alfa kifejezés fordító által ismert (statikus) típusának.

jól típusozottság, statikus típushelyesség

alosztály - szülőosztály (tranzitívan lezárva: leszármazott o - bázis o)
altípus - bázistípus

extends (class-class), implements (class-interface) és extends (interface-interface)

class B {}
class B extends java.lang.Object {}

osztályok közötti altípus reláció: irányított fa, gyökere az Object
összefüggő gráf, nem tartalmaz kört, irányítatlant sem!

class A extends B: csak egy szülőosztály adható meg
(ha semmi, akkor implicit Object)

interface I extends J, K: több szülőinterfész megadható

interfészek közötti altípus reláció: irányított, körmentes gráf
tartalmazhat irányítatlan kört (és nem is feltétlenül összefüggő)

egy osztály több interfészt is megvalósíthat, több interfészből származtathatom
(interfészt sosem származtatok osztályból)

class A implements I, J: több szülőinterfész megadható

a három együtt: irányítatlan körmentes gráf
ennek a tranzitív/reflexív lezártja az altípus reláció, szintén irányított, körmentes gráf

altípusosság általános, elv-szerű megfogalmazása (nem pontos definíció)
Liskov-féle helyettesítési elv
Liskov Substitution Principle

Az A típus altípusa B-nek, ha programjainkban a B típusú objektumok helyett
használhatok A típusú objektumokat is, és ebből nem lesz baj.

alosztály ezért indukál altípust is.
az alosztály megörököl mindent a bázisosztályból, azaz minden számítás
elvégezhető alosztályba tartozó objektumon is, ha elvégezhető volt
bázisosztályba tartozó objektumon.

hasonlóan az implements és az interface-extends is megfelel LSP-nek.

altípusos polimorfizmus:
egy megírt kód alkalmazható többféle típussal, mert a benne szereplő típusok
altípusaival is működni fog

parametrikus polimorfizmus:
egy definíció felparaméterezhető típussal
generic: olyan osztály, interfész vagy metódus, amelynek van formális
típusparamétere, melynek megfeleltethetők különböző típusok (aktuális
típusparaméterek)

interface List<T>       <-- T formális paraméter, generikus interface
List<Integer>           <-- Integer aktuális paraméter, paraméterezett intrf.

mindkét polimorfizmus segít rugalmasabb, elegánsabb kód készítésében,
a kód újrafelhasználhatóságában.

többszörös öröklődés (multiple inheritance)
egy típusnak több szülője van
interface A extends B, C
class A extends B implements C, D

osztály-extends: nincs többszörös öröklődés
class A extends B,C  NINCS

A Java az egyszerűség érdekében tiltja, igyekszik elkerülni a komplikációkat,
mely a többszörös osztályöröklés problémáinak megoldásával járna

class B {
	void m( int x, int y ){}
}

class A extends B {
	void m( int x, int z ){    // ez itt felüldefiniálás (overriding)
		System.out.println("A.m");
		super.m(x+1,z+1);    // megörökölt implementáció hívása
		System.out.println("A.m");
	}
}


class B {
	private int x;
	B( int x ){ this.x = x; }
	int get(){ return x; }
}

class A extends B {
	private int y;
	A(int x){
		super(x);   // nem előzheti meg más utasítás
		y = get();
	}
}

