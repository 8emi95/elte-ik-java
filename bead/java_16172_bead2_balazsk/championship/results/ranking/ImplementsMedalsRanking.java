package championship.results.ranking;

import championship.results.ImplementsResults;
import championship.results.Result;
import championship.results.Results;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class ImplementsMedalsRanking extends AbstractRanking<Medals> {

    private ImplementsResults results;

    public ImplementsMedalsRanking(ImplementsResults result) {
        this.results = result;
    }

    public Medals getPointsOf(String nation){
		int gold = 0;
		int silver = 0;
		int bronz = 0;
		for(Result r : results.getList()){
			if(r.getNation().equals(nation)){
                switch (r.getPlace()) {
                    case 1:
                        gold++;
                        break;
                    case 2:
                        silver++;
                        break;
                    case 3:
                        bronz++;
                        break;
                    default:
                        break;
                    }
			}
        }
		Medals m = new ImplementsMedals(gold, silver, bronz);
		return m;
	}
	
	public Map<String, Medals> getPointsOfAll(){
                Map<String, Medals> map = new HashMap<>();
		for(Result r : results.getList()){
			String nation = r.getNation();
			map.put(nation, getPointsOf(nation));
		}
		return map;
	}
	
	public List<String> getRanking(){
        List<String> nationNames = new ArrayList<>();
        Map<String, Medals> map = new MapSorterUtil<Medals>().sortMap(getPointsOfAll());
        for (Map.Entry<String, Medals> entry : map.entrySet()){
            nationNames.add(entry.getKey());
        }
		return nationNames;
	}
}
	