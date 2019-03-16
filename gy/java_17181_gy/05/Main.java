import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Main {
    public static void main(String[] args) {
        // proactive(args);
        // reactive(args);
        io(args);
    }

    public static void io(String[] args) {
        // File f = new File("input1.txt");
        // FileReader fr = new FileReader(f);
        // BufferedReader br = new BufferedReader(fr);
        // System.out.println(br.readLine());

        BufferedReader br = null;
        PrintWriter pw = null;
        try (
            br = new BufferedReader(new FileReader(new File("input1.txt")));
            pw = new PrintWriter(new File("output1.txt"))){
            while (true) {
                String s = br.readLine();
                System.out.println(s);
                if (s == null) {
                    break;
                }
                pw.println(s);
            }
            int x = 1/0;
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
            pw.close();
        }
    }

    public static void reactive(String[] args) {
        try {
            System.out.println(Integer.parseInt(args[0] + 1));
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("hiba: " + e);
        } catch(NumberFormatException e) {
            System.out.println("mas hiba: " + e);
        } finally {
            System.out.println("kesz");
        }
    }

    public static void proactive(String[] args) {
        if (args.length > 0) {
            System.out.println(Integer.parseInt(args[0] + 1));
            //
        } else {
            System.out.println("min 1 elem kell");
        }
    }
}