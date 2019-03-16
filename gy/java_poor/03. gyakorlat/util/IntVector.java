package util;
import java.util.Arrays;

public class IntVector {
    private int[] ns; // null

    public IntVector(int[] numbers) {
	// 1.
	ns = new int[numbers.length];
	for (int i = 0; i < ns.length; i++)
	    ns[i] = numbers[i];

	// 2.
	ns = Arrays.copyOf(numbers, numbers.length); // ns és t két különböző tömbre mutat, ns tömb a t tömb pontos másolata

	// 3.
	// ns = numbers; // ROSSZ - ns és t referencia ugyanarra a tömb objektumra a heapen
    }

    public void add(int n) {
	for (int i = 0; i < ns.length; i++)
	    ns[i] += n;
    }

    public String toString() {
	return Arrays.toString(ns);
    }
}
