//2. Készítsünk a util csomagon belül egy IntVector osztályt, mely egészek sorozatát ábrázolja!
//a) Legyen egy tömb adattag, mely a sorozatot tárolja. Tegyük rejtetté!
//b) Adjunk az osztályhoz egy konstruktort, mely egy egészekből álló tömböt vár paraméterül! Ügyeljünk, hogy a belső állapotot ne szivárogtassuk ki!
//c) Vegyünk fel egy add() metódust, mely a sorozat minden eleméhez hozzáad egy paraméterül kapott egész számot!
//d) Írjunk egy toString() metódust is, mely felsorolja a számokat szóközzel elválasztva. Például: [1 2 3]

package util;
import java.util.Arrays;

public class IntVector {
	private int[] ns;

	public IntVector(int[] t) {
		// ns = t;	// ROSSZ - ns és t referencia ugyanarra a tömb objektumra a heapen
		ns = Arrays.copyOf(t, t.length); // ns és t két különböző tömbre mutat, ns tömb a t tömb pontos másolata
		//nem metódus, nem kell ()
	}

	public void add(int m) {
		for (int i = 0; i < ns.length; i++)
			ns[i] += m;
	}

	public String toString() {
		return Arrays.toString(ns);
	}
}