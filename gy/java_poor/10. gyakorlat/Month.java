enum Month {
	JAN("januar"),
	FEB("feburar"),
	MAR("marcius"),
	APR("aprilis"),
	MAY("majus"),
	JUL("julius"),
	JUN("junius"),
	AUG("augusztus"),
	SEP("szeptember"),
	OCT("oktober"),
	NOV("november"),
	DEC("december");
    
	Month(String name) {
		this.name = name;
	}

	private String name;

	public String toString() {
		return name;
	}
}
