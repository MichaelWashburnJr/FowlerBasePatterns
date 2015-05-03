package domain;
import mapper.OrderMapper;

public class Customer {

	String name;
	
	public Customer(String name){
		this.name = name;
	}
	
	public void placeOrder(String item){
		Order order = new OrderMapper()
			.setItem(item)
			.setName(this.name);
		order.save();
	}
	
}
