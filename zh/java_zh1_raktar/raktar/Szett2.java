package raktar;

public class Szett {
	private int azonosito, ar, alapTermekAzonosito, alapTermekDarabszam, szettKedvezmeny;
	private String nev;

	Szett(int azonosito, String nev, int alapTermekAzonosito, int alapTermekDarabszam, int szettKedvezmeny) {
		this.azonosito = azonosito;
		this.nev = nev;
		this.ar = -1;
		this.alapTermekAzonosito = alapTermekAzonosito;
		this.alapTermekDarabszam = alapTermekDarabszam;
		this.szettKedvezmeny = szettKedvezmeny;
	}

	public static Szett createSzett(String string) {
		String[] strings = string.split(",");
		if (strings.length == 5 && 
			!strings[1].equals("") && 
			isNumeric(strings[0]) && 
			isNumeric(strings[2]) && 
			isNumeric(strings[3]) && 
			isNumeric(strings[4])) {
			if (Integer.parseInt(strings[4]) >= 0 && 
				Integer.parseInt(strings[4]) <= 100 && 
				Integer.parseInt(strings[3]) > 0) {
				return new Szett(Integer.parseInt(strings[0]), 
								 strings[1], 
								 Integer.parseInt(strings[2]), 
								 Integer.parseInt(strings[3]), 
								 Integer.parseInt(strings[4]));
			}
		}
		return null;
	}

	public int getAzonosito() {
		return azonosito;
	}

	public int getAr() {
		return ar;
	}

	public String getNev() {
		return nev;
	}

	public int getAlapTermekAzonosito() {
		return alapTermekAzonosito;
	}

	public void arKiszamol(int price) {
		if (price > 0) {
			this.ar =  price * alapTermekDarabszam * (100 - szettKedvezmeny) / 100;
		}
	}

	@Override
	public String toString() {
		return azonosito + ": " + nev + " (" + ar + " Ft)";
	}

	private static boolean isNumeric(String str) {
		try {
			int x = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}