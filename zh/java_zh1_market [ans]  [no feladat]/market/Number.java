import java.lang.*;
//import java.lang.Object;
import java.text.*;
//import java.text.Format;
//import java.text.NumberFormat;
//import java.text.DecimalFormat;

public class Number{
	public static void main(String[] args) {
		int p = 25555558;
		int m = 2000;
		int last = p%10;
		String s="hello";  

		String text = "Bodri.";
		int sizeoftext = text.length();
		DecimalFormat myFormatter = new DecimalFormat("#,###");
		//String output = myFormatter.format(p);
		if(text.matches(".*\\d+.*")){
			System.out.println("true");
		} else
			System.out.println("false");
		String output = myFormatter.format(p);
		System.out.println(output);
		System.out.println(s.substring(s.length()-1,s.length()));
		System.out.println(last);
		
		System.out.print(sizeoftext);
	}
}
/*
String temp = Integer.toString(urNumber);
System.out.println(temp.charAt(temp.length()-1));

int num = 333;
String number = String.valueOf(num);
for(int i = 0; i < number.length(); i++) {
    int j = Character.digit(number.charAt(i), 10);
    System.out.println("digit: " + j);
	
 */