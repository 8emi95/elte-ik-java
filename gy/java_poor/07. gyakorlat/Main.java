import java.util.*;

class Main {
    // Meghívható Personnel és leszármazottaival
    public static void printPerson(Person p) {
	System.out.println(p);
    }
    
    public static void main(String[] args) {
	Person p = new Person("Fernando", "Rio");
	System.out.println(p);
	p.becomeCEO();         // a fizetés 15000-rel nő
	System.out.println(p);

	List<Integer> grades = new ArrayList<>();
	grades.add(4);
	grades.add(5);
	Student s = new Student("Pisti", "Szeged", grades);
	System.out.println(s);
	s.raise();              // a fizetés 20000-rel nő
	System.out.println(s);
	s.becomeCEO();          // a fizetés 60000-rel nő
	System.out.println(s);

	printPerson(p);
	printPerson(new Student("Bela", "Pecs", grades));
	
	
	Person p2 = new Student("Bela", "Pecs", grades);
    }
}
