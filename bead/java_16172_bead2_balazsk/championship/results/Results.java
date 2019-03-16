package championship.results;

import championship.results.ranking.Medals;
import championship.results.ranking.Ranking;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Results {

	void addResult(String event, String name, String nation, int place) throws IllegalArgumentException;
	void addResult(String event, Participant participant, int place) throws IllegalArgumentException;
	List<Participant> getResultsOf(String event);
	Map<String, List<Participant>> getResultsOfAll();
	Ranking<Integer> rankNationsByTotalMedals();
	Ranking<Medals> rankNationsByGoldFirst();
	void readFromFile(String filename) throws FileNotFoundException;
    List<Result> getList();
}