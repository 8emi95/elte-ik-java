class Power {
	public static void main(String[] args) {
		// b nemnegativ
/*		if (args.length > 1) {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int p = 1;
			for (int i = 0; i < b; ++i) {
				p *= a;
			}
			System.out.println(p);
		}*/

		// b lehet negativ ------------ NEM JÓ
/*		if (args.length > 1) {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int p = 1;
			int bAbs = Math.abs(b);

			for (int i = 0; i < bAbs; ++i) {
				p *= a;
			}

			if (b < 0) {
				System.out.println(1.0/p);
			} else {
				System.out.println(p);
			}
		}*/

		// Csak pozitív kitevőt kezel.
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = 1;
		for (int i = 0; i < b; i++) {
			c = c * a;
		}
		System.out.println(c);
	}
	}
}