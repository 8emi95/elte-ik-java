import java.lang.*;

public class Try{
	
	public static void main(String[] args){
		String value = "abc123";
    // Loop through characters in this String.
    for (int i = 0; i < value.length(); i++) {
        char c = value.charAt(i);

        // See if the character is a letter or not.
        if (Character.isLetter(c)) {
			System.out.println("This " + c + " = LETTER");
        } 
        if (Character.isDigit(c)) {
			System.out.println("This " + c + " DIGIT");
        }

        if ((""+c).matches("\\p{M}"))
            System.out.println("This " + c + " = UNICODE LETTER");
		}
	}
	
}