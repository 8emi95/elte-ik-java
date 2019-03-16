/*
3. Valósítsuk meg a Unix-szerű rendszerek grep programját! A Grep paraméterül vár egy szöveget és egy fájlnevet. Miközben olvassa a fájlt:
a) kilistázza azokat a sorokat, melyek megegyeznek a paraméter szöveggel.
b) kilistázza azokat a sorokat, melyben a szöveg megtalálható.
c) Szorgalmi feladat. A sor számát is kiírja, amelyben a szöveg megtalálható. Segítség: használjuk a java.io.LineNumberReader-t, hogy megtudjuk, hanyadik sorban járunk!
Például:
$ echo "Hello, World!\n Howdy?" > hello.txt
$ java Grep World hello.txt
Hello, World!

Jelezzük hibaüzenettel, ha a fájl nem található. Ehhez kezeljük le a java.io.FileNotFoundException típusú kivételt!
Ne kezeljük le az java.io.IOException típusú kivételt, hanem specifikáljuk a main() fejlécében!
Gondoskodjunk minden esetben a fájl lezárásáról!
*/

import java.io.*;
class GrepA2 {
	public static void main(String[] args) {
		String phrase = args[0];

		try (FileReader fr = new FileReader(args[1]); // try-with-resources
			 BufferedReader br = new BufferedReader(fr)) {

			String line;
			while ((line = br.readLine()) != null) { // <- IOException
				if (line.equals(phrase))
					System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}