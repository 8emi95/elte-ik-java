package championship.results.ranking;

public interface Medals extends Comparable<Medals> {

	int getGolds();
	int getSilvers();
	int getBronzes();
	boolean equals(Object obj);
	int hashCode();
	int compareTo(Medals obj);
	String toString();

}