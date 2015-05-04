/**
 * MyDate is an example of a Value Object. The equality is based on the
 * fields within the class, not an ID number, for example.
 * 
 * @author Alex
 *
 */
public class MyDate {
	
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public static void main(String[] args) {
		MyDate firstDate = new MyDate(2015, 5, 16);
		MyDate secondDate = new MyDate(2015, 5, 16);
		MyDate thirdDate = new MyDate(2014, 6, 19);
		
		System.out.println("First date equal to second date: " + firstDate.equals(secondDate));
		System.out.println("First date equal to thrid date: " + firstDate.equals(thirdDate));

	}

}
