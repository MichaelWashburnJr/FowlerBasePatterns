package mapper;
import domain.Order;

public class OrderMapper implements Order {
	
	String name;
	String item;
	
	@Override
	public Order setItem(String item) {
		this.item = item;
		return this;
	}
	@Override
	public Order setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public void save() {
		//In a real implementation this would save the state of this object to a database.
	}


}
