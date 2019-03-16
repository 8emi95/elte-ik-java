package verseny;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Verseny {
	private String nev;
	private Versenyzo[] versenyzok;

	public Verseny(String filename) {
		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
			nev = sc.nextLine();
			versenyzok = new Versenyzo[Integer.parseInt(sc.nextLine())];
			int index = 0;
			while(sc.hasNext()) {
				versenyzok[index] = new Versenyzo(sc.nextLine());
				index++;
			}
		} catch (Exception ex) {}
	}

	@Override public String toString() {
		String str = "Verseny:(" + nev + ", ";
		for (int i = 0; i < versenyzok.length-1; i++) {
			str += versenyzok[i].toString() + ", ";
		}
		str += versenyzok[versenyzok.length-1].toString() + ")";
		System.out.println(str);
		return str;
	}

	public List<Versenyzo> getVersenyVersenyzoi(String nev) {
		List<Versenyzo> ret = new ArrayList<>();
		for (Versenyzo v : versenyzok) {
			if (v.hasVerseny(nev)) {
				ret.add(v);
			}
		}
		return ret;
	}
}