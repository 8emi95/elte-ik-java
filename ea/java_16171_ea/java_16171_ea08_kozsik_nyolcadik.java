strukturált programozás: nincsenek ugró utasítások, stb.
vezérléshez: szekvencia, elágazás, ciklus
nincs szükség goto, break, continue utasításokra
goto nincs is Javában, de break és continue van
1. Ökölszabály: programozzunk strukturáltan
2. Ökölszabály: nincsenek korlátlan hatalmú szabályok, időnként az ökölszabályt
   is meg lehet szegni (időnként és jó okkal)

ciklus esetén:
  break: kiugrik a ciklusból
  continue: a ciklusmag végére ugrik

switch:
breaket használunk a strukturált stílus követéséhez minden ág végén
(break nélkül: nem is igen nevezhető strukturáltnak)

kivételek kiváltása, kezelése:
- valamilyen értelemben kilép a strukturált programozás kereteiből (lexikálisan)
  (de azért valami struktúrát megőriz, dinamikus struktúra, azaz metódushívások)
- modern nyelvekben gyakran használt lehetőség,
  Java programozók: intenzíven


OOP

interfész                                   interface

osztály tartalmának leszűkítése             nyelvi konstrukció
  kívülről megfigyelhető nézetre            típusdefiníciós eszköz
absztrakció: a private részletektől         referenciatípusok
  való elvonatkozás kifejeződése            Java nyelv: class != interface
OOP fogalom                                 JVM: class és interface hasonló
                                            fordítás után: .class bájtkód


interface segítségével jól megadhatók az osztályok interfésze
                       explicitté tehetők

public interface Runnable {
    public void run();      // deklaráljuk, nem implementáljuk
}

nyilvános run metódussal rendelkezzen egy osztály


class Lion implements Runnable {
	private float weight;
	public void feed(){ ... }     // definiáljuk a műveleteket
	public void run(){ ... }      // megajuk az implementációt is
}

deklaráció: bejelentem, hogy van, és megadom azokat a tulajdonságait, amik
            alapján használni lehet
definíció: meghatározom, azaz megadom, hogyan működik

A Lion deklarálja és definiálja a feed metódust.

interface: típusként használható
class: típusként is használható, és példányíosítható is

az interface nem példányosítható

típus:
- változó
- formális paraméter
- metódus visszatérési érték
típusa megmondja, hogyan használható (típushelyes használat)
a nyelv statikus szemantikai szabályait így tartatom be

Runnable valtozo;
...
valtozo.run();     // típushelyes


a változó értéke egy objektumreferencia lesz, az objektum egy osztályból
példányosul (-> konstruktor)
az osztály implementálja az interface-t

Lion valtozo;
...
valtozo.run();


...
valtozo = new Lion()
...

public interface Closeable {
	void close();           // pongyolaság
}

interface-ben automatikusan minden metódusdeklaráció: public
a megvalósító class-ban szintén public kell legyen (itt viszont ki is kell
írni)

class Lion implements Runnable, Closeable {
	private float weight;
	public void feed(){ ... }     // definiáljuk a műveleteket
	public void run(){ ... }      // megajuk az implementációt is
	public void close(){ ... }    // kell a public!
}

osztály: esetleg bonyolult, összetett viselkedés, amely több kontextusban is
használható lehet (több interface-t is megvalósíthat)
interfész: az implementált interface-k összessége, valamint minden egyéb
public dolog, amit nem nevesítettem interface formájában

ugyanazt az interface-t több osztály is megvalósíthatja
különböző megvalósításoktól való elvonatkoztatás lehetősége

Lion leo;
nem érdekel, mi van a Lion-on belül, elvonatkoztatunk a belső működéstől

Closeable leo;
attól is elvonatkoztatok, hogy többféle implementáció is létezhet
leo lehet akár FileInputStream is

absztraktabb programozást tesz lehetővé az interface
a jó OO programozó törekszik az interface-k használatára típusként
  class-t akkor használ, ha példányosít, vagy olyan helyzetben kell típust
  használnia, amelyben nem létezik a használatot kifejező interface

package java.util;
public interface List<T> {
	void add( T item );
	boolean contains( T item );    // pongyola!
	T get( int index );
	...
}

generikus interface megvalósítása

package java.util;
public class ArrayList<T> implements List<T> {
	void add( T item ){ ... }
	boolean contains( T item ){...}    // pongyola!
	T get( int index ){...}
	...
}

hasonlóan a LinkedList is.

extrém eset: 0 db metódus

package java.io;
public interface Serializable {}

class Lion implements java.io.Serializable {}

java.lang.Cloneable

marker interface
jelzi pl. a compiler számára az osztály egy tulajdonságát, ami alapján pl.
valami speciális kód fordítandó az osztályból


package java.util;
public interface List<T> {
	void add( T item );
	boolean contains( T item );    // pongyola!
	T get( int index );
	Iterator<T> iterator();
	...
}

package java.util;
public interface Iterator<T> {
	boolean hasNext();
	T next();
	// pongyola!
}

List<Integer> lista;
...
Iterator<Integer> iter = lista.iterator();
while( iter.hasNext() ){
   ... iter.next() ...
}

idióma iterátor használatára, adatszerkezet bejárására (elemek megtekintésére)

enhanced for-loop:

for( Integer next: lista ){
   ...
}

ez ugyanarra a bájtkódra fordul, mint a fentebbi

package java.util;
public interface Iterable<T> {
	Iterator<T> iterator();
}

az ilyen interface-t megvalósító típusokra működik az enhanced for-loop

ArrayList, LinkedList, HashSet, TreeSet

package java.util;
public interface List<T> extends Iterable<T> {
	//Iterator<T> iterator();
        void add( T item );
	...
}

List<T> is-a Iterable<T>
List<T> örököl Iterable<T>-ből


List<Integer> lista = new ArrayList<Integer>();

a lista változó statikus típusa: List<Integer>
                dinamikus típusa: ArrayList<Integer>

statikus típus: deklarált típus, azaz ami a [változó] deklarációjában szerepel
                (class vagy interface (vagy primitív típus))
dinamikus t.: a [változó által] hivatkozott objektum példányosításához
              használt osztály

ha a statikus típus egy interface, a dinamikus típus olyan osztály, ami
megvalósítja

ArrayList<Integer> is-a List<Integer>

altípus

dinamikus típus a statikus típus altípusa

