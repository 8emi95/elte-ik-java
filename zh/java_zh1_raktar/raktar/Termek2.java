package raktar;
import java.lang.*;

public class Termek {
	private int azonosito, ar;
	private String nev;

	public Termek(int azonosito, String nev, int ar) {
		this.azonosito = azonosito;
		this.nev = nev;
		this.ar = ar;
	}

	public static Termek createTermek(String string) throws NumberFormatException {
		String[] strings = string.split(",");
		if (strings.length == 3 && 
			!strings[1].equals("") && 
			isNumeric(strings[0]) && 
			isNumeric(strings[2])) {
			if (Integer.parseInt(strings[2]) > 0) {
				return new Termek(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2]));
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

	public void kedvezmenyAd(int number) {
		if (number >= 0 && number <= 100 ) {
			ar = ar * (100 - number) / 100;
		}
	}

	private static boolean isNumeric(String str) {
		try {
			int x = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return azonosito + ": " + nev + " (" + ar + " Ft)";
	}
}