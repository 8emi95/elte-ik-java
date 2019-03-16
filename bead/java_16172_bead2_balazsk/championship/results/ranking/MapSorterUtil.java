package championship.results.ranking;

import java.util.*;

public class MapSorterUtil<T extends Comparable<T>> {

    public Map<String, T> sortMap(Map<String, T> map){
        List<Map.Entry<String, T>> list = new LinkedList<Map.Entry<String, T>>( map.entrySet());
        Collections.sort( list, (o1, o2) -> (o2.getValue()).compareTo( o1.getValue()));
        Map<String, T> result = new LinkedHashMap<String, T>();
        for (Map.Entry<String, T> entry : list) {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }
}
