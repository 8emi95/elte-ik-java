A következő futtatásra:

		Results results = ...
		results.readFromFile("input.txt");
		results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
		results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");

ahol a results egy megvalósító osztály egy példánya, az elkészült fájloknak a megfelelő
_mo fájl tartalmával karakterre egyező eredményt kell adniuk.

(A feladat szövege kimondja, hogy egyező pontszámú nemzetek között a rangsor tetszőleges.
A mintában szándékosan nincs egyik rangsorolás szerint se egyezés, hogy a kimenet egyértelmű
legyen.)




***************************************************************************************

	public List<Result> getList() {
/*		List<Result> copy = new ArrayList<Result>(resultList);
		return copy;*/
/*
https://stackoverflow.com/questions/14319732/how-to-copy-a-java-util-list-into-another-java-util-list
Note: still not thread safe, if you modify [resultList] from another thread, then you may want to make that [resultList] (and even [copy]) a CopyOnWriteArrayList, for instance -- or use a lock primitive, such as ReentrantReadWriteLock to serialize read/write access to whatever lists are concurrently accessed.
*/

		return (ArrayList<Result>) ((ArrayList<Result>) resultList).clone(); // object
		// return (ArrayList) ((ArrayList) resultList).clone(); // arraylist

	}

/*	public static List<Result> cloneList(List<Result> resultList) { // fucking pm
		List<Result> clone = new ArrayList<Result>(resultList.size());
		for (Result item : resultList) {
			clone.add(item.clone());
		}
		return clone;
	}*/

// deep copy
/*	private List<Result> resultList = new ArrayList<>();
	private List<Result> resultListCopy = new Arraylist<>();
	for (Result t : resultList) {
		Result copy = deepCopy(t);
		resultListCopy.add(copy);
	}
	public List<Result> deepCopy(ArrayList input) {
		List<Result> copy = new ArrayList<>();
		copy.setValue(input.getValue());
		return copy;
	}*/