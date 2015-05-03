
/**
 * A singleton registry that stores global state across threads
 * @author Adam McCarthy
 */
public class Registry {
	private static Registry soleInstance;
	private BookFinder bookFinder;
	
	// Private constructor, singleton
	private Registry() {
		// do nothing
	}
	
	// Gets the singleton instance. Private because no client code should ever need to call this.
	private static Registry getInstance() {
		if (soleInstance == null) {
			soleInstance = new Registry();
		}
		return soleInstance;
	}
	
	// Gets the registered book finder object, creates it if there is none.
	public static synchronized BookFinder bookFinder() {
		Registry reg = getInstance();
		if (reg.bookFinder == null) {
			reg.bookFinder = new BookFinder();
		}
		return reg.bookFinder;
	}
}
