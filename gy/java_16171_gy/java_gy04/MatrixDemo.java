import java.util.Arrays;
import math.Matrix;

class MatrixDemo {
	public static void main(String[] args) {
		int[][] a = {{1,2},{3,4}};
		int[][] b = {{0,2},{4,6}};
		int[][] c = Matrix.add(a, b);
		for (int row = 0; row < c.length; row++)
			System.out.println(Arrays.toString(c[row]));
	}
}