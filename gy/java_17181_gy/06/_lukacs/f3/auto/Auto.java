package auto;
import auto.utils.Color;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Auto {
	public enum Color {
		RED, GREEN, BLUE
	}
	
	String s; Color c; int i;
	public Auto(String s, Color c, int i){
		this.s = s;
		this.c = c;
		this.i = i;
		
		counter += 1;
	}
	
	public static int counter;
	
	public String toString(){
		return "Auto{" + s + "," + c + "," + i  + "}";
	}
	
	public static boolean compare(Auto a, Auto b){
		return a.i > b.i;
	}
	
	
	 public static void main(String[] args) throws IOException{
		  try ( BufferedReader br  =
					new BufferedReader(new FileReader(new File("input.txt")))
				){

			  System.out.println(Auto.counter);
			  Auto[] autos = new Auto[2];
			  int i= 0;
			  while(true){
				String line = br.readLine();
				if(line == null){
				  break;
				}

				String[] fields = line.split(";");
			    autos[i] = new Auto(fields [0], Color.valueOf(fields [1]), Integer.parseInt(fields [2]));										
				++i;
			  }
			  
			  System.out.println(Auto.counter);
			  System.out.println(Arrays.toString(autos));
			  System.out.println(Auto.compare(autos[0], autos[1]));
			  
			}
	}
}
