/*
Valósítsuk meg a GenericMax osztályban a generikus max() metódust, mely tetszőleges elemek gyűjteményét (java.util.Collection típus) várja paraméterül, és megkeresi a legnagyobbat közülük. Az egyetlen megkötés az eltárolt elemekre, hogy implementálják a Comparable interfészt.
*/

import java.util.*;

class GenericMax {
    public static <T extends Comparable<T>> T max(Collection<T> elems) {
        Iterator<T> it = elems.iterator();
        if (it.hasNext()) {
            T maximum = it.next();
            while (it.hasNext()) {
                T elem = it.next();
                if (maximum.compareTo(elem) {
                    maximum = elem;
                }
            }
            return maximum;
        } else {
            return null;
        }
    }
}