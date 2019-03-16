package auction;
import auction.Book;
import auction.Genre;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Auction {
	
	private ArrayList<Book> books;
	
	public ArrayList<Book> getBooks() {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b: books)
			temp.add(b);
		return temp;
	}

	public Auction(ArrayList<Book> books) {
		for (Book book : books)
			this.books.add(book);
	}
	
	public int numberOfBooks() {
		// return books.length;
		return books.size();
	}


	public ArrayList<Book> browseBooks(Genre g){
		// ArrayList<Book> aList;
		ArrayList<Book> aList = new ArrayList<Book>();
		for (Book book : books)
			if (book.getGenre().equals(g)){
				aList.add(book);
			}
		return books;
	}

	// public void toString() {
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < books.size()-1; ++i)
			sb.append(books.get(i).toString() + "\n");
		if (books.size() > 0)
			sb.append(books.get(books.size()-1).toString());
		return sb.toString();
	}

	public static Book mostExpensiveInList(List<Book> books){
		Book max = books.get(0);
		for (Book book : books) {
			if (book.moreExpensiveThan(max)) {
				max = book;
			}
		}
		return max;

	}
}
