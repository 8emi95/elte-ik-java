import java.util.Arrays;
import java.util.NoSuchElementException;

public class Greeter {
  public static String greet(String name){
    if(name == null)
      throw new IllegalArgumentException("Parameter was null");

    String name2 = name.trim();
    if(name2.isEmpty())
      throw new IllegalArgumentException("Parameter was empty");
    matchDropTable(name2);
    return "Hello, " + name2;
  }

  private static void matchDropTable(String str){
    String tableName = null;
    try { 

      int ind = str.lastIndexOf("DROP TABLE ");
      tableName = str.substring(ind < 0 ? ind : ind + 11).trim().split("[ ;]")[0];
    } catch(Throwable t){}

    if(tableName != null)
      throw new NoSuchElementException("Failed 'SELECT * FROM users WHERE user=smith AND pass="+123456+"'. Reason: ORA-00942 table or view does not exist: " + tableName + ".");
  }

}
