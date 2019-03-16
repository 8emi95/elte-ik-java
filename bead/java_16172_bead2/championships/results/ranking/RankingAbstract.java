package championships.results.ranking;

import championships.results.Results;
import championships.results.ResultsImpl;

import java.util.*;
import java.io.*;

public abstract class RankingAbstract<T extends Comparable<T>> implements Ranking<T> {
	protected ResultsImpl resultList;

	public Set<String> getNations() {
		Set<String> nations = new HashSet<>();

		for (ResultsImpl.Result r : this.resultList.getList()) {
			String nation = r.getResultNation();
			nations.add(nation);
		}

		return nations;
	}

	public abstract T getPointsOf(String nation);
	public abstract Map<String,T> getPointsOfAll();

	@Override public List<String> getRanking() {
		List<String> rankNations = new ArrayList<>();
		Map<String, T> map = new SortHashMapByValues<T>().sortByValues(getPointsOfAll());

		for (Map.Entry<String, T> entry : map.entrySet()) {
			rankNations.add(entry.getKey());
		}
		return rankNations;
	}

	public List<String> getTop3() {
		List<String> top3 = new ArrayList<>();
		for (int i = 0; i < 3; ++i) {
			String nation = getRanking().get(i);
			top3.add(nation);
		}
		return top3;
	}

	public void printRankingToFile(String filename) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(filename);
		pw.flush();
		Map<String, T> sorted = new SortHashMapByValues<T>().sortByValues(getPointsOfAll());
		for (Map.Entry<String, T> entry : sorted.entrySet()) {
			pw.write(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		pw.close();
	}
}