package verseny;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.eclipse.markfactory.annotations.TestSolution;

@TestSolution
public class Verseny {
	private String nev;
	private Versenyzo[] versenyzok;

	public Verseny(String fajlnev) throws Exception {
		try (Scanner scanner = new Scanner(new File(fajlnev));) {
			nev = scanner.nextLine();

			String versenyzoSzamSor = scanner.nextLine();
			int versenyzoSzam = Integer.parseInt(versenyzoSzamSor);

			versenyzok = new Versenyzo[versenyzoSzam];
			
			for (int i = 0; i < versenyzoSzam; i++) {
				String versenyzoAdatok = scanner.nextLine();
				versenyzok[i] = new Versenyzo(versenyzoAdatok);
			}
		}
	}
	
	@Override
	public String toString() {
		String VersenyzoSorok = String.join(", ", getVersenyzoNevek());
		return String.format("Verseny:(%s, %s)", nev, VersenyzoSorok);
	}

	private String[] getVersenyzoNevek() {
		String[] retval = new String[versenyzok.length];
		for (int i = 0; i < retval.length; i++) {
			retval[i] = versenyzok[i].toString();
		}
		return retval;
	}

	public List<Versenyzo> getVersenyVersenyzoi(String keresettVerseny) {
		List<Versenyzo> retval = new ArrayList<>();
		for (Versenyzo Versenyzo : versenyzok) {
			if (Versenyzo.hasVerseny(keresettVerseny)) {
				retval.add(Versenyzo);
			}
		}
		return retval;
	}
}
