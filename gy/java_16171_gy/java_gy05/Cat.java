/*
2. Valósítsuk meg a Unix-szerű rendszerek cat programját! A Cat argumentumként vár egy fájlnevet, melynek tartalmát kiírja a szabványos bemenetre.

Például:
$ echo "Hello, World!" > hello.txt
$ java Cat hello.txt
Hello, World!

Jelezzük hibaüzenettel, ha a fájl nem található. Ehhez kezeljük le a java.io.FileNotFoundException típusú kivételt!
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Cat {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File(args[0])); // más forrás kell a scannernek, File objektum
			while (sc.hasNextLine())
				System.out.println(sc.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}
//java Cat Cat.java -> kiírja önmagát