package championships.results.ranking;

import java.util.*;

public class MedalsImpl implements Medals {
	private int golds;
	private int silvers;
	private int bronzes;

	public MedalsImpl(int golds, int silvers, int bronzes) {
		this.golds = golds;
		this.silvers = silvers;
		this.bronzes = bronzes;
	}

	public int getGolds() {
		return golds;
	}
	public int getSilvers() {
		return silvers;
	}
	public int getBronzes() {
		return bronzes;
	}
	@Override public boolean equals(Object obj) {
		if (this != null && 
			obj != null && 
			this.getClass() == obj.getClass() && 
			this.compareTo((Medals) obj) == 0) {
			return true;
		}
		return false;
	}

	@Override public int hashCode() {
		return Objects.hash(this.getGolds(), this.getSilvers(), this.getBronzes());
	}

	@Override public int compareTo(Medals obj) {
		if (this.getGolds() > obj.getGolds()) {
			return 1;
		} else if (this.getGolds() == obj.getGolds()) {
			if (this.getSilvers() > obj.getSilvers()) {
				return 1;
			} else if (this.getSilvers() == obj.getSilvers()) {
				if (this.getBronzes() > obj.getBronzes()) {
					return 1;
				} else if (this.getBronzes() == obj.getBronzes()) {
					return 0;
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	public String toString() {
		return String.format("<%d, %d, %d>", golds, silvers, bronzes);
	}
}