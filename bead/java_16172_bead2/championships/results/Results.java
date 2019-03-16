package championships.results;

import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.util.*;
import java.io.*;
import java.lang.*;

public interface Results {
	void addResult(String event, String name, String nation, int place) throws IllegalArgumentException;
	void addResult(String event, Participant participant, int place) throws IllegalArgumentException;
	List<Participant> getResultsOf(String event);
	Map<String,List<Participant>> getResultsOfAll();
	Ranking<Integer> rankNationsByTotalMedals();
	Ranking<Medals> rankNationsByGoldFirst();
	void readFromFile(String filename) throws FileNotFoundException;
}