import java.security.InvalidParameterException;
import java.util.Arrays;

public abstract class Utils {
	
	protected enum TAGS {ALCH,DATE,AC,SMOKE,VEGET};
	protected enum menuTags {DUMMY,PRINT_ALL_RES,ADD_RES,ADD_REV,RES_DETAILS,CREATE_POLL, ADD_USER};
	protected boolean[] prefrences = new boolean[TAGS.values().length];
	protected final int maxResNameLength = 20;
	protected final int maxResDescLength = 100;
	protected final int maxResReviewLength = 500;
	protected final int initialResGrade = 0;
	protected static final int initialMenuChoice = 0;
	protected static final int exitMenu = -1;
	protected static final String[] menuOptions = {"DUMMY", 
													" to print all the resyaurant names",
													" to add a new restaurant",
													" to write a review for a restaurant",
													" to get s specific restaurant's details",
													" to create a poll",
													" to add a user"};

	public abstract String getStringData();
	
	public static boolean allMatch(User usr, Restaurant res) {
		
	    Boolean[] equalCheck = new Boolean[TAGS.values().length];
		Arrays.setAll(equalCheck, i -> usr.prefrences[i]==res.prefrences[i]);
		return Arrays.asList(equalCheck).stream().reduce(true,(element1,element2) -> element1&element2);
	}
	
	public static void print(Object[] resOrUserArray){
		
		Arrays.stream(resOrUserArray).forEach(a -> {
									if (Arrays.asList(resOrUserArray).indexOf(a)==0)
										System.out.print("["+((Utils)a).getStringData()+",");
									else if(Arrays.asList(resOrUserArray).indexOf(a)==resOrUserArray.length-1)
										System.out.print(((Utils)a).getStringData()+"]");
									else System.out.print(((Utils)a).getStringData()+",");
		});
	}
	
	public void getAndSetAllPrefrences(){
		
		System.out.println("Is the restaurant alcoholic(y/n)?");
		getAndSetPrefrence(Utils.TAGS.ALCH.ordinal());
		
		System.out.println("Is the restaurant dateable(y/n)?");
		getAndSetPrefrence(Utils.TAGS.DATE.ordinal());
		
		System.out.println("Is the restaurant ac(y/n)?");
		getAndSetPrefrence(Utils.TAGS.AC.ordinal());
		
		System.out.println("Is the restaurant smoking(y/n)?");
		getAndSetPrefrence(Utils.TAGS.SMOKE.ordinal());
		
		System.out.println("Is the restaurant vegeterian(y/n)?");
		getAndSetPrefrence(Utils.TAGS.VEGET.ordinal());
	}
	
	public void getAndSetPrefrence(int prefIndex){
		
		prefrences[prefIndex] = MyScanner.scanner.next().charAt(0)=='y' ? true : false;
	}
	
	public void checkIfStringValidLength(String myString, int maxLength) throws InvalidParameterException{
		
		if (myString.length()>maxLength){
			MyScanner.scanner.close();
			throw new InvalidParameterException();
		}
	}
}
