package konyvtar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konyvtar {
	private String nev;
	private Konyv[] konyvek;

	public Konyvtar(String filename) { 
		try {
			Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
			nev = sc.nextLine();
			konyvek = new Konyv[Integer.parseInt(sc.nextLine())];
			int index = 0;
			while (sc.hasNext()) { 
				konyvek[index] = new Konyv(sc.nextLine());
				index++;
			}
		} catch (Exception ex) { 
		}
	}

	@Override public String toString() { 
		String str = "Konyvtar:(" + nev + ", ";
		for (int i = 0; i < konyvek.length-1; i++) { 
			str += konyvek[i].toString() + ", ";
		}
		str += konyvek[konyvek.length-1].toString()+")";
		return str;
	}

	public List<Konyv> getKategoriaKonyvei(String kat) { 
		List<Konyv> lista = new ArrayList<>();
		for (Konyv k : konyvek) { 
			if (k.hasKategoria(kat)) { 
				lista.add(k);
			}
		}
		return lista;
	}
}