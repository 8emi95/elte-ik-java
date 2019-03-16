package verseny;
import java.util.Arrays;

public class Versenyzo {
	private String nev;
	private String[] versenyek;

	public Versenyzo(String nev, String[] versenyek) {
		this.nev = nev;
		this.versenyek = Arrays.copyOf(versenyek, versenyek.length); // !!!! ne szivárogtassuk ki a belső állapotot
	}
	
	public Versenyzo(String adatok) { 
		String[] splitted = adatok.split(",");
		nev = splitted[0];
		versenyek = Arrays.copyOfRange(splitted, 1, splitted.length);
	}
	
	public String[] getVersenyek(String[] versenyek) {
		// return versenyek; nem jó, kiszivárogtatjuk a belső állapotot
		return Arrays.copyOf(versenyek, versenyek.length);
	}
	public void setVersenyek(String[] versenyek) {
		// this.versenyek = versenyek; nem jó, kiszivárogtatjuk a belső állapotot
		this.versenyek = Arrays.copyOf(versenyek, versenyek.length);
	}
}