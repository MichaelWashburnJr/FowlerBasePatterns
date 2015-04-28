import java.io.BufferedReader;
import java.io.FileReader;


public class Gateway {

	public String getPrice(BuyableThings buyingThing){
		String filename = "Prices.txt";
		String price = ""; 
		
		try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		   
		    while ((line = reader.readLine()) != null)
		    {
		      if (line.contains(buyingThing.getType())){
		    	  price = line.split(":")[1];
		    	  break;
		      }
		    }
		    reader.close();
		    return price;
		  }
		  catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    return null;
		  }
		}
}
