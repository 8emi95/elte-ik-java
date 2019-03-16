public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		if (args.length != 1) {
			throw new RuntimeException("args.length != 1");
		}
		String name = args[0];
		System.out.println("Hello " + name);
	}
}
