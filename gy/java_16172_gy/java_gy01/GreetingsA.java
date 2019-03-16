/*import java.util.Scanner;*/

class GreetingsA {
	public static void main(String[] args) { // eddig a legegyszerűbb java progi ami lefordul
/*		System.out.println("Szia!");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		System.out.println("Udv, " + name);*/

		System.out.println("Szia! Hogy hivnak?");
		String name = System.console().readLine();
		System.out.println("Udv " + name + ", miujsag?");
	}
}