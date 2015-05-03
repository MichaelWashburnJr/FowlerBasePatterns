import java.util.Collection;
import java.util.ArrayList;

/**
 * A book finder that pretends to use a database but doesn't really
 * (Ignore the fact that IDs are assumed to be correct)
 * @author Adam
 *
 */
public class BookFinder {
	Collection<Book> books; // pretend this is a database
	
	public BookFinder() {
		this.books = new ArrayList<Book>();
	}
	
	/**
	 * Check if the book with this ID exists.
	 * @param id The unique ID number of the book
	 * @return A boolean indicating whether the book was found
	 */
	public synchronized boolean hasId(int id) {
		for (Book b : books) {
			if (b.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds a book to the book finder's collection
	 * (Pretend this method adds it to a database)
	 * @param b The book to add to the collection 
	 */
	public synchronized void addBook(Book b) {
		books.add(b);
	}
	
	/**
	 * Returns the book associated with the given ID.
	 * @param id The unique ID number of the book to find
	 * @return The book that was found
	 * @throws IllegalArgumentException if the book is not in the collection
	 */
	public synchronized Book getBookById(int id) throws IllegalArgumentException {
		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		throw new IllegalArgumentException("No book with that ID exists");	
	}
	
	public synchronized Book getBookByTitle(String title) throws IllegalArgumentException {
		for (Book b : books) {
			if (b.getTitle().equals(title)) {
				return b;
			}
		}
		throw new IllegalArgumentException("No book with that title exists");
	}
}
