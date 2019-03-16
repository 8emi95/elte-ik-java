import java.util.*;

class Main {
	public static void printPerson(Person p) {
		System.out.printn(p);
	}

	public static void main(String[] args) {
		Person p = new Person("Fernando", "Rio");
		System.out.println(p);
		p.becomeCEO();
		System.out.println(p);

		List<Integer> grades = new ArrayList<>();
		grades.add(4);
		grades.add(5);
		Student s = new Student("Pisti", "Szeged", grades);
		System.out.println(s);
		s.raise();
		System.out.println(s);
		s.becomeCEO();
		System.out.println(s);

		printPerson(p);
		printPerson(new Student("Bela", "Pecs", grades));

		Person p2 = new Student("Bela", "Pecs", grades);
	}
}