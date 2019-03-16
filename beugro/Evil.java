public class Evil {
	public String identity(String s) {
		return s;
	}
	static String identity(Object o) {
		return "bad";
	}
	public static void main(String[] args) {
		// Object good = "good";
		String good = "good";
		System.out.println(new Evil().identity(good));
	}
}