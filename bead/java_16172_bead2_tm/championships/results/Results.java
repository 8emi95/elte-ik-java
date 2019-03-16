package bead.championships.results;

import bead.championships.results.ranking.Medals;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Results {

    public void	addResult(String event, Participant participant, int place) throws IllegalArgumentException;
    public void	addResult(String event, String name, String nation, int place)throws IllegalArgumentException;
    public List<Participant> getResultsOf(String event);
    public Map<String,List<Participant>> getResultsOfAll();
    public Ranking<Medals>	rankNationsByGoldFirst();
    public Ranking<Integer> rankNationsByTotalMedals();
    public void readFromFile(String filename) throws FileNotFoundException;
}
