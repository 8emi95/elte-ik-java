/*
Definiáljuk a generikus Pair osztályt! Az osztály objektumai rendezett párokat ábrázolnak. A két komponens típusa tetszőleges lehet, és paraméterként adjuk meg.
Legyen egy konstruktor, mely paraméterül várja a komponenseket, emellett egy getFirst() és egy  getSecond() metódus is, melyek az első és második komponenst adják vissza.

Például:
Pair<Integer,Character> p = new Pair<>(0, 'a');
int n  = p.getFirst();
char c = p.getSecond();
char d = p.getFirst();                          // fordítási hiba 
Pair<Integer,Character> q = new Pair<>('b', 1); // fordítási hiba 

Haladóknak: definiáljuk felül az java.lang.Object equals() metódusát! Figyeljünk, hogy az equals() paramétere Object típusú.
*/

class Pair<F, S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}