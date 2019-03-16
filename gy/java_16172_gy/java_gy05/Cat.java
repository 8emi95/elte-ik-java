/* (winfoson type)
2 .Valósítsuk meg a Unix-szerű rendszerek cat programját! A Cat argumentumként vár egy fájlnevet, melynek tartalmát kiírja a szabványos bemenetre.

Például:
$ echo "Hello, World!" > hello.txt
$ java Cat hello.txt
Hello, World!

Jelezzük hibaüzenettel, ha a fájl nem található. Ehhez kezeljük le a java.io.FileNotFoundException típusú kivételt!
Gondoskodjunk minden esetben a fájl lezárásáról!
*/

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