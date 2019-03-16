import java.util.*;

class Reverse {
    public static void main(String[] args) {
	LinkedList<String> lines = new LinkedList<>();
	// végére fűzés: lines.add(elem);
	// indexelés: lines.get(index);
	// hossz: lines.size()
	
	Scanner s = new Scanner(System.in);

	/* while (s.hasNextLine()) {
	    lines.add(s.nextLine());
	}
	for (int i = lines.size() - 1; i >= 0; i--)
	    System.out.println(lines.get(i));
	*/
	
	while (s.hasNextLine()) {
	    lines.push(s.nextLine());
	}
	for (String line : lines)
	    System.out.println(lines);
    }
}
