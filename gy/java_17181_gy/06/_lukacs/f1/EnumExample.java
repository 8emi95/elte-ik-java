import java.util.Arrays;
public class EnumExample{

  public enum Day {
    SUNDAY ("Weekends are best."),
    MONDAY ("Mondays are bad."),
    TUESDAY ("Midweek days are so-so."),
    WEDNESDAY ("Midweek days are so-so."),
    THURSDAY ("Midweek days are so-so."),
    FRIDAY ("Fridays are better."),
    SATURDAY ("Weekends are best.");

    public String message;
    Day(String s){
      this.message = s;
    }

  }

  public static void main(String[] args){
    Day d = Day.valueOf(args[0]);

    String s =  "";
    switch(d){
        case MONDAY:
            s = "Mondays are bad.";
            break;
        case TUESDAY:
        case WEDNESDAY:
        case THURSDAY:
            s = "Midweek days are so-so.";
            break;

        case FRIDAY:
            s = "Fridays are better.";
            break;
        case SATURDAY:
        case SUNDAY:
            s = "Weekends are best.";
    }

    System.out.println("- Klasszikus megoldás:");
    System.out.println(s);

    System.out.println("- JAVA enum megoldás:");
    System.out.println(d.message);

    System.out.println("- Egyebek:");
    System.out.println(Day.FRIDAY.ordinal());
    System.out.println(Day.MONDAY.ordinal() < Day.FRIDAY.ordinal());
    System.out.println(Arrays.toString(Day.values()));

  }
  

}
