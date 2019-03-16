package verseny;
import java.util.Arrays;

class Versenyzo {
	private String nev;
	private String[] versenyek; // tetszőleges hosszú tömb (versenyek nevei amiken korábban indult)

	Versenyzo(String nev, String[] versenyek) {
		this.nev = nev;
		this.versenyek = versenyek;
	}
	
	Versenyzo(String adatok) { // CSV, ha nincs verseny akk nincs vessző
		/*ArrayList<String[]> rows = new ArrayList<String[]>();
		while (sc.hasNextLine())
		{
			rows.add(sc.nextLine().split("\\s*,\\s*"));
		}
		String[][] table = new String[rows.size()][];
		table = rows.toArray(table);
		CSV c = new CSV(table);
		return c;*/
		
		/*
		if (   splitted.length > 1 
			&& name != null 
			&& name.length() > 0 
			&& !name.isEmpty() 
			&& Character.isUpperCase(splitted[0].charAt(0)) 
			&& Character.isUpperCase(splitted[1].charAt(0)) 
			&& splitted[0].length() > 0 
			&& splitted[1].length() > 0) {
			Author a = new Author(splitted[1], splitted[0]);
			return a;
		}
		else { return null; }
		*/
		
		// Scanner
		String[] splitted = adatok.split(",");
		if (adatok.contains(",")) {
			Versenyzo v = new Versenyzo(splitted[0]);
			for (int i = 1; i < splitted.length; ++i) {
				Versenyzo v = new Versenyzo(splitted[i]);
			}
		}
		else
		{
			// throw?
		}
	}
	// A második konstruktor a versenyző adatait egyetlen szövegként kapja meg: a név, és a versenyek vesszőkkel vannak elválasztva benne. Ha nincsenek versenyek, akkor a szöveg nem tartalmaz vesszőt. A konstruktor bontsa szét a szöveget, és töltse fel az adattagokat.
	// Segítség: használjuk a String osztály split metódusát a szétbontáshoz.
	
	public static Versenyzo javaVersenyzo = new Versenyzo("James Gosling", "Kanada Open"); // osztályszintű adattag
	// private ArrayList<Entry> entries = new ArrayList<Entry>();
	
	public String getNev() { return nev; }
	public String[] getVersenyek() { return Arrays.copyOf(versenyek, versenyek.length + 1); }
	// Ezek a műveletek és a konstruktorok ne szivárogtassák ki a belső állapotot:
	//		a tömb adattagok másolatait adják ki/állítsák be az adattagba, ne egyszerűen a tömb referenciáját.
	
	public String toString() {
		//return (lastName + ", " + firstName.substring(0, 1));
		//A metódus eredménye legyen Versenyzo[Versenyzo1, [versenyA, versenyB, versenyC, versenyD]], ha a versenyző neve Versenyzo1, a versenyei pedig versenyA, versenyB, versenyC és versenyD.
	}
	
	public boolean hasVerseny(String versenyNev) {
		// megkapja szövegesen egy verseny nevét, és visszatér azzal, hogy a versenyző részt vett-e ilyen nevű versenyen.
	}
}