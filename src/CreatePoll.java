import java.util.ArrayList;
import java.util.Arrays;

public class CreatePoll extends Functor{

	protected static ArrayList<String> pollNames = new ArrayList<String>();
	protected static ArrayList<User> pollUsers = new ArrayList<User>();
	protected static ArrayList<String> matchingResByUser = new ArrayList<String>();
	protected static ArrayList<String> mathcingResDataByUserToPrint = new ArrayList<String>();
	protected static Restaurant winningRes;
	protected static String chosenRes;
	
	public void execute(){
		
		activatePoll();
	}

	public static void activatePoll() {
		
		getUserNames();
		findUsers();
		findMatchingResByUser();
		printMatchingResByUser();
		findChosenRes();
		closePoll();
		clearLists();
		
	}

	private static void getUserNames() {
		
		System.out.print("Enter the participants in the poll (seperate by a comma), available users: ");
		Utils.print(RestaurantSystem.allUser.toArray());
		pollNames.addAll(Arrays.asList(MyScanner.scanner.nextLine().split(",")));
	}

	private static void findUsers() {
		
		for (User usr : RestaurantSystem.allUser)
			if (pollNames.contains(usr.userId))
				pollUsers.add(usr);
	}

	private static void findMatchingResByUser() {
		
		boolean allMatch = true;
		for (Restaurant res : RestaurantSystem.allRes){
			for (User usr: pollUsers){
				if (!Utils.allMatch(usr,res)){
					allMatch=false;
				}
			}
			if (allMatch){
				matchingResByUser.add(res.resId);
				mathcingResDataByUserToPrint.add(res.resId + " (grade: "+ res.resGrade+")");
			}
			allMatch=true;
		}
	}

	private static void printMatchingResByUser() {
		
		System.out.print("The matching restaurants are: ");
		System.out.println(Arrays.toString(mathcingResDataByUserToPrint.toArray()));	
	}
	
	private static void findChosenRes() {
		
		if (!matchingResByUser.isEmpty()){
			System.out.println("The winner restaurant is:");
			chosenRes = MyScanner.scanner.nextLine();
		}
	}


	private static void closePoll() {
		
		if (matchingResByUser.contains(chosenRes))
			addGradeToRes();
		else System.out.println("No matching resturant");
	}
	
	private static void addGradeToRes(){
		
		for (Restaurant res : RestaurantSystem.allRes){
			if (res.resId.equals(chosenRes)){
				res.addToGrade(pollUsers.size());
				winningRes=res;
				printFinalQuestion();
			}
		}
	}
	
	private static void printFinalQuestion() {
		
		System.out.println("Would you like to "+((winningRes.resType.equals("TA")) ? "order?" : "book a reservation?"));
	}

	private static void clearLists() {
		
		pollNames = new ArrayList<String>();
		pollUsers = new ArrayList<User>();
		matchingResByUser = new ArrayList<String>();
		mathcingResDataByUserToPrint = new ArrayList<String>();
	}
}
