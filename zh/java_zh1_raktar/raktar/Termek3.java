package raktar;

public class Termek {
	private int azonosito;
	private String nev;
	private int ar;

	public Termek(int azonosito, int nev, int ar) {
		this.azonosito = azonosito;
		this.nev = nev;
		this.ar = ar;
	}

	public static Termek createTermek(String str) {
		String[] seged = str.split(",");
		if (seged.length == 3 && seged[1].length > 0) {
			try {
				int seged0 = Integer.parseInt(seged[0]);
				String seged1 = seged[1];
				int seged2 = Integer.parseInt(seged[2]);
				if (ar <= 0) {
					return null;
				}
				return new Termek(seged0, seged1, seged2);
			} catch (NumberFormatException ex) {
				return null;
			}
		} else {
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

	public void kedvezmenyAd(int szam) {
		double seged;
		if (szam < 0 || szam > 100) { // && !!!
			seged = Double.parseDouble(ar) * (Double.parseDouble(szam) / 100);
			ar = Integer.parseInt(seged);
		}
	}

	// toString() !!!
}