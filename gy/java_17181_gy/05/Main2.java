import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
      io(args);
    }

    public static void io(String[] args) throws IOException {
        try (BufferedReader br  = new BufferedReader(new FileReader(new File(args[0])));
             PrintWriter pw = new PrintWriter(new File(args[1]))) {
            String s = br.readLine();
            System.out.println(s);
            pw.println(s);
            pw.flush();
      }
    }
}
