package math;

public class Matrix {
    public static int[][] plus(int[][] a, int[][] b) {
	int rows = a.length;
	int cols = a[0].length;
	int[][] c = new int[rows][];
	for (int i = 0; i < rows; i++)
	    c[i] = new int[cols];
	for (int row = 0; row < rows; row++) {
	    for (int col = 0; col < cols; col++) {
		c[row][col] = a[row][col] + b[row][col];
	    }
	}
	return c;
    }
} 
