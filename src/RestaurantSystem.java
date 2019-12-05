import java.util.ArrayList;

public class RestaurantSystem {
	
	private Functor[] menuFuncs = new Functor[6];
	protected static ArrayList<Restaurant> allRes = new ArrayList<Restaurant>(); 
	protected static ArrayList<User> allUser = new ArrayList<User>();
	
	public RestaurantSystem() {
		
		menuFuncs[0] = new PrintResNames();
		menuFuncs[1] = new AddNewRes();
		menuFuncs[2] = new AddResReview();
		menuFuncs[3] = new ShowResDetails();
		menuFuncs[4] = new CreatePoll();
		menuFuncs[5] = new AddNewUser();
	}
	
	public void systemActivate() {
		
		int choice = Utils.initialMenuChoice;
		while (choice != Utils.exitMenu) {
			System.out.println("Welcome to the restaurants system!");
			printMenuOption(Utils.menuTags.PRINT_ALL_RES.ordinal());
			printMenuOption(Utils.menuTags.ADD_RES.ordinal());
			printMenuOption(Utils.menuTags.ADD_REV.ordinal());
			printMenuOption(Utils.menuTags.RES_DETAILS.ordinal());
			printMenuOption(Utils.menuTags.CREATE_POLL.ordinal());
			printMenuOption(Utils.menuTags.ADD_USER.ordinal());
			System.out.println("Press "+Utils.exitMenu+" to exit");
			
			choice = Integer.parseInt(MyScanner.scanner.nextLine());
			
			if (choice != Utils.exitMenu)
				activateMenuChoice(choice);
			
		}
		
		MyScanner.scanner.close();
	}
	
	private void printMenuOption(int optionIndex) {
		
		System.out.println("Press "+optionIndex+Utils.menuOptions[optionIndex]);
	}
	
	private void activateMenuChoice(int choice){
		
		menuFuncs[choice - 1].execute();	
		System.out.println();
	}
	
}