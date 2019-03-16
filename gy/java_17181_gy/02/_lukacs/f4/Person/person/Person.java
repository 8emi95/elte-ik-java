package person;

//Személyek osztálya

public class Person{
	private String lname;      // vezetéknév
	private String fname;      // keresztnév
	private String occupation; // foglalkozás
	private int gender;	       // nem
	private int birthYear;

	public static Person makePerson(String lname, String fname, String occupation, int gender, int birthYear) {
		if ((1900 <= birthYear) && (birthYear <= 2017)) {
			Person p = new Person();
			p.lname  = lname;
			p.fname = fname;
			p.occupation = occupation;
			p.gender    = gender;
			p.birthYear = birthYear;
			return p;
		}
		return null;
	}

	public boolean equals(Person p) {
		return (p != null) && (p.lname.equals(lname)) && (p.fname.equals(fname)) && (p.occupation.equals(occupation)) && (p.gender == gender) && (p.birthYear == birthYear);
	}
	
	public String toString() {
		return fname +" "+ lname +" "+ occupation +" "+ gender +" "+ birthYear;
    }

}