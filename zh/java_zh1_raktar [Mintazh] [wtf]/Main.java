import java.io.*;

public class Main{
	public static void main (String[] args){
		try{
			Raktar raktar = new Raktar();
			
			raktar.termekinput("termekek.txt");
			raktar.raktarinput("raktar.txt");
			
			raktar.print();
			System.out.println("A raktarban levo termekek osszbeszerzesi ara: " + raktar.sumPrice());
			raktar.maxDifferenceBetweenConsumerPriceAndProcurementPrice();
			raktar.whichIsTheBest();
		} catch(FileNotFoundException e) {
			System.out.println("File fail.");
		} catch (IOException e){
			System.out.println("Reading fail.");
		}
	}
}