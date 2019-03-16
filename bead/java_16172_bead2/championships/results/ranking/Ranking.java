package championships.results.ranking;

import java.util.*;
import java.io.*;

public interface Ranking<T extends Comparable<T>> {
	Set<String> getNations();
	T getPointsOf(String nation);
	Map<String,T> getPointsOfAll();
	List<String> getRanking();
	List<String> getTop3();
	void printRankingToFile(String filename) throws FileNotFoundException;
}