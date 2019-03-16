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
			rows.add(sc.nextLine().trim().split("\\s*,\\s*"));
		}
		String[][] table = rows.toArray(new String[rows.size()][]);
		CSV c = new CSV(table);

		return c;
	}

	public String[][] getContents() {
		String[][] copy = new String[table.length][];
		for (int i = 0; i < table.length; ++i)
		{
			copy[i] = table[i].clone();
		}
		return copy;
	}
}