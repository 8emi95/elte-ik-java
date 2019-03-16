import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Scanner;

public class SumLines {
  public static void main(String[] args) throws IOException{
    String inputPath = args[0];
    String outputPath = args[1];
    sumLinesWithBReader(inputPath, outputPath);
    sumLinesWithScanner(inputPath, outputPath);
  }

  private static void sumLinesWithBReader(String inputPath, String outputPath) throws IOException {
    try ( BufferedReader br  =
            new BufferedReader(new FileReader(new File(inputPath)));
          PrintWriter pw =
            new PrintWriter(new File(outputPath))
        ){

      while(true){
        String line = br.readLine();
        if(line == null){
          break;
        }

        String[] sNums = line.split(",");
        int sum = 0;
        for(String sNum : sNums){
          try{
            sum += Integer.parseInt(sNum);
          } catch(NumberFormatException e){
            // "A fájl tartalmazhat hibás adatokat (nem számokat), ezeket a program egyszerűen hagyja figyelmen kívül!"

            ;   // üres utasítás (opcionális)
          }
        }

        System.out.println(sum);
        pw.println(sum);
        pw.flush();
      }
    }
  }

  private static void sumLinesWithScanner(String inputPath, String outputPath) throws IOException {
    try (Scanner sc = new Scanner(new File(inputPath));
         PrintWriter pw =
         new PrintWriter(new File(outputPath))
         ){


      while(sc.hasNextLine()){
        Scanner lineSc = new Scanner(sc.nextLine());
        lineSc.useDelimiter(","); // legyen a mezők közötti elválasztó-jel a vessző

        int sum = 0;
        while(lineSc.hasNext()){ // ha van még mező
          if(lineSc.hasNextInt()) // ha van még int értékű mező
            sum += lineSc.nextInt(); // olvasd be az egész számot, és léptesd a kurzort
          else // ha van mező, de nem int értékű 
            lineSc.next(); // olvasd be a mezőt (ne csinálj vele semmit), és léptesd a kurzort
        }

        System.out.println(sum);
        pw.println(sum);
        pw.flush();
      }
    }
  }
}
