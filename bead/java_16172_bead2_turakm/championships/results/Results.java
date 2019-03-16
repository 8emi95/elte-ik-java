package championships.results;

import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Results {

    void addResult(String event, Participant participant, int place);

    void addResult(String event, String name, String nation, int place);

    List<Competitor> getResultsOf(String event);

    Map<String, List<Competitor>> getResultsOfAll();

    List<String> rankNationsByGoldFirst();

    List<String> rankNationsByTotalMedals();

    void readFromFile(String filename) throws FileNotFoundException;
}
