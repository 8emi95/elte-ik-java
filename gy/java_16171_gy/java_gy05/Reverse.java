/*
1. Írjunk programot, mely sorokat olvas be a szabványos bemenetről, amíg tud! Ezután fordított sorrendben írja ki a sorokat a szabványos kimenetre! A sorok eltárolására használjuk a java.util.LinkedList<A> osztályt!

Megjegyzés:
- A parancssorban (Linuxon) Ctrl-D vagy (Windowson) Ctrl-Z kombinációval tudjuk jelezni a programnak, hogy nincs több sor, amelyet be kellene olvasnia.
- Annak eldöntésére, hogy van-e még beolvasásra váró sor, használjuk a java.util.Scanner osztály hasNextLine() metódusát! A következő sort a nextLine() metódussal tudjuk beolvasni. */

// javac... java... sorok írása (nem kell Main)
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections; // import static java.util.Collections.reverse; (helyette az egészet importáljuk)
class Reverse {
	public static void main(String[] args) {	// ide nem muszáj Stringet beírni
		LinkedList<String> lines = new LinkedList<>(); // vmilyen típusú elemeket (itt STring tárol), egyre hosszabb tud lenni
		Scanner sc = new Scanner(System.in); // Scanner sztály, sc billről szedi be a sorokat, !!!!!!!! BEADANDÓHOZ KELLHET !!!!!!!!!
		while (sc.hasNextLine()) // megkrédezzük h van-e még sor amit be lehet olvasni
			lines.add(sc.nextLine()); // be is olvassa, lista végéhez hozzáadjuk
		
		// java.util.Arrays a tömbök segédosztálya
		// java.util.Collections halmazok, listák, stb gyűjteménye - innen reverse kell, megfordít egy listát (osztályszintű statikus metódus)
		Collections.reverse(lines); // visszatérési értéke nincs (void), helyben megfordítja...
		for (String line : lines)
			System.out.println(line);
	}
}