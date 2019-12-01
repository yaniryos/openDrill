
public class User {
	
	protected String userId;
	protected boolean[] userTags = new boolean[5];
	
	public User(){
		
		createNewUser();
		
	}
	
	public void createNewUser(){
		
		//Scanner scanUser = new Scanner(System.in);
		
		System.out.println("Enter the user id");
		this.userId = FirstProject.myScanner.nextLine();
		
		System.out.println("Is the restaurant alcoholic(y/n)?");
		userTags[RestaurantSystem.ALCH] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant dateable(y/n)?");
		userTags[RestaurantSystem.DATE] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant ac(y/n)?");
		userTags[RestaurantSystem.AC] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant smoking(y/n)?");
		userTags[RestaurantSystem.SMOKE] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant vegeterian(y/n)?");
		userTags[RestaurantSystem.VEGAN] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		FirstProject.myScanner.nextLine();
		
		System.out.println("User was added");
		
	}
	
	
	
}
