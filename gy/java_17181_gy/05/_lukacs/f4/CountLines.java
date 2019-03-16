
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

public class CountLines {
  public static void main(String[] args) throws IOException{
    String inputPath = args[0];

    Scanner sc = new Scanner(System.in);
    String pattern = sc.nextLine();
    sc.close();

    System.out.println(countContainingLines(pattern, inputPath));
  }

  private static int countContainingLines(String pattern, String inputPath) throws IOException{
    int count = 0;
    try (Scanner sc = new Scanner(new File(inputPath)) ){
      while(sc.hasNextLine()){
        String s = sc.nextLine();
        if(s.contains(pattern))
          count++;
      }
    }
    return count;
  }
}
