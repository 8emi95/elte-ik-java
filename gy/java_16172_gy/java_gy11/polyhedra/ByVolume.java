/*
4. Készítsünk egy osztályt, mely két hasábot térfogat szerint hasonlít össze, azaz megvalósítja a Comparator interészt! Az osztály segítéségvel a hasábokat növekvő sorrendbe rendezhetjük térfogat szerint a  Collections.sort() metódussal!
*/

package polyhedra;

import java.util.Comparator;

public class ByVolume implements Comparator<Prism> {
    public int compare(Prism p1, Prism p2) {
        return (int)(p1.volume() - p2.volume());
    }
}