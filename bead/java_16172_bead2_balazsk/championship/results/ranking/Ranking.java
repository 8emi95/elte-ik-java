package championship.results.ranking;

import java.util.*;
import java.io.*;

public interface Ranking<T extends Comparable <T>> {

	public Set<String> getNations();
	public T getPointsOf(String nation);
	public Map<String, T> getPointsOfAll();
	public List<String> getRanking();
	public List<String> getTop3();
	public void printRankingToFile(String filename) throws  FileNotFoundException;

}