import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;


public class Restaurant {
	
	protected String resType;
	protected String resId;
	protected String resName;
	protected String resDesc;
	protected String resAddr;
	protected double avgTime;
	protected ArrayList<String> resReviews = new ArrayList<String>();
	protected boolean[] resTags = new boolean[5];
	protected int grade;
	
	public Restaurant(){
		createNewRestaurant();
	}
	
	
	private void createNewRestaurant() throws InvalidParameterException{
	
		//Scanner scanRes = new Scanner(System.in);
		
		System.out.println("Enter the restaurant id");
		this.resId = FirstProject.myScanner.nextLine();
		
		
		System.out.println("Enter the restaurant name (Up to 20 chars)");
		String tmpName = FirstProject.myScanner.nextLine();
		if(tmpName.length()>20){
			FirstProject.myScanner.close();
			throw new InvalidParameterException();
		}
		this.resName = tmpName;
		
		System.out.println("Enter the restaurant description (Up to 100 chars)");
		String tmpDesc = FirstProject.myScanner.nextLine();
		if(tmpDesc.length()>100){
			FirstProject.myScanner.close();
			throw new InvalidParameterException();
		}
		this.resDesc = tmpDesc;
		
		System.out.println("Enter the restaurant address");
		this.resAddr = FirstProject.myScanner.nextLine();
		
		System.out.println("Enter the restaurant delivery time");
		this.avgTime = FirstProject.myScanner.nextDouble();
		
		FirstProject.myScanner.nextLine();
		
		System.out.println("Is the restaurant alcoholic(y/n)?");
		resTags[RestaurantSystem.ALCH] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant dateable(y/n)?");
		resTags[RestaurantSystem.DATE] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant ac(y/n)?");
		resTags[RestaurantSystem.AC] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant smoking(y/n)?");
		resTags[RestaurantSystem.SMOKE] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		System.out.println("Is the restaurant vegeterian(y/n)?");
		resTags[RestaurantSystem.VEGAN] = FirstProject.myScanner.next().charAt(0)=='y' ? true : false;
		
		FirstProject.myScanner.nextLine();
		
		System.out.println("Enter the restaurant type (barRestaurant/TA) or any other");
		this.resType = FirstProject.myScanner.nextLine();
		
		this.grade = 0;
		
		System.out.println("Restaurant was added");
		
	}


	public void addReviewToRes() {
		
		System.out.println("Enter the review (Up to 500 chars)");
		String tmpReview = FirstProject.myScanner.nextLine();
		if(tmpReview.length()>500){
			FirstProject.myScanner.close();
			throw new InvalidParameterException();
		}
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
		System.out.println("Restaurant is alcoholic: "+((resTags[RestaurantSystem.ALCH]) ? "Yes" : "No"));
		System.out.println("Restaurant is datable: "+((resTags[RestaurantSystem.DATE]) ? "Yes" : "No"));
		System.out.println("Restaurant is ac: "+((resTags[RestaurantSystem.AC]) ? "Yes" : "No"));
		System.out.println("Restaurant is smoking: "+((resTags[RestaurantSystem.SMOKE]) ? "Yes" : "No"));
		System.out.println("Restaurant is vegeterian: "+((resTags[RestaurantSystem.VEGAN]) ? "Yes" : "No"));
		System.out.println("Retaurant reviews:");
		System.out.println(Arrays.toString(this.resReviews.toArray()));
		
	}
	
	public void addToGrade(int toAdd){
		this.grade+=toAdd;
	}
	
	
}
