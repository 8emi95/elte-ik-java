package verseny;

import java.util.Arrays;

import org.eclipse.markfactory.annotations.TestSolution;

@TestSolution
public class Versenyzo {
	public static final Versenyzo javaVersenyzo = new Versenyzo("James Gosling", new String[]{ "Kanada Open" });
	private String nev;
	private String[] versenyek;

	public Versenyzo(String adatok) {
		this(adatok.split(","));
	}

	private Versenyzo(String[] reszek) {
		this(reszek[0], Arrays.copyOfRange(reszek, 1, reszek.length));
	}
	
	public Versenyzo(String cim, String[] versenyek) {
		setNev(cim);
		setVersenyek(versenyek);
	}

	public boolean hasVerseny(String keresettKategoria) {
		for (String kategoria : getVersenyek()) {
			if (kategoria.equals(keresettKategoria))  return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Versenyzo[%s, %s]", getNev(), Arrays.toString(getVersenyek()));
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String[] getVersenyek() {
		return versenyek.clone();
	}

	public void setVersenyek(String[] versenyek) {
		this.versenyek = versenyek.clone();
	}
}
