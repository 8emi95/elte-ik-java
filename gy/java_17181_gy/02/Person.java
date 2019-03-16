public class Person {
    String firstName;
    String lastName;
    String job;
    Gender gender;
    int yearOfBirth;

    public static Person makePerson(String firstName, String lastName, String job, Gender gender, int yearOfBirth) {
        if (yearOfBirth < 1900 || 2017 < yearOfBirth) {
            return null;
        } else {
            return Person(firstName, lastName, job, gender, yearOfBirth);
        }
    }

    public String toString() {
        return "nev: " + firstName + " " + lastName + ", foglalkozas: " + job + ", nem: " + gender + ", szuletesi ev: " + yearOfBirth;
    }

    public boolean equals(Person other) {
        if (other == null) {
            //
        }
    }
}