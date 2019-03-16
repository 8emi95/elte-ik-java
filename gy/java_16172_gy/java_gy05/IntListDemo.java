import util.IntList;

class IntListDemo {
	public static void main(String[] args) {
		IntList ns1 = new IntList();
		IntList ns2 = new IntList(new int[] {1, 2, 3, 5}); // túlterhelés

		System.out.println(ns2.get());
		System.out.println(ns2.get(2)); // fordító ki tudja találni híváskor h melyik get kell
	}
}