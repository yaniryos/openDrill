
public class ShowResDetails extends Functor {

	public void execute(){
		
		showDetails();
	}
	
	public static void showDetails() {
		
		System.out.println("Enter the restaurant id");
		String tmpId = MyScanner.scanner.nextLine();
		
		for (Restaurant res : RestaurantSystem.allRes)
			if (res.resId.equals(tmpId))
				res.showDetailsOfRes();
	}
}
