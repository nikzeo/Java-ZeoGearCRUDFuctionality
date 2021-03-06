package connect;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerInput {
	
	private static Scanner scan = new Scanner(System.in);
	public CustomerDB cdb;
	public ItemsDB idb;
	public OrdersDB odb;
	
	public CustomerInput() throws SQLException {
		cdb = new CustomerDB();
		idb = new ItemsDB();
		odb = new OrdersDB();
	}
	
	public void showStartingSelection() throws SQLException {
		System.out.println("\nHello, Welcome to ZEOGEAR"
				+ "\n\n -----\n     /\n   /\n /\n ----- \n\n------------------------------------------\n"
				+ "Press 1 for Customer Related Queries \nPress 2 for Product/Item Related Queries \nPress 3 for Order Related Queries"
				+ "\n------------------------------------------");
		String selection = scan.nextLine();
		
		switch(selection) {
			case "1":
				showCustomerQueries();
				break;
			case "2":
				showItemQueries();
				break;
			case "3":
				showOrderQueries();
				break;
			default: 
				System.out.println("Try again!");
				showStartingSelection();
		}
	}
	
	
	public void showCustomerQueries() throws SQLException {
		System.out.println("Type 1 to Create a New Customer\nType 2 to View Customers\nType 3 to Delete Customers\nType 4 to Update a Customer");
		String selection = scan.nextLine();

		switch (selection) {
			case "1": 
				createCustomer();
				break;
			case "2":
				viewCustomers();
				break;
			case "3":
				deleteCustomer();
				break;
			case "4":
				updateCustomer();
				break;
			default:
				System.out.println("Try again!");
				showCustomerQueries();
			}
	}
	
	public void createCustomer() throws SQLException {
		System.out.println("Enter first name: ");
		String firstname = scan.nextLine();

		System.out.println("Enter last name: ");
		String lastname = scan.nextLine();

		System.out.println("Enter email: ");
		String email = scan.nextLine();
			
		System.out.println("Enter the First Line of the Address");
		String fstlnaddress = scan.nextLine();
			
		System.out.println("Enter the Postcode");
		String postcode = scan.nextLine();
			
		cdb.create(firstname, lastname, email, fstlnaddress, postcode);
		System.out.println("\nCustomer Successfully Created!\n");
		showStartingSelection();
	}
	
	public void viewCustomers() throws SQLException {
		cdb.readCustomer();
		System.out.println("\nType 'Y' when you would like to go back to the Main Menu\n");
		
		while(true) {
			String result = scan.nextLine();
			if (result.equals("Y") || result.equals("y")) {
				showStartingSelection();
				break;
			}
		}
	}
	
	public void deleteCustomer() throws SQLException {
		System.out.println("Enter the Customer ID:");
		int customer_id1 = Integer.parseInt(scan.nextLine());
		cdb.deleteCustomer(customer_id1);
		System.out.println("\nCustomer Successfully Deleted!\n");
		showStartingSelection();
	}
	
	public void updateCustomer() throws SQLException {
		System.out.println("Enter Customer ID ");
		int customer_id = scan.nextInt();
		scan.nextLine();
			
		System.out.println("Enter Updated First Name ");
		String firstname = scan.nextLine();
			
		System.out.println("Enter Updated Last Name ");
		String lastname = scan.nextLine();
			
		System.out.println("Enter Updated Email ");
		String email = scan.nextLine();
		
		System.out.println("Enter Updated First Line of the Address");
		String fstlnaddress = scan.nextLine();
			
		System.out.println("Enter Updated Postcode");
		String postcode = scan.nextLine();

		cdb.updateCustomer(customer_id, firstname, lastname, email, fstlnaddress, postcode);	

		System.out.println("\nUpdate Successful!\n");
		showStartingSelection();
	}

		
	public void showItemQueries() throws SQLException {
		System.out.println("Type 1 to Create a New Item\nType 2 to View Items\nType 3 to Delete Items\nType 4 to Update an Item");
		String selection = scan.nextLine();

		switch (selection) {
			case "1":
				createItem();
				break;
			case "2":
				viewItems();
				break;
			case "3":
				deleteItem();
				break;
			case "4":
				updateItem();
				break;
			default:
				System.out.println("Try again!");
				showItemQueries();
				
			}
	}
					
	
	public void createItem() throws SQLException {
		System.out.println("Insert New Item ");
		String name = scan.nextLine();
		
		System.out.println("Insert Price (�) ");
		double price = scan.nextDouble(); 
		scan.nextLine();
		
		idb.createitem(name, price);
		System.out.println("\nItem Succesfully Created!\n");
		showStartingSelection();
		
	}
	
	public void viewItems() throws SQLException {
		idb.viewItem();
		System.out.println("\nType 'Y' to go back to the Main Menu\n");
			
		while(true) {
			String itemresult = scan.nextLine();
			if (itemresult.equals("Y") || itemresult.equals("y")) {
				showStartingSelection();
				break;
			}
		}	
	}	
	
	public void deleteItem() throws SQLException {
		System.out.println("Enter Product_ID");
		int product_id = Integer.parseInt(scan.nextLine());
		idb.deleteItem(product_id);
		System.out.println("\nItem Successfully Deleted!\n");
		showStartingSelection();
	}
	
	
	public void updateItem() throws SQLException {
		System.out.println("Enter Product_ID");
		int product_id = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter Updated Name");
		String name = scan.nextLine();
		
		System.out.println("Enter Updated Price");
		double price = scan.nextInt();
		scan.nextLine();
	
		idb.updateItem(product_id, name, price);
		
		System.out.println("\nUpdate Succesfull!\n");
		showStartingSelection();

	}
		
	public void showOrderQueries() throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("Type 1 to Create a New Order\nType 2 to View Orders\nType 3 to Delete Order\nType 4 to Update an Order\nType 5 to to Calculate an Order Value");
		String selection = scan.nextLine();
		
		switch (selection) {
			case "1":
				createOrder();
				break;
			case "2":
				viewOrder();
				break;
			case "3":
				deleteOrder();
				break;
			case "4":
				updateOrder();
				break;
			case "5":
				calculateOrder();
				break;

			default:
				System.out.println("Try again!");
				showItemQueries(); }
			
		}	
		
		
	public void createOrder() throws SQLException {
			System.out.println("Enter Customer's ID");
			int customer_id = scan.nextInt();
			scan.nextLine();
		
			System.out.println("Enter Relevant Product ID");
			int product_id = scan.nextInt();
		
			System.out.println("Insert Quantity ordered");
			int quantity = scan.nextInt();
			scan.nextLine();
				
			odb.createOrder(customer_id, product_id, quantity);
			System.out.println("\nOrder Successfully Created\n");
			showStartingSelection(); 
			
	}
			
	public void viewOrder()	throws SQLException {
		odb.viewOrder();
		System.out.println("\nType 'Y' to get back to the Main Menu\n");
		
		while(true) {
			String orderresult = scan.nextLine();
			if (orderresult.equals("Y") || orderresult.equals("y")) {
				showStartingSelection();
				break;
				
			}
		}		
	}
	

	public void deleteOrder() throws SQLException {
		System.out.println("Enter the order_id:");
			int order_id = Integer.parseInt(scan.nextLine());
			odb.deleteOrder(order_id);
		System.out.println("\nOrder Successfully Deleted\n");
		
		System.out.println("\nType 'Y' to get back to the Main Menu\n");
		
		while(true) {
			String orderresult = scan.nextLine();
			if (orderresult.equals("Y") || orderresult.equals("y")) {
				showStartingSelection();
				break;
			
			}
			
		}	
	}
	
	public void updateOrder() throws SQLException {
		System.out.println("Enter Order ID");
		int order_id = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter Product ID");
		int product_id = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter Quantity");
		int quantity = scan.nextInt();
		scan.nextLine();
		
		odb.updateOrder(order_id, product_id, quantity);
		
		System.out.println("\nUpdate Succesful!\n");	
		showStartingSelection();
	
	}
	
	public void calculateOrder()throws SQLException {
		System.out.println("Enter Order_Id you wish to calculate the value for?");
		int order_id = scan.nextInt();
		scan.nextLine();
		odb.calculateOrder(order_id);
		
		System.out.println("\nType 'Y' to get back to the Main Menu\n");
		
		while(true) {
			String orderresult = scan.nextLine();
			if (orderresult.equals("Y") || orderresult.equals("y")) {
				showStartingSelection();
				break;
	
		
			}
		}

	}
	
}
		

