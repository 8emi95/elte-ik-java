package championships.results.ranking;

//import championships.results;

public interface Medals extends Comparable<Medals> {
	public int getGolds();
	
	public int getSilvers();
	
	public int getBronzes();
	
	public boolean equals(Object obj);
	
	public int hashCode();
	
	public int compareTo(Medals obj);
	
	public String toString();
}