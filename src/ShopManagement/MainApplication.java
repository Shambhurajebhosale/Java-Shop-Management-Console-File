package ShopManagement;

import java.io.IOException;
import java.util.Scanner;
import ProductManagement.Product_Management;
import UserManagement.User_Management;
public class MainApplication {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		boolean canIKeepRunningTheProgram = true;
		System.out.println("  WELCOME TO SHOP MANAGEMENT");
		System.out.println("\n");
		System.out.println("Enter login name : ");
		String loginName = scanner.nextLine();
		System.out.println("Enter password : ");
		String password = scanner.nextLine();

		if(User_Management.validateUserAndPassword(loginName, password)) 
		{
			System.out.println(" Login Failed ..! ");
			return;
		}
		while (canIKeepRunningTheProgram == true) {
			System.out.println(" Welcome to Shop Management ");
			System.out.println("\n");
			System.out.println("What  you Interested   to do ?");
			System.out.println("1. User Management");
			System.out.println("2. Product Management");
			System.out.println("3. Quit");
			int optionSelectedByUser = scanner.nextInt();
			if (optionSelectedByUser == 1) {
				User_Management.User_Management();
			} else if (optionSelectedByUser == 2) {
				Product_Management.Product_Management();
			} else if (optionSelectedByUser == 3) {
				break;
			}
		}
	}
}
