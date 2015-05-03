
public class Book {
	private String title;
	private int id;
	
	public Book(String title, int id) {
		this.title = title;
		this.id = id;
	}
	
	public String toString() {
		return "<Book: " + this.title + ">";
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
}
