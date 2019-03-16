import math.Matrix;
import java.util.Arrays;

class MatrixDemo {
    public static void main(String[] args){
	/*
	int[][] a = new int[2][2];
	a[0][0] = 1;
	a[0][1] = 2;
	a[1][0] = 3;
	a[1][1] = 4;
	*/
	int[][] a = new int[][] { {1,2}, {3,4} };
	int[][] b = new int[][] { {5,6}, {7,8} };

	int[][] c = Matrix.plus(a, b);
	
	for (int row = 0; row < c.length; row++)
	    System.out.println(Arrays.toString(c[row]));
    }
}
