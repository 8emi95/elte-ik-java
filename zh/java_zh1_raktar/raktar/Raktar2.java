package raktar;

import java.util.*;
import java.io.*;

public class Raktar {
	private ArrayList<Termek> termekek;
	private ArrayList<Szett> szettek;

	public Raktar() {
		termekek = new ArrayList<>();
		szettek = new ArrayList<>();
	}

	public int termekekSzama() {
		return termekek.size();
	}

	public int szettekSzama() {
		return szettek.size();
	}

	public Termek getTermek(int x) {
		if (x < this.termekekSzama() && x >= 0) {
			return termekek.get(x);
		}
		return null;
	}

	public Szett getSzett(int x) {
		if (x < szettekSzama() && x >= 0) {
			return szettek.get(x);
		}
		return null;
	}

	public Termek termekKeres(int azon) {
		for (Termek termek : termekek) {
			if (azon == termek.getAzonosito()) {
				return termek;
			}
		}
		return null;
	}

	public void termekBeolvas(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String string = reader.readLine();
			while (string != null) {
				if (Termek.createTermek(string) != null) {
					Termek termek = Termek.createTermek(string);
					if (this.termekKeres(termek.getAzonosito()) == null) {
						termekek.add(Termek.createTermek(string));
					}
				}
				string = reader.readLine();
			}
		} catch (IOException e) {}
	}

	public void szettBeolvas(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String string = reader.readLine();
			while (string != null) {
				if (Szett.createSzett(string) != null) {
					Szett szett = Szett.createSzett(string);
					szett.arKiszamol(this.termekKeres(szett.getAlapTermekAzonosito()).getAr());
					szettek.add(szett);
				}
				string = reader.readLine();
			}
		} catch (IOException e) {}
	}

	@Override
	public String toString() {
		String string = "";
		for (Termek termek : termekek) {
			string += termek.toString() + "\n";
		}
		for (Szett szett : szettek) {
			string += szett.toString() + "\n";
		}
		return string;
	}
}