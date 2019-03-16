/*
szam -> szoveg
int n = 2;
String s = "" + n; s -> "2"
           n + ""
		   2 + "ja"
		   "ulok" + n + "fa alatt"
String s = "15";
int n = Integer.parseInt(s);
    n == 15;
*/
class IntOps {
	public static void main(String[] args) {
		System.out.println("Kerek ket egesz szamot!");
		int a = Integer.parseInt(System.console().readLine());
		int b = Integer.parseInt(System.console().readLine());
		System.out.println(a + " * " + b + " = " + a*b);
		if (b != 0) { //0-val ne osszunk
			System.out.println(a + " / " + b + " = " + a / b);
			System.out.println(a + " % " + b + " = " + a % b);
			System.out.println(a + " = " + b + " * " + a / b + " + " + a % b);
		}
	}
}