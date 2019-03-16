package raktar;

public class Szett {
	private int azonosito;
	private String nev;
	private int ar;
	private int alapTermekAzonosito;
	private int alapTermekDarabszam;
	private int szettKedvezmeny;

	private Szett(int azonosito, String nev, int alapTermekAzonosito, int alapTermekDarabszam, int szettKedvezmeny) {
		this.azonosito = azonosito;
		this.nev = nev;
		this.alapTermekAzonosito = alapTermekAzonosito;
		this.alapTermekDarabszam = alapTermekDarabszam;
		this.szettKedvezmeny = szettKedvezmeny;
		ar = -1;
	}

	public static Szett createSzett(String szettData) {
		try {
			String[] tmp = szettData.split(",");
			if (tmp.length == 5 && 
				tmp[1].length() > 0 && 
				Integer.parseInt(tmp[3]) > 0 && 
				Integer.parseInt(tmp[4]) >= 0 && Integer.parseInt(tmp[4]) <= 100) {
				return new Szett(Integer.parseInt(tmp[0]), 
								 tmp[1], 
								 Integer.parseInt(tmp[2]), 
								 Integer.parseInt(tmp[3]), 
								 Integer.parseInt(tmp[4]));
			}
			return null;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public int getAzonosito() {
		return azonosito;
	}

	public String getNev() {
		return nev;
	}

	public int getAr() {
		return ar;
	}

	public int getAlapTermekAzonosito() {
		return alapTermekAzonosito;
	}

	public void arKiszamol(int alapTermekAr) {
		if (alapTermekAr > 0) {
			ar = (alapTermekDarabszam * alapTermekAr) - (alapTermekAr * alapTermekDarabszam * szettKedvezmeny / 100);
		}
	}

	@Override public String toString() {
		return azonosito + ": " + nev + " (" + ar + " Ft)";
	}
}
