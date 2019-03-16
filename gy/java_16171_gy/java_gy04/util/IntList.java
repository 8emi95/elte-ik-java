package util;
import java.util.Arrays;

public class IntList {
	private int[] ns;

	public IntList() {
		ns = new int[0];
	}

	public IntList(IntList list) { // copy constructor
		// ns = list.ns; // ROSSZ (ns referencia ugyanarra mutat a heapen mint a this.ns)
		ns = Arrays.copyOf(list.ns, list.ns.length); // lemásolja a tömböt, 2 pm: tömb és hossza
	}

	public int get() {
		return ns[0];
		// return get(0);
	}

	public int get(int index) {
		return ns[index];
	}

	public void add(int elem) {
		// megnövelés előtt indexek: [1..ns.length] NAAAAAAAAH
		// indexek: [0..ns.length - 1]
		ns = Arrays.copyOf(ns, ns.length + 1);
		// megnövelés után: [1..régiNs.length] NAAAAAAAAAAH
		ns[ns.length - 1] = elem;
	}

	public int size() {
		return ns.length;
	}
}