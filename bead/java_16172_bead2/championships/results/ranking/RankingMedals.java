package championships.results.ranking;

import championships.results.Results;
import championships.results.ResultsImpl;
import championships.results.ranking.RankingAbstract;

import java.util.*;

public class RankingMedals extends RankingAbstract<Medals> {
	public RankingMedals(ResultsImpl resultList) {
		this.resultList = resultList;
	}

	@Override public Medals getPointsOf(String nation) {
		int golds = 0;
		int silvers = 0;
		int bronzes = 0;

		for (int i = 0; i < resultList.getList().size(); i++) {
			if (nation.equals(resultList.getList().get(i).getResultNation())) {
				if (resultList.getList().get(i).getResultPlace() == 1) {
					golds++;
				} else if (resultList.getList().get(i).getResultPlace() == 2) {
					silvers++;
				} else if (resultList.getList().get(i).getResultPlace() == 3) {
					bronzes++;
				}
			}
		}

		Medals medals = new MedalsImpl(golds, silvers, bronzes);
		return medals;
	}

	@Override public Map<String, Medals> getPointsOfAll() {
		Map<String, Medals> pointsAll = new HashMap<>();
		for (ResultsImpl.Result r : resultList.getList()) {
			String nation = r.getResultNation();
			pointsAll.put(nation, getPointsOf(nation));
		}
		return pointsAll;
	}
}