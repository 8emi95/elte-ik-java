package biblio;
import person.Author;

public class Entry {
	private static int counter = 0;
	private int id;
	private Author author;
	private String title;
	private int year;
	private String publisher;

	private Entry(Author author, String title, int year, String publisher) {
		this.id = counter;
		++counter;
		this.author = author;
		this.title = title;
		this.year = year;
		this.publisher = publisher;
	}

	public static Entry make(Author author, String title, int year, String publisher) {
		if (1500 <= year && year <= 2016 && author != null && !title.isEmpty()) {
			Entry e = new Entry(author, title, year, publisher);
			return e;
		}
		else {
			return null;
		}
	}

	public int getId() { return id; }
	public static void resetId() { counter = 0; }
	public static int count() { return counter; }
	public Author getAuthor() { return author; }
	public String getTitle() { return title; }
	public int getYear() { return year; }
	public String getPublisher() { return publisher; }

	public static final int FORMAT_RAW = 0;
	public static final int FORMAT_AUTHOR_YEAR = 1;
	public static final int FORMAT_AUTHOR_YEAR_COMPACT = 2;

	public String show(int format) {
		String label = "";
		if (format == FORMAT_RAW) {
			label = "[" + id + "]";
		}
		else if (format == FORMAT_AUTHOR_YEAR) {
			label = "[" + author.getLastName() + year + "]";
		}
		else if (format == FORMAT_AUTHOR_YEAR_COMPACT) {
			label = "[" + author.getLastName().substring(0, 2) + Integer.toString(year).substring(2) + "]";
		}
		else {
			throw new IllegalArgumentException("Wrong format.");
		}

		if (!publisher.isEmpty()) {
			return (label + " " + author.show() + ". " + title + ", " + publisher + ", " + year);
		}
		else {
			return (label + " " + author.show() + ". " + title + ", " + year);
		}
	}
}