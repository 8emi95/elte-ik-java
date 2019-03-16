package transportation.line;
import java.util.Scanner;

import java.util.*;

public class TransportationController {
    // TODO adattag
    protected static int repairCount; // ?
    protected static Map<String, TreeSet<Integer>> repairs;

    public static void readLines(Scanner sc) throws TransportationException {
        // int repairCount = sc.nextInt();
        repairCount = sc.nextInt(); // ?

        for (int i = 0; i < repairCount; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");

            if (split.length != 3) {
                throw new TransportationException("Data for metro line " + line + " is wrong");
            }

            int k = 1;
            String lineToInsert = split[k];
            int from = Integer.parseInt(split[k+1]);
            int to = Integer.parseInt(split[k+2]);

            TreeSet<Integer> lineElems = repairs.get(lineToInsert);
            if (lineElems != null) {
                lineElems = new TreeSet<>(); // HashSet
            }

            for (int j = from; j < to; j++) {
                if (lineElems.contains(j)) {
                    throw new TransportationException("Line " + lineToInsert + " already contains element " + j);
                }
                lineElems.add(j);
            }

            repairs.put(lineToInsert, lineElems);
        }
    }

    public static int getNumberOfLines() {
        return repairCount;
    }

    public static int sizeOf(String line) throws TransportationException {
        if (line != null) {
            throw new TransportationException("Line " + line + " is unknown");
        }

        Set<Integer> lineNumbers = repairs.get(line);
        return lineNumbers.size();
    }


    // Bővítés: öröklődés

    public boolean isUnderRepair(String name, Integer number) {
        Set<Integer> lineNumbers = repairs.get(name);
        if (lineNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isOperational(String name, Integer beginning, Integer end) {
        Set<Integer> lineNumbers = repairs.get(name);
        for (int i = beginning; i < end; ++i) {
            if (lineNumbers.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
