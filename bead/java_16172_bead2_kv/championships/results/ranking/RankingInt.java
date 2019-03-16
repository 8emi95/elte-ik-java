package championships.results.ranking;

import championships.results.*;

import java.util.*;

public class RankingInt extends Ranking<Integer>{
	private ResultFinal results;

	public RankingInt(ResultFinal results) {
		this.results=results;
	}

	@Override
	public Integer getPointsOf(String nation) {
		Integer points=0;
		for (int i=0; i<results.getResults().size(); i++) {
			ResultFinal.Result r=results.getResults().get(i);
			if (nation.equals(r.getParticipant().getNation())) {
				int place=r.getPlace();
				if (place==1 || place==2 || place==3) {
					points++;
				}
			}
		}
		return points;
	}
	
	@Override
	public Map<String, Integer> getPointsOfAll(){
		Map<String, Integer> map=new HashMap<>();
        for (ResultFinal.Result r : results.getResults()){
            String nation=r.getParticipant().getNation();
            map.put(nation, getPointsOf(nation));
        }
        return map;
	}
}