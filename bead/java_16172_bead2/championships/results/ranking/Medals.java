package championships.results.ranking;

public interface Medals extends Comparable<Medals> {
	int getGolds();
	int getSilvers();
	int getBronzes();
	@Override boolean equals(Object obj);
	@Override int hashCode();
	int compareTo(Medals obj);
	String toString();
}