package csv;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CSV {
	private String[][] table;

	private CSV(String[][] table) {
		this.table = table;
	}

	public static CSV read(Scanner sc) {
		ArrayList<String[]> rows = new ArrayList<String[]>();
		while (sc.hasNextLine())
		{
			rows.add(sc.nextLine().split("\\s*,\\s*"));
		}
		//String[][] table = (String[][]) rows.toArray();
		String[][] table = new String[ rows.size() ] [];
		table = rows.toArray(table);
		CSV c = new CSV(table);

		return c;
	}

	public String[][] getContents() {
		//return Arrays.copyOf(table);

		String[][] copy = new String[table.length][];
		for (int i = 0; i < table.length; ++i)
		{
			copy[i] = table[i].clone();
		}
		return copy;
	}
}