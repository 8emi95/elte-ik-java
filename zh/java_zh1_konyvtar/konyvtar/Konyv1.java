package konyvtar;

public class Konyv {
	private String cim;
	private String[] kategoriak;

	public Konyv(String cim, String[] kategoriak) {
		this.cim = cim;
		this.kategoriak = kategoriak.clone(); // kül konsi szivárogtat
	}

	public Konyv(String str) {
		String[] seged = str.split(",");
		if (seged.length == 1) {
			cim = seged[0];
			kategoriak = null;
		} else {
			cim = seged[0];
			kategoriak = new String[seged.length-1];
			for (int i = 1; i < seged.length; i++) {
				kategoriak[i-1] = seged[i];
			}
		}
	}

	public static Konyv javaKonyv = new Konyv("Java,java,programozas");

	public String getCim() {
		return cim;
	}

	public String[] getKategoriak() {
		return kategoriak.clone();
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public void setKategoriak(String[] kategoriak) {
		this.kategoriak = kategoriak.clone();
	}

	@Override public String toString() {
		String str = "Konyv[" + cim + ", [";
		for (int i = 0; i < kategoriak.length-1; i++) {
			str += kategoriak[i] + ", ";
		}
		str += kategoriak[kategoriak.length-1] + "]]";
		return str;
	}

	public boolean hasKategoria(String str) {
		for (int i = 0; i < kategoriak.length; i++) {
			if (kategoriak[i].equals(str)) {
				return true;
			}
		}
		return false;
	}
}