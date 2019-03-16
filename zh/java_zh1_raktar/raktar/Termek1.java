package raktar;

public class Termek {
	private int azonosito;
	private String nev;
	private int ar;

	private Termek(int azonosito, String nev, int ar) {
		this.azonosito = azonosito;
		this.nev = nev;
		this.ar = ar;
	}

	public static Termek createTermek(String szoveg) {
		try {
			String[] tmp = szoveg.split(",");
			if (tmp.length == 3 && 
				tmp[1].length() > 0 && 
				Integer.parseInt(tmp[2]) > 0) {
				return new Termek(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]));
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

	public void kedvezmenyAd(int kedvezmeny) {
		if (kedvezmeny >= 0 && kedvezmeny <= 100) {
			ar = ar - (ar * kedvezmeny / 100);
		}
	}

	@Override public String toString() {
		return azonosito + ": " + nev + " (" + ar + " Ft)";
	}
}
