class Equals {
	public static String f() {
		return "alma";
	}
	
	public static String g() {
		return "al";
	}
	
	public static void main(String[] args) {
		System.out.println("alma" == "alma"); // true
		System.out.println("alma" == f()); // true
		System.out.println("alma" == ("al" + "ma")); // true
		System.out.println("alma" == (g() + "ma")); // false
	}
	
	/*
	equals(): jobb, mert...
	*/
}