package bean;

public class uservaliator {
	public static boolean isvalid(user ongoinguser) {
		boolean valid=false;
		String UserName=ongoinguser.getusername();
		String Password=ongoinguser.getPassword();
		
		if(UserName.equals("Rushi") && Password.equals("Rushi@123")) {
			valid=true;
			
		}
		return valid;

	}

}
