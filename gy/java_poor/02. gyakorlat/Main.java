import city.*;

class Main {
    public static void main(String[] args) {
        Person p = Person.makePerson("Roger", "Federer", 1981);
        Person q = Person.makePerson("Rafael", "Nadal", 1986);
        Car c = new Car("ABC-242", 5, p);
        Car c2 = new Car("CDE-424", 3, q);
        // Person.isUpperCase = true;
        System.out.println(p);
        System.out.println(q);
        System.out.println(c);
        System.out.println(c2);
    }
}
