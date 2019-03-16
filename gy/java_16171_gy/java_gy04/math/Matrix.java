package math;

public class Matrix {
	public static int[][] add(int[][] a, int[][] b) { // static osztályszintű
		int[][] c = new int[a.length][]; // 1. = sorok; 2. = oszlopok
		int numCols = a[0].length;
		for (int row = 0; row < a.length; row++) {
			c[row] = new int[numCols]; // a első sorának a hossza az oszlopok száma

			for (int col = 0; col < numCols; col++) {
				c[row][col] = a[row][col] + b[row][col];
			}
		}
		return c;
	}
}