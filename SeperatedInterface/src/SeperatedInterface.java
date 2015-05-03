import domain.Customer;

public class SeperatedInterface {

	public static void main(String[] args) {
		Customer karl = new Customer("Kel");
		karl.placeOrder("Orange Soda");
		System.out.println("Kel orders Orange Soda, even though he doesn't know how his order is stored.");
	}

}
