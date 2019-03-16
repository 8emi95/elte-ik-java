package util;

import java.util.Arrays;

public class IntList {
    private int[] ns;

    public IntList() {
	ns = new int[0]; // ns = null;
    }

    public IntList(int[] numbers) {
	ns = Arrays.copyOf(numbers, numbers.length);
    }

    public int get() {
	return ns[0];
    }

    public int get(int index) {
	return ns[index];
    }
}
