public class Main {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

        private String str;

        Day(String str) {
            this.str = str;
        }
    }

    public class Day2 {
        public static final int SUNDAY = 0;
        public static final int MONDAY = 1;
    }

    public static void main(String[] args) {
        Day d = Day.MONDAY;
        // int d2 = Day2.MONDAY;
        System.out.println(Day.valueOf(args[0]));

        String str = null;
        switch(d) {
            case MONDAY:
                str = "Mondays are bad.";
                break;
            case FRIDAY:
                str = "Fridays are better.";
            case SATURDAY: case SUNDAY:
                str = "Weekends are [the] best.";
                break;
            default:
                str = "Midweek days are so-so.";
        }

        System.out.println(str);
    }
}