package ProductManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;
public class Product_Management {
	static ArrayList<Product> array = new ArrayList();
	public static void Product_Management() throws IOException
	{
		loadDataFromFileToArrayList();
		Scanner s = new Scanner(System.in);	
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("!!!!! Welcome To Product Management System !!!!!");
			System.out.println("\n");
			System.out.println("What Would like to do ?");
			System.out.println("1. Add Product");
			System.out.println("2. Edit Product");
			System.out.println("3. Search Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Quit");	
			int OptionSelectedByUser = s.nextInt();	
			if(OptionSelectedByUser == 5)
			{
				File file = new File("C:\\Users\\Somna\\eclipse-workspace\\ShopManagement1\\src\\Product_Management\\productss");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(Product product:array)
				{
					System.out.println(product.ProductName+","+product.Productid+","+product.ProductPrice+","+product.ProductQuantity+","+product.ProductCategory+"\n");
					bufferedWriter.write(product.ProductName+","+product.Productid+","+product.ProductPrice+","+product.ProductQuantity+","+product.ProductCategory+"\n");
				}					
				bufferedWriter.close();
				fileWriter.close();
				file=null;					
				System.out.println("!! Program Closed !!");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelectedByUser == 1)
			{
				AddProduct();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == 2)
			{
				System.out.println("Enter the name of product which you want to edit :");
				s.nextLine();
				String Productname = s.nextLine();
				EditProduct(Productname);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == 3)
			{
				System.out.println("Enter Product name which you want to search :");
				s.nextLine();
				String Productname = s.nextLine();
				SearchProduct(Productname);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == 4)
			{
				System.out.println("Enter Product name which you want to delete");
				s.nextLine();
				String Productname = s.nextLine();
				DeleteProduct(Productname, null);
				System.out.println("\n");
			}
		}
		System.out.println("\n");
		System.out.println("!!! After While Loop !!!");
		for(Product u:array) 
		{
			System.out.println("Product Name is :"+u.ProductName);
			System.out.println("Product ID is :"+u.Productid);
			System.out.println("Product Price is :"+u.ProductPrice);
			System.out.println("Product Quantity is :"+u.ProductQuantity);
			System.out.println("Product Category is :"+u.ProductCategory);
		}						
	}
	public static void AddProduct()
	{
		Scanner s = new Scanner(System.in);
		Product u = new Product();
		System.out.println("Enter Product name :");
		u.ProductName = s.nextLine();
		System.out.println("Enter Product ID :");
		u.Productid = s.nextLine();
		System.out.println("Enter Product Price :");
		u.ProductPrice = s.nextLine();
		System.out.println("Enter Product Quantity :");
		u.ProductQuantity = s.nextLine();
		System.out.println("Enter Product Category :");
		u.ProductCategory = s.nextLine();			
		array.add(u);		
		System.out.println("Product Name is :"+u.ProductName);
		System.out.println("Product ID is :"+u.Productid);
		System.out.println("Product Price is :"+u.ProductPrice);
		System.out.println("Product Quantity is :"+u.ProductQuantity);
		System.out.println("Product Category is :"+u.ProductCategory);
	}
	public static void EditProduct(String Productname)
	{
		for (Product u : array)
		{
		    if(u.ProductName.equalsIgnoreCase(Productname))
		    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Current Product name is :"+u.ProductName);
		System.out.println("Enter new Product name :");
		u.ProductName = sc.nextLine();
		System.out.println("Enter new Product ID :");
		u.Productid = sc.nextLine();
		System.out.println("Enter new price of product :");
		u.ProductPrice = sc.nextLine();
		System.out.println("Enter new qantity of product :");
		u.ProductQuantity = sc.nextLine();
		System.out.println("Enter new category of product :");
		u.ProductCategory = sc.nextLine();			
		System.out.println("New Product Name is :"+u.ProductName);
		System.out.println("New Product ID is :"+u.Productid);
		System.out.println("New Product Price is :"+u.ProductPrice);
		System.out.println("New Product Quantity is :"+u.ProductQuantity);
		System.out.println("New Product Category is :"+u.ProductCategory);
		return;
		}
		}
		System.out.println(" Product Not Found ");	
	}
	public static void SearchProduct(String Productname)
	{
		for(Product u :array )
		{
			if(u.ProductName.equalsIgnoreCase(Productname))
			{
				System.out.println("Product Name is :"+u.ProductName);
				System.out.println("Product ID is :"+u.Productid);
				System.out.println("Product Price is :"+u.ProductPrice);
				System.out.println("Product Quantity is :"+u.ProductQuantity);
				System.out.println("Product Category is :"+u.ProductCategory);
			}
		}
		System.out.println("!!!!! Product Not Found !!!!!");
	}
	public static void DeleteProduct(String Productname, java.util.Iterator<Product> itr)
	{
		
		while(itr.hasNext())
		{
			Product u = itr.next();
			if(u.ProductName.equalsIgnoreCase(Productname))
			{
				itr.remove();
				System.out.println("Product "+u.ProductName +"has been deleted");
				break;
			}
		}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Somna\\eclipse-workspace\\ShopManagement1\\src\\Product_Management\\productss");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			Product product = new Product();
			String [] userDataArray = line.split(",");
			if(userDataArray.length>3)
			{
				product.ProductName = userDataArray[0];
				product.Productid = userDataArray[1];
				product.ProductPrice = userDataArray[2];
				product.ProductQuantity = userDataArray[3];
				product.ProductCategory = userDataArray[4];	
				array.add(product);	
		}		
		}
		br.close();
		fr.close();
		file=null;
	}
}
