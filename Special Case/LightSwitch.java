import java.util.ArrayList;

/***
 * A driver class to test the different kinds of light bulbs
 * and most importantly the NullBulb.java that is used instead 
 * of null
 */
public class LightSwitch {

	public static void main(String[] args) {
		
		LightBulb led = new Led();
		
		LightBulb led2 = new Led();
		
		LightBulb incandescent = new Incandescent();
		
		LightBulb incandescent2 = new Incandescent();
		
		ArrayList<LightBulb> bulbList = new ArrayList<LightBulb>();
		
		bulbList.add(led);
		bulbList.add(led2);
		bulbList.add(incandescent);
		bulbList.add(incandescent2);
		
		System.out.println("Turning All bulbs on");

		for (LightBulb bulb : bulbList){
			bulb.lightUp();
		}
		
		System.out.println("Random power surge, looks like the incandescent bulbs blew. Flipping the breaker and trying to turn the bulbs back on");
		
		for (LightBulb bulb : bulbList){
			
			if (bulb instanceof Incandescent){
				
				// Instead of setting them to null, use the NullBulb object
				bulbList.set(bulbList.indexOf(bulb),  new NullBulb());
			}
		}
		
		for (LightBulb bulb : bulbList){
			bulb.lightUp();
		}
		
		System.out.println("Looks like the incandescents did blow");
	}

}
