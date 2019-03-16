import java.util.*;

class Student extends Person {
    private List<Integer> courses;
    //private List<int> courses;     // NEM JÓ!

    public Student(String name, String address, List<Integer> courses) {
	super(name, address);    // Legelső dolog: meghívni a szülő konstruktorát
	this.courses = new ArrayList<>();
	this.courses.addAll(courses);
    }

    @Override
    public String toString() {
	return "Student: " + super.toString();
    }

    @Override
    public void raise() {
	wage += 20000;
    }
}
