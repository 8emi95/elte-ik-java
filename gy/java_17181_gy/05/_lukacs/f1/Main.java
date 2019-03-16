import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
      //      proactive(args); 
      //      reactive(args);

      io(args);
    }

    public static void proactive(String[] args){
            if(args.length > 0){
              char[] s = args[0].toCharArray();
              boolean b = true;
              for(char c : s){
                b = b && ('0' <= c && c <= '9');
              }
      
              if(b) System.out.println(1+ Integer.parseInt(args[0]));
            }
    }

    public static void reactive(String[] args) throws Exception{
        try {
            System.out.println(1 + Integer.parseInt(args[0]));
            System.out.println("Nem volt baj");
            String s = null;
            s.length();
        // }  catch(Exception e){
        //        System.out.println("Rossz a sorrend.");
        //      }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Kivétel:");
            e.printStackTrace();
        } catch(NumberFormatException e){
            System.out.println("Másik kivétel:");
            e.printStackTrace();
        } finally {
            System.out.println("Mindképpen lefut");
        }

        throw new Exception("nagy a baj");
    }

    public static void io(String[] args) throws IOException {
      //      File f = new File(args[0]);
      //      FileReader fr = new FileReader(f);
      //      BufferedReader br = new BufferedReader(fr);



      /*
      BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
      System.out.println(br.readLine());
      


      // System.out.println(1 / 0);
      br.close();
      */

      /*
      BufferedReader br2 = null;
      try {
        br2 = new BufferedReader(new FileReader(new File(args[0])));
        System.out.println(br2.readLine());
        // TODO ciklusban használathoz: readLine != null 
        System.out.println(1 / 0);
      } finally {
        br2.close();
      }
      */
 
      /*
      try ( BufferedReader br3  = new BufferedReader(new FileReader(new File(args[0])));
            PrintWriter pw = new PrintWriter(new File(args[1]))){
        String s = br3.readLine();
        System.out.println(s);
        pw.println(s);
        pw.flush();
      }
      */

      
      try ( Scanner sc  = new Scanner(new File(args[0]));
            PrintWriter pw = new PrintWriter(new File(args[1]))){
        String s = sc.nextLine();
        // TODO ciklusban használathoz: hasNextLine()
        System.out.println(s);
        pw.println(s);
        pw.flush();
      }

      /* // megj.: BufferedReader olvasása ciklusban:
      
      // v1   
      while(true){
        String line = br.readLine();
        if(line == null) 
          break;
        System.out.println(line);
      }
      
      // v2
      while((line=br.readLine())!=null){
        System.out.println(line);
      }

      // v3
      for (String line = br.readLine(); line != null; line = br.readLine()) {
      }
      */
      

    }


}
