//3. Készítsünk egy Calculator programot, mely egy számsorozatot és egy számot kap argumentumként. A program a számsorozat minden eleméhez hozzáadja a második argumentumot. Például:
//$ java Calculator 1,2,3 5
//[6 7 8]
//Használjuk az előbb megírt util.IntVector osztályt!

import util.IntVector;

class Calculator {
	public static void main(String[] args) {
		String xs = args[0];			//"1,2,3"
		String x = args[1];				//"5"
		String[] ys = xs.split(",");	//"1" "2" "3"
		int[] ns = new int[ys.length];
		for (int i = 0; i < ns.length; i++) {
			ns[i] = Integer.parseInt(ys[i]); // ns == 1 2 3
		}
		IntVector v = new IntVector(ns);
		//v.add(Integer.parseInt(x)); ?
		System.out.println(v);
		ns[0] = 10; // v tartalma nem változik, mert az IntVector konstruktora copyOf()-fal másolt
		System.out.println(v);
	}
}