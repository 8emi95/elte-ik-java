/*
1. Hozzuk létre a Person nevű osztályt, mely egy személyt fog ábrázolni! Minden személynek van neve, és címe (két privát, szöveg típusú adattag) és fizetése (long típusú, a leszármazottak számára hozzáférhető adattag), mely kezdetben 30000.

Definiáljuk a következő metódusokat:
- Egy konstruktort, mely paraméterül várja a nevet és a címet.
- getName(), getAddress() metódusokat, melyek visszaadják a nevet és a címet.
- toString() metódust, mely felüldefiniálja a java.lang.Object osztály toString() metódusát. Egy példa az előállított szövegre: "Rafael Nadal (Manacor, Spain) wage: 50000"
- raise(), mely megemeli a fizetést 10000-rel.
*/

class Person {
	private String name, address;
	protected long wage = 30000;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) wage: %l", name, address, wage);
	}

	public void becomeCEO() {
		raise();
		raise();
		raise();
	}

	public void raise() {
		wage += 5000;
	}
}