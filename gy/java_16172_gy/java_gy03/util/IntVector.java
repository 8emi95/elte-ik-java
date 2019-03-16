/*
2. Készítsünk a util csomagon belül egy IntVector osztályt, mely egészek sorozatát ábrázolja!
a) Legyen egy tömb adattag, mely a sorozatot tárolja. Tegyük rejtetté!

b) Adjunk az osztályhoz egy konstruktort, mely egy egészekből álló tömböt vár paraméterül! Ügyeljünk, hogy a belső állapotot ne szivárogtassuk ki!

c) Vegyünk fel egy add() metódust, mely a sorozat minden eleméhez hozzáad egy paraméterül kapott egész számot!

d) Írjunk egy toString() metódust is, mely felsorolja a számokat szóközzel elválasztva. Például:  [1 2 3]
*/

package util;

import java.util.Arrays;

public class IntVector {
	private int[] ns; // inicializálni kell kül nullreferencia

	public IntVector(int[] numbers) {
		// 1.
		ns = new int[numbers.length];
		for (int i = 0; i < ns.length; i++) {
			ns[i] = numbers[i];
		}

		// 2.
		ns = Arrays.copyOf(numbers, numbers.length); // ns és t két különböző tömbre mutat, ns tömb a t tömb pontos másolata

		// 3.
		// ns = numbers; // ROSSZ - ns és t referencia ugyanarra a tömb objektumra a heapen
	}

	public void add(int n) {
		for (int i = 0; i < ns.length; i++) {
			ns[i] += n;
		}
	}

	public String toString() {
		return Arrays.toString(ns);
	}
}