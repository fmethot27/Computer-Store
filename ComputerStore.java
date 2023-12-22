package Assigmnent1;

import java.util.Scanner;

public class ComputerStore {
	static Scanner kb;
	private static final String validpassword = "password";
	private static final int attemps = 3;
	private static int currentsze = 0;

	private static void password() {
		// TODO Auto-generated method stub
		kb = new Scanner(System.in);
		for (int tries = 1; tries <= attemps; tries++) {
			System.out.println("Please input your password to access this section: ");
			String password = kb.nextLine();

			if (password.equals(validpassword)) {
				System.out.println("Login in successful.");
				break;
			} else {
				System.err.println("Wrong password. You have " + (attemps - tries) + " chance left.");
				if (tries == attemps) {
					System.err.println("Too many tries. Sending you back to main menu.");
					return;
				}
			}
		}
	}

	private static void findByBrand(String brand) {
		boolean found = false;

		// Iterate through the computers and display information for matching brands
		for (Computer computer : ) {
			if (computer.getBrand().equalsIgnoreCase(brand)) {
				computer.displayInfo();
				found = true;
			}
		} // missing some info for the display of the information

		// Display a message if no computers with the specified brand were found
		if (!found) {
			System.out.println("No computers found for the brand: " + brand);
		}
	}

	private static void findCheaper(double pricetoMatch) {
		// TODO Auto-generated method stub
		for (int i = 0; i < currentsze; i++) {
			if (inventory[i].getPrice() < pricetoMatch) {
				inventory[i].displayInfo();
				found = true;
			}
		}
		if (!found) {
			System.out.println("No computers were found that is cheaper than " + pricetoMatch + "$");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kb = new Scanner(System.in);
		int option;
		System.out.println("Welcome to the computer store.");
		System.out.println("Please input the number that represent the maximum inventory computer your store can have:");
		int MAX_INV = kb.nextInt();
		Computer[] inventory = new Computer[MAX_INV];
		{

			do {
				System.out.println("What do you want to do?");
				System.out.print("1. Enter new computers (requires a password).\n"
						+ "2. Change information of a computer (requires a password). \n"
						+ "3. Display all computers by a specific brand. \n"
						+ "4. Display all computer under a certain price. \n" + "5. Quit.\n" + "\n"
						+ "Please enter your choice -> ");
				while (!kb.hasNextInt()) {
					System.err.println("Invalid choice. Please enter a valid selection.");
					kb.next();
				}
				option = kb.nextInt();
				switch (option) {
				case 1:
					kb = new Scanner(System.in);
					password();
					System.out.println("Please enter the number of computer you want to add:");
					if (kb.hasNextInt()) {
						int NumOfCompToAdd = kb.nextInt();
						if (NumOfCompToAdd <= inventory.length) {
							currentsze = (currentsze + NumOfCompToAdd);
							System.out.println("We added " + NumOfCompToAdd + " to your inventory.");
							break;
						} else {
							System.out.println("Not enough space in the inventory. Can add a maximum of "
									+ (MAX_INV - currentsze) + " computers.");
							// need to find a way to show what's left and return to line 55
							break;
						}
					}
				case 2:
					kb = new Scanner(System.in);
					password();
					System.out.println("Please enter the inventory number of the computer you want to modify:");
					int index = kb.nextInt();
					if (index >= 0 && index < inventory.length) {
						if (inventory[index] != null) {
							inventory[index].displayInfo(index);
							// need to add the computer's info
						}
					}

					break;
				case 3:
					kb = new Scanner(System.in);
					System.out.println("Please enter a brand you want to search in our inventory:");
					String BrandToFind = kb.next();
					findByBrand(BrandToFind);
					break;
				case 4:
					kb = new Scanner(System.in);
					System.out.println("Please enter a price to find the computers that are cheaper in our inventory:");
					double PricetoMatch = kb.nextDouble();
					findCheaper(PricetoMatch);
					break;
				case 5:
					System.out.println("Thank you for using our program.");
					kb.close();
					System.exit(0);

				default:
					System.err.println("Invalid input. Please choose again.");
					break;

				}

			} while (option != 5);

		}
	}
}
