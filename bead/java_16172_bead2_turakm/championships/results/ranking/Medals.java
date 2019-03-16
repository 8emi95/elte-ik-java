package championships.results.ranking;

public interface Medals extends Comparable<Medals> {

    int compareTo(Medals obj);

    boolean equals(Object obj);

    int getGolds();

    int getSilvers();

    int getBronzes();

    int hashCode();

    String toString();
}
