package biblio;
import java.util.ArrayList;
import person.Author;
import biblio.Entry;
import csv.CSV;
import biblio.Query;
import java.lang.Exception;

public class Bibliography {
	private ArrayList<Entry> entries = new ArrayList<Entry>();

	public Bibliography(CSV c) {
		Entry.resetId();

		String[][] table = c.getContents();
		for (String[] row : table)
		{
			if (row.length != 4) { continue; }

			Author a = Author.make(row[0]);
			if (a == null) {
				continue;
			}

			int year = 0;
			try {
				year = Integer.parseInt(row[3]);
			}
			catch (Exception e) {
				continue;
			}

			Entry e = Entry.make(a, row[1], year, row[2]);
			if (e == null) { continue; }
			entries.add(e);
		}
	}

	public void filter(Query q) {
		for (int i = entries.size()-1; i >= 0; --i) {
			if (!q.accept(entries.get(i)))
			{
				entries.remove(i);
			}
		}
	}

	public String show(int format) {
		String all = "";
		for (Entry e : entries)
		{
			all += e.show(format) + "\n";
		}
		return all;
	}
}