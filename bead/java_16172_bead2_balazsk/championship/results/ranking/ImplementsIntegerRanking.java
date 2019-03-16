package championship.results.ranking;

import championship.results.ImplementsResults;
import championship.results.Result;
import championship.results.Results;

import java.util.*;

public class ImplementsIntegerRanking extends AbstractRanking<Integer> {

    private ImplementsResults results;

    public ImplementsIntegerRanking(ImplementsResults result) {
        this.results = result;
    }

	public Integer getPointsOf(String nation){
        int point = 0;
        for(Result r : results.getList()){
            if(r.getNation().equals(nation)){
                point++;
            }
        }
        return point;
	}
	
	public Map<String, Integer> getPointsOfAll(){
        Map<String, Integer> map = new HashMap<>();
        for(Result r : results.getList()){
            String nation = r.getNation();
            map.put(nation, getPointsOf(nation));
        }
        return map;
	}
	
	public List<String> getRanking(){
        List<String> nationNames = new ArrayList<>();
        Map<String, Integer> map = new MapSorterUtil<Integer>().sortMap(getPointsOfAll());
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            nationNames.add(entry.getKey());
        }
        return nationNames;
	}

}