2016.11.09.
8. Java EA

strukturált programozás:
- nincsenek ugró utasítások
- szekvencia, elágazás, ciklus
- nincs szükség goto, break, continue utasításokra
- goto nincs is Javában, break és continue van

1. ökölszabály: programozzunk strukturáltan
2. ökölszabály: nincsenek korlátlan hatalmú szabályok, időnként az ökölszabályt is meg lehet szegni (időnként és jó okkal)

ciklus esetén:
- break: kiugrik a ciklusból
- continue: ciklusmag végére ugrik


switch:
- break-et használunk a strukturált stílus követéséhez mind ág végén
- break nélkül nem is igen nevezhető strukturáltnak

kivételek kiváltása/kezelése:
- vmilyen értelemben kilép a strukturált programozás kereteiből (lexikálisan)
  (de azért vmi struktúrát megőriz, dinamikus struktúra azaz metódushívások)
- modern nyelvekben gyakran használt lehetőség
  Java programozók: intenzíven



OOP

interfész															interface
---------															---------
osztály tartalmának leszűktése										nyelvi konstrukció
kívülről megfigyelhető nézetre										típusdefiníciós eszköz
absztrakció: private részletektpl való elvonatkozás kifejezése		referenciatípusok
																	Java nyelv: class != interface
																	JVM: class és interface hasonló
																	fordítás után: .class bájtkód

interface segítségével jól megadhatók az osztályok interfésze explicitté tehetők

public interface Runnable {
	public void run();
}

nyilvános run metódussal rendelkezzen egy osztály

class Lion implements Runnable {
	private float weight;
	public void feed() { ... } // definiáljuk a műveleteket
	public void run() { ... } //megadjuk az implementációt is
}

deklaráció: bejelentem h van, és magadom azokat a tulajdonságait amik alapján használni lehet
definíció: meghatározom, azaz megmondom hogyan működik
Lion deklarálja és definiálja a feed metódust

interface: típusként használható, nem példányosítható
class: típuskénti s használható, példáonysítható is

típus:
- változó
- formális paraméter
- metódus visszatérési érték
típusa megmondja hogyan használható (típushelyes használat)
a nyelv statikus szemantikai szabályait tartatom bejelentem

Runnable valtozo;
...
valtozo.run(); // típushelyes


valtozo = new Lion()

public interface Closeable {
	void close(); // pongyolaság
}

interface-ben automatikusan minden metódusdeklaráció public
a megvalósító class-ban szintén public kell legyen (itt viszont ki is kell írni)

class Lion implements Runnable, Closeable {
	private float weight;
	public void feed() { ... } // definiáljuk a múveleteket
	public void run() { ... } // megadjuk az implementációt is
	public void close() { ... } // kell a public
}

osztály: esetleg bonyolult, összetett viselkedés amely több kontextusban is használható lehet (több interface-t is megvalósít)
interfész: az implementált interface-ek közössége, valamindm inden egyéb public dolog amit nem nevesítettem interface formájában

ugyaanazt az interface-t több osztályi is megvalósíthatja
különböző megvalósításoktól való elvonatkoztatás lehetősége

Lion leo; // nem érdekel mi van a Lion-on belől, elvoatkoztatunk a belső működéstől
Closeable leo; // attól is elvoatkoztatunk h többféle impelementáció is léthethet, leo lehet akár FileInputStrem

absztraktabb programozást tesz lehetővé az interfacejó OOP programozó törekszik az interface-ek használatára típusként
classt akkor használ ha példáonysít, vagy olyan helyzetben kell típust használnia amelyben nem létezik a használatot kifejező interface

package java.util;
public interface List<T> {
	void add(T item) { ... }
	boolean contains(T item) { ... } // pongyola
	T get(int index) { ... }
}

hasonlóan a LinkedList is

extrém eset: 0 db metódus

package java.io;
public interface Serializable {}
class Lion implements java.io.Serializable {}
java.lang.Cloneable;