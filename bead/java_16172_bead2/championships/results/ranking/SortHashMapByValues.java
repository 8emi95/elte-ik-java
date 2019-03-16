package championships.results.ranking;

import java.util.*;

public class SortHashMapByValues<T extends Comparable<T>> {
	public Map<String, T> sortByValues(Map<String, T> map) {
		List<Map.Entry<String, T>> list = new LinkedList<Map.Entry<String, T>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, T>>() {
			public int compare(Map.Entry<String, T> o1, Map.Entry<String, T> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		Map<String, T> sortedHashMap = new LinkedHashMap<String, T>();
		for (Map.Entry<String, T> entry : list) {
			sortedHashMap.put( entry.getKey(), entry.getValue() );
		}
		return sortedHashMap;
	}
}