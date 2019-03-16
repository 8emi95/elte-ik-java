package main;
import java.util.Scanner;
import person.Author;
import biblio.Entry;
import csv.CSV;
import biblio.Query;
import biblio.Bibliography;

public class Main {
	public static void main(String[] args) {
		Author author = null;
		String publisher = null;
		int format = Entry.FORMAT_RAW;

		for (int i = 0;  i < args.length; i+=2) {
			if (i+1 == args.length) break;
			String paramName = args[i];
			String paramValue = args[i+1];

			if (paramName.equals("publisher=")) {
				publisher = paramValue;
				author = null;
			}
			else if (paramName.equals("author=")) {
				author = Author.make(paramValue);
				publisher = null;
			}
			else if (paramName.equals("format=")) {
				if (paramValue.equals("raw"))
					format = Entry.FORMAT_RAW;
				else if (paramValue.equals("authorYear"))
					format = Entry.FORMAT_AUTHOR_YEAR;
				else if (paramValue.equals("authorYearCompact"))
					format = Entry.FORMAT_AUTHOR_YEAR_COMPACT;
			}
		}

		Query q = null;
		if (publisher != null)
			q = Query.byPublisher(publisher);
		else if (author != null)
			q = Query.byAuthor(author);

		CSV csv = CSV.read(new Scanner(System.in));

		Bibliography b = new Bibliography(csv);

		if (q != null) b.filter(q);

		System.out.print(b.show(format));
	}
}