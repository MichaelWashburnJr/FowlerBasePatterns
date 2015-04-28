
public class GatewayTester {

	public static void main(String[] args) {
		
		Gateway gateway = new Gateway();
		
		Car car = new Car();
		Truck truck = new Truck();
		Boat boat = new Boat();
		
		System.out.println("Ready to buy some stuff? I know a guy that can get you some stuff");
		System.out.println("Acording to my guy a Car costs $" + gateway.getPrice(car));
		System.out.println("Acording to my guy a Truck costs $" + gateway.getPrice(truck));
		System.out.println("Acording to my guy a Boat costs $" + gateway.getPrice(boat));

	}

}
