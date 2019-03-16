package main;
import java.util.Scanner;
import person.Author;
import biblio.Entry;
import csv.CSV;
import biblio.Query;
import biblio.Bibliography;

public class Main {
	public static int main(String[] args) {
		// alapértelmezett értékek
		Author author = null;
		String publisher = null;
		int format = Entry.FORMAT_RAW;

		// végigmegyünk a parancssori paramétereken
		// az i-edik paraméter egy opció neve
		// az i+1-edik paraméter az opció értéke

		if (args.length % 2 == 1)
			return 1; // hibás paraméterlista

		for (int i = 0; i < args.length; i+=2) {
			String paramName = args[i];
			String paramValue = args[i+1];

			if (paramName.equals("publisher=")) { // deafault equals()?
				// publisher paraméter
				publisher = paramValue;
				author = null;
			}
			else if (paramName.equals("author=")) {
				// author paraméter
				author = Author.make(paramValue);
				publisher = null;
			}
			else if (paramName.equals("format=")) {
				// format paraméter
				if (paramValue.equals("formatRaw"))
					format = Entry.FORMAT_RAW;
				else if (paramValue.equals("authorYear"))
					format = Entry.FORMAT_AUTHOR_YEAR;
				else if (paramValue.equals("authorYearCompact"))
					format = Entry.FORMAT_AUTHOR_YEAR_COMPACT;
			}
			else return 1; // hibás paraméternév
		}

		// a szűrő előállítása a beolvasott paraméterek alapján
		Query q = null;
		if (publisher != null)
			q = Query.byPublisher(publisher);
		else if (author != null)
			q = Query.byAuthor(author);
		else
			return 1; // hibás bemenet

		// a szabványos bemenetet olvasó Scannerrel csinálunk egy CSV-t
		CSV csv = CSV.read(new Scanner(System.in));

		// ezzel a csv-vel megcsináljuk a könyvlistát
		Bibliography b = new Bibliography(csv);

		// szűrünk
		b.filter(q);

		// kiírjuk a listát
		System.out.print(b.show(format));

		return 0;
	}
}