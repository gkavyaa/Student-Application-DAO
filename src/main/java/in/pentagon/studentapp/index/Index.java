package in.pentagon.studentapp.index;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int choice=0;
		
		System.out.println("Welcome to MyStudent Application..!");
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGOT PASSWORD");
			System.out.println("4. EXIT");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: Signup.signup();
				break;
			case 2: Login.login();
				break;
			case 3: //ForgotPassword.forgotpassword();
				break;
			case 4: //Exit.exit();
				break;
			default:System.out.println("Invalid Choice!Please enter a valid choice");	
			}
			}
			while(choice!=4);
	
	}



}


		
	




