/*
1. Írjunk egy math.Matrix osztályt, melyben néhány mátrixműveletet valósítunk meg! Ezek az alábbiak:
a) A plus() osztályszintű metódus paraméterül vár két kétdimenziós tömböt, melyeket összeadja. Az eredményt egy harmadik tömbben adja vissza.
Az A és a B mátrix C összegét megkapjuk a C_ij=∑_k=0..n(A_ik x B_kj) kiszámításával minden i, j-re.
*/

package math;

public class Matrix {
	public static int[][] plus(int[][] a, int[][] b) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] c = new int[rows][];
		for (int i = 0; i < rows; i++) {
			c[i] = new int[cols];
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				c[row][col] = a[row][col] + b[row][col];
			}
		}
		return c;
	}
}