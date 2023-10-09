package UserManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class User_Management {
	static ArrayList<User> list = new ArrayList();			
	public static void User_Management() throws IOException {			
		loadDataFromFileToArrayList();
		Scanner sc = new Scanner(System.in);			
		boolean CanIKeepRunningTheProgram = true;			
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("## WELCOME TO USER MANAGEMENT PROGRAM ##");				
			System.out.println("\n");
			System.out.println("What  you are Interested  to do");
			System.out.println("1. Add User");
			System.out.println("2. Edit User");
			System.out.println("3. Delete User");
			System.out.println("4. Search User");
			System.out.println("5. Quit");				
			int OptionSelectedByUser = sc.nextInt();				
			 {										
				File file = new File("C:\\Users\\Somna\\eclipse-workspace\\ShopManagement1\\src\\User_Management\\Required");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(User user:list)
				{
					System.out.println(user.Loginname+","+user.Password+","+user.Username+","+user.UserRole+"\n");
					bufferedWriter.write(user.Loginname+","+user.Password+","+user.Username+","+user.UserRole+"\n");
				}					
				bufferedWriter.close();
				fileWriter.close();
				file=null;		
				CanIKeepRunningTheProgram = false;
				System.out.println("!! PROGRAM CLOSED !!");
			}		
		}
		System.out.println("\n");
		System.out.println(" After While Loop ");
		for(User u:list) {
			System.out.println("UserName is :"+u.Username);
			System.out.println("LoginName is :"+u.Loginname);
			System.out.println("Password is :"+u.Password);
			System.out.println("ConfirmPassword is :"+u.ConfirmPassword);
			System.out.println("UserRole is :"+u.UserRole);
			System.out.println("\n");
		}
	}
	public static void AddUser() {
		Scanner sc = new Scanner(System.in);
		User u = new User();		
		System.out.print("Enter User Name :");
		u.Username = sc.nextLine();		
		System.out.print("Enter Login Name :");
		u.Loginname = sc.nextLine();
		System.out.print("Enter Password :");
		u.Password = sc.nextLine();		
		System.out.print("Enter Confirm Password :");
		u.ConfirmPassword = sc.nextLine();		
		System.out.print("Enter User Role :");
		u.UserRole = sc.nextLine();		
		System.out.println("\n");
		System.out.println("User Name is :"+u.Username);
		System.out.println("Login Name is :"+u.Loginname);
		System.out.println("Password is :"+u.Password);
		System.out.println("Confirm Password is :"+u.ConfirmPassword);
		System.out.println("User Role is :"+u.UserRole);	
		list.add(u);
	}
	public static void EditUser(String Username) {
		for(User u:list) {
			if(u.Username.equalsIgnoreCase(Username)) {
				Scanner sc = new Scanner(System.in);				
				System.out.println("Enter User Name :"+u.Username);
				System.out.print("New User Name is :");
				u.Username = sc.nextLine();				
				System.out.print("New Login Name is :");
				u.Loginname = sc.nextLine();
				System.out.print("New password is :");
				u.Password = sc.nextLine();
				System.out.print("New Confirm Password is :");
				u.ConfirmPassword = sc.nextLine();				
				System.out.print("New User Role is :");
				u.UserRole = sc.nextLine();				
				System.out.println("User Information is updated");
				return;
			}
		}
		System.out.println("!!!!! User Not Found !!!!!");		
	}
	public static void SearchUser(String Username) {
		for(User u:list) {
			if(u.Username.equalsIgnoreCase(Username)) {
				System.out.println("User Name is :"+u.Username);
				System.out.println("Login Name is :"+u.Loginname);
				System.out.println("Password is :"+u.Password);
				System.out.println("Confirm Password is :"+u.ConfirmPassword);
				System.out.println("User Role is :"+u.UserRole);
				return;
			}
		}
		System.out.println("!!!! USER NOT FOUND !!!!");
	}
	public static void DeleteUser(String Username) {
		Iterator<User> itr = list.iterator();
		while(itr.hasNext()) {
			User u = itr.next();
			if(u.Username.equalsIgnoreCase(Username)) {
				itr.remove();
				System.out.println("User "+u.Username+" has been deleted");
				break;
			}
		}
	}	
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Shambhuraje\\eclipse-workspace\\ShopManagement\\src\\User_Management\\Required");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			User user = new User();
			String [] userDataArray = line.split(",");
			if(userDataArray.length>3)
			{
				user.Loginname = userDataArray[0];
				user.Password = userDataArray[1];
				user.Username = userDataArray[2];
				user.UserRole = userDataArray[3];
				list.add(user);	
			}		
		}
		br.close();
		fr.close();
		file=null;
	}
	public static boolean validateUserAndPassword(String loginName, String password, ArrayList<User> al) throws IOException {
	Iterator<User> userIterator = al.iterator();
	ArrayList<User> al;
	Iterator<User>itr= al.iterator();
	while(itr.hasNext()) {
		User u=itr.next();	
			System.out.println("Login Succesfully");
			return true;
		}
	}
	public static boolean validateUserAndPassword(String loginName, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}

