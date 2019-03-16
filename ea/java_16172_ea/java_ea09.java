2017.04.20.
9. Java EA

List<T> interface
sorozat adattípus nyilvános interfésze
pl. void add(T item);
    boolean reverse(T item);
    T get(int index);
    ...
    Iterator<T> iterator();
- sorrendiség az elemek között
- egy eée, többször is szerepelhet

Iterator<T> interface
adatszerkezet bejárásához nyilvános interfész
    boolean hasNext()
    T next()
    boolean remove()
- nincs sorrendiség
- egy elem egyszer

-> szétválasztjuk az adatszerkezetet és a  bejárását két külön objektumra


List<String> names = ... // pl. ArrayList v. LinkedList
Iterator<String> iter = names.iterator(); // nem érdekes a ontos osztálya, elég h Iterator
while (iter.hasNext()) {
    String name = iter.next();
    // do something
} // idióma adatszerkezet bejárásához

szép sítlus, használjunk interface-eket ahol lehet
ArrayList-het és LinkedList-hez más Iterator implementációk
Set<T> halmaz adattípus interface
HashSet<T> és TreeSet<T> implementáló osztályok
megint teljesen más Iterator implementációval


Collection<T> interface
ennek spec esetei a List<T> és a Set<T>
package java.util;
public interface List<T> extends Collection<T> {...}
                         ^interface-ek származhatnak egymásból
public interface Collection<T> extends Iterable<T> {...}

Iterable<T> interface
Iterator<T> iterator();
szabványos programkönyvtárban van, de kihat magára a nyelvre, a for-utasításon
-> enhanced for-loop <- főnök

List<String> names = new ...
for (String name : names) {
    // do sth
}


class Point extends java.lang.Object {...}
            ^osztályok közötti származtatás
            (osztály)öröklődés inherit? -> altípusosság -> interface extends
                                                        -> class implements interface
                                        -> kódátörökítés
            is-a (is-egy) kapcsolat fogalmak között
-> ekviv:
class Point {...}

                                                                                             Iterable<T>
                                                                                                 | [k]
                    java.lang.Object                                                         Collection<T>
    | [p]              | [p]                               | [p]                             | [k]       | [k]
Point           java.lang.Number                TreeSet<T> -------------------------> [f]    Set<T>      List<T>            
(mély fa)       |[p]           | [p]                                                     "interface-ek közötti öröklődés" = (ekviv) kiterjesztés
        java.lang.Integer    java.lang.Double
 
[p]
irányított fa gyökere az Object
osztályhierarchia

típushierarchia
[p] + [f] + [k]
irányított körmentes gráf

A <: B (részbenrendezés)
A altípusa a B (bázis)típusnak, ha A-ból vezet út B-be [f][p][k] ???k mentén (irányított)


altípusosság
LSP: Liskov's Substitutions Principle, Liskov-féle helyettesítési elv                                                       '
A egy altípusa B-nek, ha a programjainkban B típusú objektumok helyett nyugodtan használhatunk A típusú objektumokat is, nem lesz baj
OOP nyelvekben az altípusosságot az öröklődés indukálja (extends [p], implements [f], extends [k])

List<String> names = new ArrayList<>(); // <> elhagyható a String
ArrayList<string>       <       List<String>
hivatkozott objektum            változó deklarált típusa,
létrehozható osztálya           lehet interface
(intreface nem new-olható)

azaz a változók lehetnek polimorfak, de a dinamikus típus altípusa kell legyen a statikus stípusnak
^referenciák
dinamikus típus változhat

dinamukis       ->      változó típusa      <-      statikus
futás közben változhat                              állandók, nem változnak
pl. names = new LinkedList<String>();
    megváltoztatja a hivatkozott objektumot


void m(List<String> names) {
    names = new LinkedList<String>();
}


osztályöröklés  -> altípusképzés
(extends)       -> kód átörökítése
- megöröklöm a szülőosztály tagjait (attribútumok, metódusok)
  pl. bázisosztályban implementált műveletek hívhatók az alosztályon is, pl public int hashCode()
- újabb tagokkal bővíthetem a megörökölt dolgokhoz lépest
  pl. private int x, y mezők
      public void move (int dx, int dx) {...}
  (osztály megadása a különbségek felsorolásával)
- megváltoztathatom a megörökölt máveletek implementációját (felüldefiniálás) (különbség, specifikáció)

felüldefiniálás:
----------------
egy metódusnak több imeplementációja lehet, kül osztályokban
pl. Object-ben definiált a toString metódus, saját osztályaink felülír(hat)ják

dinamikus kötés: (dinamic binding, late binding)
----------------
metódushívásnál a híváshoz használt referencia dinamikus típusa alapján választódik ki h melyik implementáció hajtódjon végre
(a dinamikus típushoz legközelebbi)
(kitüntetett paraméter, p.move(...) -> p)

Java stb: csak a kitüntetett pm dinamikus típusa számít a kiválasztásban

statikus típus: milyen metódusok hívhatók meg?
dinamukus típus: melyik implementációt?

statikus típus fordítási időben ismert:
statikus típus ellenőrzés a statikus szemantikai szabályok ellenőrzésére használt,pl. meghívható egy metódus egy referencián?
ha nem, fordítási hiba

dinamikus típus futási időben ismert:
futási idejű döntés
alapvető OOP jellemvonás
rugalmas (+), lassú (-)
dinamikus típus speciálisabb lehet (altípus), futás közben pontosabb típusinformációk állnek rendelkezésre
Java lehetőséget ad dinamikus típusellenőrzésre is a pontosabb dinamikus típusok figyelembe vételével => rugalmasság
ha a d.t.e elbukik, az dinamikus szemantikai hiba, ClassCastException kivétel
