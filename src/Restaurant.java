import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant extends Utils {
	
	protected String resType;
	protected String resId;
	protected String resName;
	protected String resDesc;
	protected String resAddr;
	protected double avgTime;
	protected int resGrade;
	protected ArrayList<String> resReviews = new ArrayList<String>();
	
	public Restaurant(){
		
		createNewRestaurant();
	}	
	
	private void createNewRestaurant() throws InvalidParameterException{
		
		System.out.println("Enter the restaurant id");
		this.resId = MyScanner.scanner.nextLine();
		
		System.out.println("Enter the restaurant name (Up to "+maxResNameLength+" chars)");
		String tmpName = MyScanner.scanner.nextLine();
		checkIfStringValidLength(tmpName, maxResNameLength);
		this.resName = tmpName;
		
		System.out.println("Enter the restaurant description (Up to "+maxResDescLength+" chars)");
		String tmpDesc = MyScanner.scanner.nextLine();
		checkIfStringValidLength(tmpDesc, maxResDescLength);
		this.resDesc = tmpDesc;
		
		System.out.println("Enter the restaurant address");
		this.resAddr = MyScanner.scanner.nextLine();
		
		System.out.println("Enter the restaurant delivery time");
		this.avgTime = MyScanner.scanner.nextDouble();
		
		MyScanner.scanner.nextLine();
		
		getAndSetAllPrefrences();
		
		MyScanner.scanner.nextLine();
		
		System.out.println("Enter the restaurant type (barRestaurant/TA) or any other");
		this.resType = MyScanner.scanner.nextLine();
		
		this.resGrade = initialResGrade;
		
		System.out.println("Restaurant was added");
	}


	public void addReviewToRes() {
		
		System.out.println("Enter the review (Up to "+maxResReviewLength+" chars)");
		String tmpReview = MyScanner.scanner.nextLine();
		checkIfStringValidLength(tmpReview, maxResReviewLength);
		this.resReviews.add(tmpReview);
		System.out.println("Thank you for your review");
	}


	public void showDetailsOfRes() {
		
		System.out.println("Restaurant Details:");
		System.out.println("Restaurant id: "+this.resId);
		System.out.println("Restaurant name: "+this.resName);
		System.out.println("Restaurant type: "+this.resType);
		System.out.println("Restaurant description: "+this.resDesc);
		System.out.println("Restaurant address: "+this.resAddr);
		System.out.println("Restaurant delivery time: "+this.avgTime);
		System.out.println("Restaurant is alcoholic: "+((prefrences[Utils.TAGS.ALCH.ordinal()]) ? "Yes" : "No"));
		System.out.println("Restaurant is datable: "+((prefrences[Utils.TAGS.DATE.ordinal()]) ? "Yes" : "No"));
		System.out.println("Restaurant is ac: "+((prefrences[Utils.TAGS.AC.ordinal()]) ? "Yes" : "No"));
		System.out.println("Restaurant is smoking: "+((prefrences[Utils.TAGS.SMOKE.ordinal()]) ? "Yes" : "No"));
		System.out.println("Restaurant is vegeterian: "+((prefrences[Utils.TAGS.VEGET.ordinal()]) ? "Yes" : "No"));
		System.out.println("Retaurant reviews:");
		System.out.println(Arrays.toString(this.resReviews.toArray()));
	}
	
	public void addToGrade(int gradeToAdd){
		
		this.resGrade+=gradeToAdd;
	}


	@Override
	public String getStringData() {
		
		return resName;
	}
}
