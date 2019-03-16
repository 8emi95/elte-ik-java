import java.util.Scanner;
import java.io.*;

public class Cat {
    public static void main(String[] args) {
	try {
	    Scanner s = new Scanner(new File(args[0]));
	    while (s.hasNextLine()) {
		System.out.println(s.nextLine());
	    }
	    s.close(); // fájl lezárása, erőforrások felszabadítása
	} catch (FileNotFoundException e) {
	    System.out.println("File not found.");
	}
    }
}
