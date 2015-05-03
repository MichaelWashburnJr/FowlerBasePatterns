
public class Example {
	public static final String[] titles = {
		"The Tortoise and the Hare",
		"The Odyssey",
		"Winnie the Pooh",
		"Great Expectations",
		"Pride and Prejudice",
		"To Kill a Mockingbird",
		"The Great Gatsby",
		"Jane Eyre",
		"1984",
		"The Catcher in the Rye",
		"Animal Farm",
		"Wuthering Heights",
		"Little Women",
		"Lord of the Flies",
		"Of Mice and Men",
		"The Adventures of Huckleberry Finn",
		"Sense and Sensibility",
		"Frankenstein",
		"The Hobbit",
		"A Tale of Two Cities"
	};
	
	public static void main(String[] args) {
		Thread t1 = new Thread() { // create a thread to add all the books
			@Override
			public void run() {
				for (int i = 0; i < titles.length; i++) {
					Book b = new Book(titles[i], i);
					Registry.bookFinder().addBook(b);
				}
			}
		};
		Thread t2 = new Thread() { // create a thread to find a book
			private BookFinder bf = Registry.bookFinder();
			@Override
			public void run() {
				while (true) {
					try {
						Book book = bf.getBookById(16);
						System.out.println("Found book: " + book.toString());
						break;
					} catch (IllegalArgumentException e) {
						System.out.println("The bookfinder does not have that book as it has not yet been registered");
					}
				}
			}
		};
		t1.start(); // start the book-adding thread
		t2.start(); // start the book-finding thread
	}
}
