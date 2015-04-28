
public class FindCreditScores {
	
	public interface CreditFinder{
		
		public int findCredit(String username);
		
	}
	
	/*
	 * Mocks out an actual credit score finder service.
	 */
	public static class CreditServiceStub implements CreditFinder {

		@Override
		public int findCredit(String username) {
			if (username.equals("Alex")){
				return 10000;
			} 
			else if (username.equals("Steve")){
				return 5000;
			} 
			else {
				return 0;
			}
		}
		
	}
	
	/*
	 * Would represent an actual credit score finder service
	 */
	public static class RealCreditService implements CreditFinder {

		@Override
		public int findCredit(String username) {
			return 0;
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("Starting finding credit.");
		
		CreditFinder creditService = new CreditServiceStub();
		String username = "Alex";
		int creditScore = creditService.findCredit(username);
		System.out.println("Credit score for " + username + " is " + creditScore);
		
	}
	
	

}


