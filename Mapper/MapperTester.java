/**
 * MappterTester.java creates pet objects by interacting
 * with Pets.java and Mapper.java 
 * 
 * After this is run once, the output will make less sense
 * because it counts on values in pets.xml for demonstration 
 * purposes. To run it again copy the content of OriginalPets.xml
 * or have some fun and modify Pets.xml and this file so test out
 * some of the Mapper functions
 */
public class MapperTester {

	public static void main(String[] args) {
		
		Mapper mapper = new Mapper();
		
		// Create a pet object from the xml document
		Pet pet1 = mapper.getPetByName("Spike");
		
		System.out.println("Found " + pet1.getName() + " in the xml document");
		
		Pet pet2 = mapper.getPetByName("Bruno");
		System.out.println(pet2.getName() + " is currently a " + pet2.getType() + " thats "
				+ "incorrect, infact his info is all wrong. Updating the object and then having the mapper update the xml document "
				+ "to have the correct info");
		
		pet2.setAge(6);
		pet2.setType("Snake");
		pet2.setWeight(122);
		pet2.setFriendly(true);
		
		mapper.updatePetRecords(pet2);
		System.out.println(pet2.getName() + " is now a " + pet2.getType());
		
		System.out.println("Creating a new pet and having the mapper add it to the xml document");
		Pet pet3 = new Pet("Snappy", "Turttle", Float.parseFloat("5.2"), 15, false);
		mapper.addPet(pet3);

		// clear the object to make sure it was added correctly
		pet3 = null;
		pet3 = mapper.getPetByName("Snappy");
		System.out.println(pet3.getName() + " the " + pet3.getType() + " has been added to the xml document");
		
		// add a pet and then remove it
		System.out.println("Adding a new parrot Jerome to the xml document, and then removing it");
		Pet pet4 = new Pet("Jerome", "parrot", Float.parseFloat("1.2"), 45, true);
		mapper.addPet(pet4);
		// clear the object to make sure it was added correctly
		pet4 = null;
		pet4 = mapper.getPetByName("Jerome");
		System.out.println(pet4.getName() + " the " + pet4.getType() + " has been added to the xml document, now removing it");
		
		mapper.deletePet(pet4);
		pet4 = null;
		
		// try and get it again
		pet4 = mapper.getPetByName("Jerome");
		
		if (pet4 == null){
			System.out.println("Jerome was correctly deleted");
		}
		
	}

}
