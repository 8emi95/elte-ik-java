package konyvtar;

public class Konyv {
	private String cim;
	private String[] kategoriak;

	public Konyv(String cim, String[] kategoriak) {
		this.cim = cim;
		this.kategoriak = kategoriak.clone();
	}

	public Konyv(String konyvData) {
		if (konyvData.contains(",")) {
			String[] tmp = konyvData.split(",");
			cim = tmp[0];
			kategoriak = new String[tmp.length-1];
			for (int i = 0; i < tmp.length-1; i++) {
				kategoriak[i] = tmp[i+1];
			}
		} else {
			cim = konyvData;
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
		StringBuilder sb = new StringBuilder();
		sb.append("Konyv[").append(cim);
		if (kategoriak.length > 0) {
			sb.append(", [").append(kategoriak[0]);
			for (int i = 1; i < kategoriak.length; i++) {
				sb.append(", ");
				sb.append(kategoriak[i]);
			}
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	public boolean hasKategoria(String katNev) {
		for (String k : kategoriak) {
			if (katNev.equals(k)) {
				return true;
			}
		}
		return false;
	}
}
