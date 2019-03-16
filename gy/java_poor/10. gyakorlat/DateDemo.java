class DateDemo {
	public static void main(String[] args) {
		Date d = new Date(2017, Month.MAY, 2);

		System.out.println(d);

		for (Month m : Month.values())
			System.out.println((m.ordinal() + 1) + ". " + m + " " + m.name());
		System.out.println(Month.MAY.compareTo(Month.JAN));
	}
}
