import util.IntList;

class IntListDemo {
	public static void main(String[] args) {
		IntList list = new IntList();
		list.add(0);
		list.add(2);
		list.add(4);

		System.out.println(list.get());
		System.out.println(list.get(2));
		
		IntList list2 = new IntList(list);  // list2 és list független

		list.add(6);
		
		System.out.println(list.size());	// 4
		System.out.println(list2.size());   // 3
	}
}