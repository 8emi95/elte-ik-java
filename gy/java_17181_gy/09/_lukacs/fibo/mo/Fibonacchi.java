public class Fibonacchi {

	public static long iterative(int n) {
		long curr = 0;
		long prev = 1;
		for (int i = 0; i < n; ++i) {
			long next = curr + prev;
			prev = curr;
			curr = next;
		}
		return curr;
	}
	
	public static long recursive(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return recursive(n - 2) + recursive(n - 1);
	}
	
}
