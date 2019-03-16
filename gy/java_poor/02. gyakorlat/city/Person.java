package city;

public class Person {
    String firstName;
    String lastName;
    int yearOfBirth;

    static boolean isUpperCase;

    public boolean isAdult(int year) {
        return (year - yearOfBirth) >= 18;
    }

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
        } else {
            return null;
        }
    }

}
