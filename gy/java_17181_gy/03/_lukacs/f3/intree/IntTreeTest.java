import utils.IntTree;
import java.util.Arrays;

public class IntTreeTest {

	public static void main(String[] args) {
		IntTree t = new IntTree(5);
		System.out.println(t);
		for (int i=1; i<=4;i++){
			t.insert(i);
			System.out.println(t);
		}
		System.out.println("t = " + t);
		System.out.println("t.contains(8) ?= " + t.contains(8));
		System.out.println("t.contains(1) ?= " + t.contains(1));
		int[] a = new int[] { 5, 4, 6, 3, 1 };
		IntTree s = new IntTree(a);
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + s);
		System.out.println("t.equalsTo(s) ?= " + t.equalsTo(s));
		int[] b = new int[] { 4, 1, 6, 3, 5 };
		IntTree u = new IntTree(b);
		System.out.println("b = " + Arrays.toString(b));
		System.out.println("u = " + u);
		System.out.println("t.equalsTo(u) ?= " + t.equalsTo(u));
	}
}