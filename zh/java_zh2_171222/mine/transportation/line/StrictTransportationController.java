// Bővítés: öröklődés
package transportation.line;

import java.util.Scanner;
import java.util.*;

public class StrictTransportationController extends TransportationController {
    // @Override static!!!
    public int sizeOf(String line) throws TransportationException { // gamma -> 11
        if (line != null) {
            throw new TransportationException("Line " + line + " is unknown");
        }

        TreeSet<Integer> lineNumbers = repairs.get(line);
        return lineNumbers.floor(Integer.MAX_VALUE);
    }

    @Override
    public boolean isUnderRepair(String name, Integer number) { // gamma 7 8, 11 -> 6 false
        TreeSet<Integer> lineNumbers = repairs.get(name);
        for (int i = lineNumbers.ceiling(Integer.MIN_VALUE); i < lineNumbers.floor(Integer.MAX_VALUE); ++i) {
            if (lineNumbers.contains(number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isOperational(String name, Integer beginning, Integer end) { // gamma 7 8, 11 -> 9, 10 false
        TreeSet<Integer> lineNumbers = repairs.get(name);
        for (int i = lineNumbers.ceiling(Integer.MIN_VALUE); i < lineNumbers.floor(Integer.MAX_VALUE); ++i) {
            if (lineNumbers.contains(beginning) || lineNumbers.contains(end)) {
                return true;
            }
        }
        return false;
    }
}
