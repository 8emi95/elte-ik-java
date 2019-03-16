public class Test {
	public static void main(String[] args) {
		String x = " Simon Marlow , Parallel and Concurrent Programming in Haskell , O'Reilly , 2013 ";
		String y[] = x.trim().split("\\s*,\\s*");
		for (int i = 0; i < y.length; ++i)
			System.out.println(y[i] + ":");
	}
}