
public class Adder {
  public static String add(String sa, String sb){
    try { 
        int ia = Integer.parseInt(sa);
        int ib = Integer.parseInt(sb);
        return Integer.toString(ia + ib);
    } catch(NumberFormatException e){
        try { 
            double da = Double.parseDouble(sa);
            double db = Double.parseDouble(sb);
            return Double.toString(da + db);
        } catch(NumberFormatException e2){
        }
    }

    throw new IllegalArgumentException("One or both of the parameters were not numbers");
  }

}
