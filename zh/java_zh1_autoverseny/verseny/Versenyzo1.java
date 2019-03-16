package verseny;

public class Versenyzo {
	private String nev;
	private String[] versenyek;

	public Versenyzo(String nev, String[] versenyek) {
		this.nev = nev;
		this.versenyek = versenyek.clone();
	}

	public Versenyzo(String str) {
		String[] seged = str.split(",");
		if (seged.length == 1) {
			nev = seged[0];
		} else {
			nev = seged[0];
			versenyek = new String[seged.length-1];
			for (int i = 1; i < seged.length; i++) {
				versenyek[i-1] = seged[i];
				System.out.println(versenyek[i-1]);
			}
		}
	}

	public static Versenyzo javaVersenyzo = new Versenyzo("James Gosling,Kanada Open");

	public String getNev() {
		return nev;
	}

	public String[] getVersenyek() {
		return versenyek.clone();
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public void setVersenyek(String[] versenyek) {
		this.versenyek = versenyek.clone();
	}

	@Override public String toString() {
		String str = "Versenyzo[" + nev + ", [";
		for (int i = 0; i < versenyek.length-1; i++) {
			str += versenyek[i] + ", ";
		}
		str += versenyek[versenyek.length-1] + "]]";
		System.out.println(str);
		return str;
	}

	public boolean hasVerseny(String str) {
		for (int i = 0; i < versenyek.length; i++) {
			if (versenyek[i].equals(str)) {
				return true;
			}
		}
		return false;
	}
}