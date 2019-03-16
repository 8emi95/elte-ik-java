package championships.results.ranking;

import championships.results.Results;
import championships.results.ResultsImpl;
import championships.results.ranking.RankingAbstract;

import java.util.*;

public class RankingInteger extends RankingAbstract<Integer> {
	public RankingInteger(ResultsImpl resultList) {
		this.resultList = resultList;
	}

	@Override public Integer getPointsOf(String nation) {
		Integer points = 0;
		for (int i = 0; i < resultList.getList().size(); i++) {
			if (nation.equals(resultList.getList().get(i).getResultNation())) {
				if (resultList.getList().get(i).getResultPlace() == 1) {
					points++;
				} else if (resultList.getList().get(i).getResultPlace() == 2) {
					points++;
				} else if (resultList.getList().get(i).getResultPlace() == 3) {
					points++;
				}
			}
		}
		return points;
	}

	@Override public Map<String, Integer> getPointsOfAll() {
		Map<String, Integer> pointsAll = new HashMap<>();
		for (ResultsImpl.Result r : resultList.getList()) {
			String nation = r.getResultNation();
			pointsAll.put(nation, getPointsOf(nation));
		}
		return pointsAll;
	}
}