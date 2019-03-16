public class X{
	
	public static void main(String[] args){
		int[] t = {1,2};
		int[][]m = {t,t};
		m[0][0] = 0;
		System.out.print(m[0][0]);
		System.out.print(m[0][1]);
		System.out.print(m[1][0]);
		System.out.print(m[1][1]);
		
	}
	
}