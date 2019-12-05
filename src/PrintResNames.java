
public class PrintResNames extends Functor {

	public void execute(){
		
		printResNames();
	}
	
	public static void printResNames() {
		
		System.out.print("Restaurants Names: ");
		Utils.print((Utils[])RestaurantSystem.allRes.toArray());
	}
}
