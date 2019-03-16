//1. Fibonacci első n eleme, n értéke argumentum
//a) A sorozat első nn elemét tároljuk le egy tömbben, majd egy külön iterációban irassuk ki az elemeket!

class FibonacciA {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); //ha téll szám akk visszakapjuk a számot, ha nem akk exceptiont
		int[] fibs = new int[n]; //n hosszú tömb amiben elemeket tároljuk

		//első 2 elem megadása, Fib -> (n-2) + (n-1)
		fibs[0] = 0;
		fibs[1] = 1;

		// n=5  [0..n-1]
		for (int i = 2; i < n; ++i) {
			fibs[i] = fibs[i-1] + fibs[i-2];
		}

		//System.out.println(fibs); //[I@15db9742 - n=5
		for (int a : fibs) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}