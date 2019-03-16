package verseny;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verseny {
	private String nev;
	private Versenyzo[] versenyzok;

	public Verseny(String fNev) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fNev));
		nev = br.readLine();
		versenyzok = new Versenyzo[Integer.parseInt(br.readLine())];
		for(int i = 0; i < versenyzok.length; i++) {
			versenyzok[i] = new Versenyzo(br.readLine());
		}
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Verseny:(");
		sb.append(nev);
		if(versenyzok.length > 0) {
			sb.append(", ");
			sb.append(versenyzok[0].toString());
			for(int i = 1; i < versenyzok.length; i++) {
				sb.append(", ");
				sb.append(versenyzok[i].toString());
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public List<Versenyzo> getVersenyVersenyzoi(String versenyNev) {
		List<Versenyzo> versenyVersenyzoi = new ArrayList<>();
		for(Versenyzo v : versenyzok) {
			if(v.hasVerseny(versenyNev)) {
				versenyVersenyzoi.add(v);
			}
		}
		return versenyVersenyzoi;
	}
}
