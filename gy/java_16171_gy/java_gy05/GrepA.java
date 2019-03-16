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

// import java.io.FileReader;
// import java.io.BufferedReader;
import java.io.*;
class GrepA {
	public static void main(String[] args) {
		// Scanner nem jó ehhez
		// olyan bementi adatfolyam kell aminek a forrása egy fájlt (FileReader)
		// int i = j = 2; működik mert i = (j = 2)
		
		String phrase = args[0];
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(args[1]); // FileNotFoundException
			br = new BufferedReader(fr); // másik streamet vár paraméterül, ebből az adatfolyamból tudunk bufferelni, van readline() metódusa
			String line;
			while ((line = br.readLine()) != null) { // IOException
				if (line.equals(phrase)) // phrase.equals(line) nem ua (?)
					System.out.println(line);
			}
		} catch (FileNotFoundException e) { // IOException
			System.out.println("File not found!");
		} finally {
			if (br != null) br.close(); // IOException
		}
		
		/*
		System.out.println("alma" == "alma"); // fordító kioptimalizálja, tudja h ua
		String s1 = new String("alma");
		String s2 = new String("alma");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2)); */
	}
}