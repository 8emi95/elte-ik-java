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
	return String.format("%s (%s) wage: %d", name, address, wage);
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
