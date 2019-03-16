package biblio;
import biblio.Entry;
import person.Author;

public class Query {
	private Author author;
	private String publisher;

	private Query(Author author, String publisher) {
		this.author = author;
		this.publisher = publisher;
	}

	public static Query byAuthor(Author author) {
		return new Query(author, null);
	}

	public static Query byPublisher(String publisher) {
		return new Query(null, publisher);
	}

	public boolean accept(Entry entry) {
		if (this.author == null)
		{
			return (entry.getPublisher().equals(this.publisher));
		}
		else
		{
			return (entry.getAuthor().equals(this.author));
		}
	}
}