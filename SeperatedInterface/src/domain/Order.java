package domain;

public interface Order {
	
	public Order setItem(String item);
	public Order setName(String name);
	public void save();	

}
