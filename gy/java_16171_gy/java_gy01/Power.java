/* CIKLUSSAL
2 szam (a, b) argumentum, kiszamolja a^b-t
kitevo nem lehet negativ
*/

class Power {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = 1;
		for (int i = 0; i < b; i++) {
			c = c * a;
		}
		System.out.println(c);
	}
}