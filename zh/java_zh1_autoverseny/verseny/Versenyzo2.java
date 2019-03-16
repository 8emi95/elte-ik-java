package verseny;

public class Versenyzo {
	private String nev;
	private String[] versenyek;

	public Versenyzo(String nev, String[] versenyek) {
		this.nev = nev;
		this.versenyek = versenyek.clone();
	}

	public Versenyzo(String versenyzoData) {
		if (versenyzoData.contains(",")) {
			String[] sub = versenyzoData.split(",");
			nev = sub[0];
			versenyek = new String[sub.length-1];
			for (int i = 0; i < sub.length-1; i++) {
				this.versenyek[i] = sub[i+1];
			}
		} else {
			nev = versenyzoData;
		}
	}

	public static Versenyzo javaVersenyzo = new Versenyzo("James Gosling", new String[] {"Kanada Open"});

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
		StringBuilder sb = new StringBuilder();
		sb.append("Versenyzo[");
		sb.append(nev); 
		if (versenyek.length > 0) {
			sb.append(", [");
			sb.append(versenyek[0]);
			for (int i = 1; i < versenyek.length; i++) {
				sb.append(", ");
				sb.append(versenyek[i]);
			}
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	public boolean hasVerseny(String verseny) {
		for (String v : versenyek) {
			if (verseny.equals(v)) {
				return true;
			}
		}
		return false;
	}
}
