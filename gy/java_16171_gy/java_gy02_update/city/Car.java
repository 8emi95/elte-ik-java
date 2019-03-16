//city könyvtárban fordítva nem találja a Persont (city mappát keres, de abban vagyunk), munkakönyvtárban meg kell adni az útvonalat
//javac city\Car.java
package city;

public class Car {
	String licenceNumber;
	int doors;
	Person owner; //mutató, egy Person objektumra a memóriában, ha nem mutat sehová akk null
	//NullPointerException

	public Car(String licenceNumber_, int doors_, Person owner_) {
		licenceNumber = licenceNumber_; //amit kap pm-ül azt beállítja az obj adattagjainak
		doors = doors_;
		owner = owner_;
	}

	public boolean isValid() { //nem vár pm-t
		return !licenceNumber.isEmpty()
			&& (doors == 3 || doors == 5)
			&& (owner != null)
			&& (owner.isAdult(2016)); //át kell írni később...
	}

	public String toString() {
		return licenceNumber + " " + doors + " doors, owner: " + owner; // !!!!! toString() óraiban !!!!!
		//owner.toString(); -> null referenciát nem lehet használni, nem lehet elérni semmit benne
	}
}