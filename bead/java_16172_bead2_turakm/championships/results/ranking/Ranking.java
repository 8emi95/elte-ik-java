package championships.results.ranking;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Ranking<T extends Comparable<T>> {
    Set<String> getNations();

    T getPointsOf(String nation);

    Map<String, T> getPointsOfAll();

    List<String> getRanking();

    List<String> getTop3();

    void printRankingToFile(String filename) throws FileNotFoundException;

}
