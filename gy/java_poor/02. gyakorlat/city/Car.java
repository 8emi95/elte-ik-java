package city;

public class Car {
    String licenceNumber;
    int doors;
    Person owner;

    public Car(String licenceNumber_, int doors_, Person owner_) {
        licenceNumber = licenceNumber_;
        doors = doors_;
        owner = owner_;
    }

    public boolean isValid() {
        return !licenceNumber.isEmpty()
            && (doors == 3 || doors == 5)
            && (owner != null)
            && (owner.isAdult(2016));
    }

    public String toString() {
        return licenceNumber + " " + doors + " doors, owner: "
            + owner.toString();
    }
}
