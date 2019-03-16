import java.util.Scanner;
import java.io.*;

public class Grep {
    public static void main(String[] args) {
	try {
	    Scanner s = new Scanner(new File(args[1]));
	    while (s.hasNextLine()) {
		String line = s.nextLine();
		if (line.contains(args[0]))
		    System.out.println(line);
	    }
	    s.close(); // fájl lezárása, erőforrások felszabadítása
	} catch (FileNotFoundException e) {
	    System.out.println("File not found.");
	}
    }
}
