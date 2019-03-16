//city-be átpakolva Person-t Car-t megváltozik az osztály neve
//city.Person city.Car VAGY import city.Car; import city.Person;
import city.*;

class Main {
	public static void main(String[] args) {
		//Person p = new Person("Roger", "Federer", 1980);
		//Person q = new Person("Rafael", "Nadal", 1980);
		
		Person p = new Person.makePerson("Roger", "Federer", 1980);
		Person q = new Person.makePerson("Rafael", "Nadal", 1980);
		
		Car c = new Car("ABC-242", 5, p);
		Car c2 = new Car("CDE-424", 3, null); // null -> q
		
		//Person.isUpperCase() = true;
		System.out.println(p);
		System.out.println(q);
		
		System.out.println(c);
		System.out.println(c2);
	}
}