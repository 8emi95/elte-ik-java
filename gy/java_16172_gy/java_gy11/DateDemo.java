class DateDemo {
    public static void main(String[] args) {
        Date d = new Date(2017, MAY, 2);

        System.out.println(d);

        for (Month m : Month.value()) {
            System.out.println((m.ordinal() + 1) + ". " + m + " " + m.name());
        }

        System.out.println(Month.MAY.compareTo(Month.Jan));
    }
}