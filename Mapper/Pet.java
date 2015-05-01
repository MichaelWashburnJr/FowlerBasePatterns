
public class Pet {

	private String name;
	private String type;
	private float weight;
	private int age;
	private boolean friendly;
	
	public Pet(String name, String type, float weight, int age, boolean friendly) {
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.age = age;
		this.friendly = friendly;
	}

	public String getType() {
		return type;
	}

	public float getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public boolean isFriendly() {
		return friendly;
	}
	
	public String getName(){
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFriendly(boolean friendly) {
		this.friendly = friendly;
	}
	
	
}
