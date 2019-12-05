
public class AddResReview extends Functor{

	public void execute(){
		
		addReview();
	}
	
	public static void addReview(){
		
		System.out.println("Enter the restaurant id");
		String tmpId = MyScanner.scanner.nextLine();
		
		for (Restaurant res : RestaurantSystem.allRes)
			if (res.resId.equals(tmpId))
				res.addReviewToRes();
	}
}
