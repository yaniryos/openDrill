
public class AddNewUser extends Functor {

	public void execute(){
		
		RestaurantSystem.allUser.add(new User());
	}
}
