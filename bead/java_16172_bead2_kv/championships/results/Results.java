package championships.results;

import championships.results.ranking.*;
import java.util.*;
import java.io.*;

public interface Results {
	void addResult(String event, Participant participant, int place);
	
	void addResult(String event, String name, String nation, int place);
	
	List<Participant> getResultsOf(String event);
	
	Map<String,List<Participant>> getResultsOfAll();
	
	Rankings<Integer> rankNationsByTotalMedals();
	
	Rankings<Medals> rankNationsByGoldFirst();
	
	void readFromFile(String filename) throws FileNotFoundException;
}