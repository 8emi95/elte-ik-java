package city;

//alapból package private
//osztálynak és csomagnak is nyilvánosnak kell lennie
public class Person {
	String firstName;
	String lastName;
	int yearOfBirth;
	
	//objektumszintű: minden objektumhoz egy ilyen
	//osztályszintű: minden objektumnak egy közös	
	//boolean isUpperCase; //objektumszintű adattag
	static boolean isUpperCase; //osztályszintű adattag
	
	// !!!!! óraiban nincs benne !!!!!
	public Person(String firstName, String lastName, int yearOfBirth) { //konstruktornak nincs visszatérési értéke
		this.firstName = firstName; //kell a this VAGY paramétert átnevezzük (adattagot akarunk elérni)
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
	
	//lekérdezze milyen évben járunk
	public boolean isAdult(int year) { //lehet Person() vagy adattagok fölé is
		return (year - yearOfBirth) >= 18;
	}
	
	//ha toString nem public: main-be
	//Person p = ...;
	//System.out.println(p); -> kimenet: Person#c082g
	public String toString() {
		if (isUpperCase)
			return firstName.toUpperCase() + " " + lastName.toUpperCase();
		else
			return firstName + " " + lastName;
	}
	
	public static Person makePerson(String firstName, String lastName, int yearOfBirth) {
		if (!firstName.isEmpty() && !lastName.isEmpty() && 1900 <= yearOfBirth && yearOfBirth <= 2016) {
			Person p = new Person();
			
			p.firstName = firstName;
			p.lastName = lastName;
			p.yearOfBirth = yearOfBirth;

			return p;

			/* // másik konsit bennehagyva:
			Person p = new Person(first, last, year);
			*/
		} else {
			return null;
		}
	}
}

/* memóriában
Person
------
isUpperCase
toString()
isAdult()

***********************************************
(osztályszintű metódusnál nem lehet hozzáférni az objektumszintű adatokhoz)
p: Person				q: Person
---------				---------
firstName = "Roger"		firstName = "Rafael"
lastName = "Federer"	lastName = "Nadal"
yearOfBirth = 1980		yearOfBirth = 1980
*/