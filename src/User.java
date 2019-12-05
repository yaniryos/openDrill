
public class User extends Utils {
	
	protected String userId;
	
	public User(){
		
		createNewUser();
	}
	
	public void createNewUser(){
		
		System.out.println("Enter the user id");
		this.userId = MyScanner.scanner.nextLine();

		getAndSetAllPrefrences();
		
		MyScanner.scanner.nextLine();
		
		System.out.println("User was added");
	}

	@Override
	public String getStringData() {
		
		return userId;
	}
	
}
