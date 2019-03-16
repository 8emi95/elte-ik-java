package championship.results.ranking;

import championship.results.ImplementsResults;
import championship.results.Result;
import championship.results.Results;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractRanking<T extends Comparable <T> > implements Ranking<T> {
    
	@Override
	public Set<String> getNations(){
        Results mr = new ImplementsResults(); // ImplementsResults = ResultsImpl
        Set<String> nations = new HashSet<>();
        for(Result r : mr.getList()){ // Result = ResultsIpml.Result (ő külön fájlba írta, én ResultsImpl-be)
            String nation = r.getNation();
            nations.add(nation);
        }
        return nations;
	}

	public List<String> getTop3(){
            List<String> top3 = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                String nation = getRanking().get(i);
                top3.add(nation);
            }
            return top3;
	}
        
	public void printRankingToFile(String filename) throws FileNotFoundException {
        PrintWriter pr = new PrintWriter(filename);
        pr.flush();
        Map<String,T> sortedMap = new MapSorterUtil<T>().sortMap(getPointsOfAll());
        for (Map.Entry<String, T> e: sortedMap.entrySet()){
            pr.write(e.getKey()+": "+ e.getValue() + '\n');
        }
        pr.close();
	}
        
        public abstract T  getPointsOf(String nation);
        public abstract Map<String, T> getPointsOfAll();
        public abstract List<String> getRanking();

}