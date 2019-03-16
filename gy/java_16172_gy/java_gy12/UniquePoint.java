import java.util.*;
import java.io.*;

class UniquePoint {
    static Set<Point> readPoints(String filename) {
        Set<Point> result = new HashSet<>(); // Set interface, nem lehet new-zni, kell választani egy osztályt (HashSet, TreeSet *rendezetten tárolja*, ...)
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parts = line,split(",");
                Point p = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                result.add(p);
            }
            return result;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            return result;
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println(readPoints(args[0]));
            Point p1 = new Point(0,1);
            Point p2 = new Point(0,1);
            System.out.println(p1.equals(p2)); // false, csak akkor működik a beépítet equals ha ugyanarról az obj-ról beszélünk (?)
            System.out.println(p1.equals(p1)); // true
            // felülírt equals után jó
            System.out.println(p1.equals("alma"));
            System.out.println(p1.equals(null));
        }
    }
}