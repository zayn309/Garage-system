import java.util.Scanner;

public class authentication {
    private String Password;
    authentication(){
        Password = "00000";
    }
    public void changePassword(String s){
		Password = s;
	}
    public boolean LogIntoGarage(){
		System.out.print("please enter the password: ");
		Scanner obj = new Scanner(System.in);
		
		String value = obj.nextLine();
		obj = null;
			
		obj = new Scanner(System.in);		

		if(value.equals(Password)){return true;}
		else {return false;}
	}
	
}
