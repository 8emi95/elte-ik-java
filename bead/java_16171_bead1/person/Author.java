package person;
import java.lang.Character;

public class Author {
	private String lastName;
	private String firstName;

	private Author(String lastName, String firstName) {
		if (lastName == null) throw new IllegalArgumentException("...");
		if (firstName == null) throw new IllegalArgumentException("...");
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public static Author make(String name) {
		String[] splitted = name.split("\\s+");
		if (   splitted.length > 1 
			&& name.length() > 0 
			&& !name.isEmpty() 
			&& splitted[0].length() > 0 
			&& splitted[1].length() > 0 
			&& Character.isUpperCase(splitted[0].charAt(0)) 
			&& Character.isUpperCase(splitted[1].charAt(0))) {
			Author a = new Author(splitted[1], splitted[0]);
			return a;
		}
		else {
			return null;
		}
	}

	public String getLastName() { return lastName; }
	public String getFirstName() { return firstName; }

	public Author(Author author) {
		if (author == null) {
			this.lastName = "";
			this.firstName = "";
		}
		else {
			this.lastName = author.lastName;
			this.firstName = author.firstName;
		}
	}

	public boolean equals(Author other) {
		if (this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String show() {
		return (lastName + ", " + firstName.substring(0, 1));
	}
}