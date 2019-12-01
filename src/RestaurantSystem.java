import java.util.ArrayList;
import java.util.Arrays;


public class RestaurantSystem {

	protected final static int ALCH = 0;
	protected final static int DATE = 1;
	protected final static int AC = 2;
	protected final static int SMOKE = 3;
	protected final static int VEGAN = 4;
	
	private Functor[] menuFuncs = new Functor[6];
	protected static ArrayList<Restaurant> allRes = new ArrayList<Restaurant>(); 
	protected static ArrayList<User> allUser = new ArrayList<User>();
	
	public RestaurantSystem(){
		
		menuFuncs[0] = new PrintResNames();
		menuFuncs[1] = new AddNewRes();
		menuFuncs[2] = new AddResReview();
		menuFuncs[3] = new ShowResDetails();
		menuFuncs[4] = new CreatePoll();
		menuFuncs[5] = new AddNewUser();
		systemActivate();
	}
	
	private void systemActivate(){
		
		int choice = 0;
		while(choice!=-1){
			
			System.out.println("Welcome to the restaurants system!");
			System.out.println("Press 1 to print all the resyaurant names");
			System.out.println("Press 2 to add a new restaurant");
			System.out.println("Press 3 to write a review for a restaurant");
			System.out.println("Press 4 to get s specific restaurant's details");
			System.out.println("Press 5 to create a poll");
			System.out.println("Press 6 to add a user");
			System.out.println("Press -1 to exit");
		
			choice = Integer.parseInt(FirstProject.myScanner.nextLine());
			if(choice!=-1)
				activateMenuChoice(choice);
			
		}
		FirstProject.myScanner.close();
	}
	
	
	private void activateMenuChoice(int choice){
		menuFuncs[--choice].execute();	
		System.out.println();
	}
	
	public static void addReview(){
		
		System.out.println("Enter the restaurant id");
		String tmpId = FirstProject.myScanner.nextLine();
		
		for(Restaurant res : allRes)
			if(res.resId.equals(tmpId))
				res.addReviewToRes();
	}

	public static void showDetails() {
		
		System.out.println("Enter the restaurant id");
		String tmpId = FirstProject.myScanner.nextLine();
		
		for(Restaurant res : allRes)
			if(res.resId.equals(tmpId))
				res.showDetailsOfRes();
	}

	public static void activatePoll() {
		
		
		System.out.print("Enter the participants in the poll (seperate by a comma), available users: [");
		for(int i=0; i<allUser.size()-1; i++){
			System.out.print(allUser.get(i).userId+", ");
		}
		if(RestaurantSystem.allUser.size()!=0)
			System.out.print(allUser.get(allUser.size()-1).userId);
		System.out.println("]");
		
		ArrayList<String> pollNames = new ArrayList<String>();
		pollNames.addAll(Arrays.asList(FirstProject.myScanner.nextLine().split(",")));
		 
		findUsers(pollNames);
	}

	private static void findUsers(ArrayList<String> pollNames) {
		
		ArrayList<User> pollUsers = new ArrayList<User>();
		
		for(String str: pollNames)
			for(User usr : allUser)
				if(usr.userId.equals(str))
					pollUsers.add(usr);
		
		findMatchingRes(pollUsers);
	}

	private static void findMatchingRes(ArrayList<User> pollUsers) {
		
		ArrayList<String> matchingResNames = new ArrayList<String>();
		ArrayList<String> matchingResData = new ArrayList<String>();
		boolean allMatch = true;
		
		for(Restaurant res : allRes){
			for(User usr: pollUsers){
				if(!allMatch(usr,res)){
					allMatch=false;
				}
			}
			if(allMatch){
				matchingResNames.add(res.resId);
				matchingResData.add(res.resId + " (grade: "+ res.grade+")");
			}
			allMatch=true;
		}
		
		System.out.print("The matching restaurants are: ");
		System.out.println(Arrays.toString(matchingResData.toArray()));
		
		finalizeOrder(matchingResNames, pollUsers.size());
		
	}

	private static void finalizeOrder(ArrayList<String> matchingRes, int pollUsersSize) {
		
		System.out.println("The winner restaurant is:");
		String winRes = FirstProject.myScanner.nextLine();
		
		if(matchingRes.contains(winRes))
			updateResGrade(winRes, pollUsersSize);
		else System.out.println("Not such resturant");
	}


	private static void updateResGrade(String resName,  int pollUsersSize) {
		
		for(Restaurant res : allRes){
			if(res.resId.equals(resName)){
				res.addToGrade(pollUsersSize);
				System.out.println("Would you like to "+((res.resType.equals("TA")) ? "order?" : "book a reservation?"));
			}
		}
	}

	private static boolean allMatch(User usr, Restaurant res) {
		
		return res.resTags[ALCH] == usr.userTags[ALCH] &&
					res.resTags[DATE] == usr.userTags[DATE] &&
						res.resTags[AC] == usr.userTags[AC] &&
							res.resTags[SMOKE] == usr.userTags[SMOKE] &&
								res.resTags[VEGAN] == usr.userTags[VEGAN];
				
		
	}

	public static void printResNames() {
		
		System.out.print("Restaurant Names: [");
		for(int i=0; i<RestaurantSystem.allRes.size()-1; i++){
			System.out.print(RestaurantSystem.allRes.get(i).resName+", ");
		}
		if(RestaurantSystem.allRes.size()!=0)
			System.out.print(RestaurantSystem.allRes.get(RestaurantSystem.allRes.size()-1).resName);
		System.out.println("]");
	}
	
}
