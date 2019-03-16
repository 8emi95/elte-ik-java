import util.*;

class IntVectorDemo {
	public static void main(String[] args) {
		IntVector v = new IntVector(new int[] {1, 2, 3});
		v.add(1);
		System.out.println(v);
		System.out.println(new int[] {1,2,3});

		int[] ns = new int[] {1,2,3};
		IntVector v2 = new IntVector(ns);
		System.out.println(v);
		ns[0] = 10;             // v tartalma nem változik, mert az IntVector konstruktora copyOf()-fal másolt 
		System.out.println(v);
	}
}