package raktar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Raktar {
	private List<Termek> termekek;
	private List<Szett> szettek;

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

	public Termek getTermek(int index) {
		if (termekek.size() > 0) {
			if (termekek.size()-1 <= index) {
				return termekek.get(index);
			}
		}
		return null;
	}

	public Szett getSzett(int index) {
		if (szettek.size() > 0) {
			if (szettek.size()-1 <= index) {
				return szettek.get(index);
			}
		}
		return null;
	}

	public Termek termekKeres(int azonosito) {
		for (int i = 0; i < termekek.size(); i++) {
			if (azonosito == termekek.get(i).getAzonosito()) {
				return termekek.get(i);
			}
			return null;
		}
		return null;
	}

	public void termekBeolvas(String fNev) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fNev));
		String line = br.readLine();
		// termekek = new ArrayList<Termek>();
		termekek.add(Termek.createTermek(line));
		while (line != null) {
			if (Termek.createTermek(line) != null) {
				for (int i = 0; i < termekek.size(); i++) {
					if (Termek.createTermek(line).getAzonosito() == getTermek(i).getAzonosito()) { // nullpointerex...
						br.readLine();
					}
				}
				termekek.add(Termek.createTermek(line));
			}
			line = br.readLine();
		}
	}

	public void szettBeolvas(String fNev) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fNev));
		String line = br.readLine();
		while (line != null) {
			// String[] tmp = line.split(",");
			// Szett.ar = arKiszamol(termekKeres(Integer.parseInt(tmp[2])).getAr());
			szettek.add(Szett.createSzett(line));
			line = br.readLine();
		}
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < termekek.size(); i++) {
			sb.append(termekek.get(i).toString()).append("/n");
		}
		for (int j = 0; j < szettek.size(); j++) {
			sb.append(szettek.get(j).toString()).append("/n");
		}
		return sb.toString();
	}
}
