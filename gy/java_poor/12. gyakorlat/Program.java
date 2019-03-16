import java.util.*;
import java.util.stream.*;

class Program {
	public static void main(String[] args){
		List<Book> books = new LinkedList<>();
		books.add(new Book("J. K. Rowling", "Harry Potter 1", 3990));
		books.add(new Book("Simon Peter", "Bevanal", 6000));
		books.add(new Book("Douglas Adams", "Galaxis utikalauz", 10000));

		List<Book> expensiveBooks2 = new LinkedList<>();
		for (Book b : books)
			if (b.price >= 5000)
				expensiveBooks2.add(b);

		int price = 5000;

		List<String> expensiveBooks = books.stream()
			.filter((Book b) -> b.price >= price)
			.map((Book b) -> { System.out.println(b); return b.title; })
			.collect(Collectors.toList());

		System.out.println(expensiveBooks);
		System.out.println();

		 Optional<String> expensiveBook = books.stream()
			.filter((Book b) -> b.price >= price)
			.map((Book b) -> { System.out.println(b); return b.title; })
			.findFirst();

		 if (expensiveBook.isPresent()) {
			 String title = expensiveBook.get();
			 System.out.println(title);
		 } else
			 System.out.println("Nem volt ilyen konyv.");

		 //		 if (expensiveBook != null)
		 //			 System.out.println(expensiveBook.isEmpty());
	}
}
