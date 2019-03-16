package ladder;
import java.lang.RuntimeException;
import java.lang.*;
import java.io.*;
import java.util.*;

public class WordLadder{
	
	private static boolean isNeighbour(String data, String data2){
		if(data.length() == data2.length()) {
			//if(){
				return true;
			//}
		}
		return false;
		
	}
	
	private static List<String> readInput(String fileName) /*throws RuntimeException*/ {
		Scanner sc = new Scanner(fileName);
			String[] words = sc.nextLine().split(",");
			if(words.length == 2){
				
				System.err.println("The number of words in the input file in a line differs from two.");
				if(words[0].length() == words[1].length()){
					System.err.println("Words have different lengths." );
					if(sc.hasNextLine() == false){
						System.err.println("The input file does not consist of one line." );
					}
				}	
			} /*else{
				throw new RuntimeException();
			}
				*/
		return null;
	}
	
	//private static void writePath(String fileName, String text){}
	
	/*public static UndirectedGraph<V> buildLadder(String inputFileName, String dictionary, String outputFileName) {
		return null;
	}*/
}