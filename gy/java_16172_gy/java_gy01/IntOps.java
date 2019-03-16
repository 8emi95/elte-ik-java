/*import java.util.Scanner;*/

class IntOps {
	public static void main(String[] args) {
/*		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(a + " * " + b + " = " + (a * b));
		System.out.println(a + " / " + b + " = " + (a / b));
		System.out.println(a + " % " + b + " = " + (a % b));
		double aD = a;
		double d = aD / b;
		System.out.println(d);
	}*/

		System.out.println("Kerek ket egesz szamot!");
		int a = Integer.parseInt(System.console().readLine());
		int b = Integer.parseInt(System.console().readLine());
		System.out.println(a + " * " + b + " = " + a * b);
		if (b != 0) {
			System.out.println(a + " / " + b + " = " + a / b);
			System.out.println(a + " % " + b + " = " + a % b);
			System.out.println(a + " = " + b + " * " + a / b + " + " + a % b);
		}
}