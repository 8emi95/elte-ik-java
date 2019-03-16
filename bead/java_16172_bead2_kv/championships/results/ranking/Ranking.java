package championships.results.ranking;

import java.util.*;
import java.io.*;
import championships.results.*;

public abstract class Ranking<T extends Comparable<T>> implements Rankings<T>{ // Ranking = RankingAbstract
	public Set<String> getNations() {
		ResultFinal res=new ResultFinal(); // ResultFinal = ResultsImpl
		Set<String> nations=new HashSet<>();
		for (ResultFinal.Result r: res.getResults()) { // getResults = getList
			String nation=r.getParticipant().getNation(); // getPrticipant = ResultImpl.Result.getParticipant
			nations.add(nation);
		}
		return nations;
	}
	
	@Override
	abstract public T getPointsOf(String nation);
	
	@Override
	abstract public Map<String, T> getPointsOfAll();
	
	@Override
	public List<String> getRanking() {
		List<String> rankNations = new ArrayList<>();
		Map<String, T> map = new MapSorting<T>().sortByValues(getPointsOfAll());
        for (Map.Entry<String, T> entry : map.entrySet()){
            rankNations.add(entry.getKey());
        }
        return rankNations;
	}
	
	@Override
	public List<String> getTop3(){
        List<String> top = new ArrayList<>();
		for (int i=0; i<3; i++){
			String nation=getRanking().get(i);
			top.add(nation);
		}
		return top;
	}
	
	@Override
	public void printRankingToFile(String filename) throws FileNotFoundException {
		PrintWriter pw=new PrintWriter(filename);
		pw.flush();
		Map<String, T> sorted=new MapSorting<T>().sortByValues(getPointsOfAll());
		for (Map.Entry<String, T> entry : sorted.entrySet()) {
			pw.println(entry.getKey()+": "+entry.getValue());
		}
		pw.close();
	}
}