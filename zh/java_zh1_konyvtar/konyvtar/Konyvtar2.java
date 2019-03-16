package konyvtar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Konyvtar {
	private String nev;
	private Konyv[] konyvek;

	public Konyvtar(String fNev) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fNev));
		nev = br.readLine();
		konyvek = new Konyv[Integer.parseInt(br.readLine())];
		for (int i = 0; i < konyvek.length; i++) {
			konyvek[i] = new Konyv(br.readLine());
		}
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Konyvtar:(").append(nev);
		if (konyvek.length > 0) {
			sb.append(", ").append(konyvek[0].toString());
			for (int i = 1; i < konyvek.length; i++) {
				sb.append(", ").append(konyvek[i].toString());
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public List<Konyv> getKategoriaKonyvei(String katNev) {
		List<Konyv> kategoriaKonyvei = new ArrayList<>();
		for (Konyv k : konyvek) {
			if (k.hasKategoria(katNev)) {
				kategoriaKonyvei.add(k);
			}
		}
		return kategoriaKonyvei;
	}
}
