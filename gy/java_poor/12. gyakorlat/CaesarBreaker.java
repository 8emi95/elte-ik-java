import java.util.*;

class CaesarBreaker {
	public static void main(String[] args) {
		Map<Character,Integer> chars = new HashMap<>();
		for (char c = 'a'; c <= 'z'; c++) {
			chars.put(c, 0);
		}
		chars.put(' ', 0);
		String text = args[0];
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			chars.put(c, chars.get(c) + 1);
		}
		System.out.println(chars);
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ')
				System.out.print((char)(text.charAt(i) - 3));
			else
				System.out.print(text.charAt(i));
		}
	}
}
