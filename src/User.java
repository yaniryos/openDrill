
public class User extends SystemNode {
	
	protected String userId;
	
	public User(){
		
		createNewUser();
		
	}
	
	public void createNewUser(){
		
		
		System.out.println("Enter the user id");
		this.userId = FirstProject.myScanner.nextLine();
		
		System.out.println("Is the restaurant alcoholic(y/n)?");
		tags[RestaurantSystem.TAGS.ALCH.ordinal()] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant dateable(y/n)?");
		tags[RestaurantSystem.TAGS.DATE.ordinal()] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant ac(y/n)?");
		tags[RestaurantSystem.TAGS.AC.ordinal()] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant smoking(y/n)?");
		tags[RestaurantSystem.TAGS.SMOKE.ordinal()] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant vegeterian(y/n)?");
		tags[RestaurantSystem.TAGS.VEGAN.ordinal()] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		FirstProject.myScanner.nextLine();
		
		System.out.println("User was added");
		
	}

	@Override
	public String getStringData() {
		
		return userId;
	}
	
	
	
}
