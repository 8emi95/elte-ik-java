// package javagy1;

import java.util.Scanner;

public class ParityChecker {
	public static void main(String[] args) {
//		String name = System.console().readLine();

		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		
		System.out.println("Hello" + name);
		
		int number;
		do {
			System.out.println("Kérek egy számot 1 és 10 között!");
			while (!sc.hasNextInt()) {
				System.out.println("Nem számot kaptam");
				String bad = sc.next();
			}
			number = sc.nextInt();
		} while (!(1 <= number && number <= 10));
		
		for (int i = 0; i < number; ++i) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
/*		if (number == 0) {
			System.out.println("A szám nulla");
		} else if (number % 2 == 0) {
			System.out.println("Páros");
		} else {
			System.out.println("Páratlan");
		}
		
		switch (number % 2) {
			case 0:
				System.out.println("Páros");
				break;
			case 1:
				System.out.println("Páratlan");
		}
*/		
		System.out.println(number % 2 == 0 ? "Páros" : "Páratlan");
	}
}
