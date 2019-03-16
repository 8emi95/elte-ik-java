package championships.results.ranking;

import championships.results.*;

import java.util.*;

public class RankingMed extends Ranking<Medals> {
	private ResultFinal results;

	public RankingMed(ResultFinal results) {
		this.results=results;
	}

	@Override
	public Medals getPointsOf(String nation) {
		return new Medal(nation, results.getResults());
	}
	
	@Override
	public Map<String, Medals> getPointsOfAll(){
		Map<String, Medals> map=new HashMap<>();
        for (ResultFinal.Result r : results.getResults()){
            String nation=r.getParticipant().getNation();
            map.put(nation, getPointsOf(nation));
        }
        return map;
	}
}