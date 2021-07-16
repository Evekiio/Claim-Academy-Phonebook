package ca.phonebook;

import java.util.Scanner;
//import java.util.Arrays;

public class Menu
{
	// Instantiate Database Object
	Database contactData = new Database();
	
	// A divider for UI/UX element (Esthetic Readability Support)
	public void divider(boolean isHeader, String header)
	{
		if (isHeader) 
		{
			System.out.println("\n[ " + header + " ]========================================\n");	
		}
		else
		{
			System.out.println("\n==========================================================\n");	
		}
	}
	
	// Displays and prompts the user with the main menu for navigation.
	public void mainMenu()
	{
		divider(true, "M A I N  M E N U");
		System.out.print("Welcome to the Phonebook\n1. Add Contact\n2. Remove Contact\n3. Update Contact\n4. Search Contacts \n5. Browse Contacts \n6. Exit Application\n\nPlease input a menu selection: ");
		Scanner scanner = new Scanner(System.in);
		int userSelection = scanner.nextInt();
		
		switch (userSelection)
		{
		case 1:
			addContact();
			break;
		case 2: 
			removeContact();
			break;
		case 3: 
			//updateContact();
			break;
		case 4:
			//searchContact();
		case 5:
			browseContacts();
			break;
		case 6:
			exitApplication();
			break;
		}
		scanner.close();
	}
	
	// Prompts user for contact information, creates the contact object with the given information, and stores it in the array of contacts.
	public void addContact()
	{
		String firstName;
		String lastName;
		String phoneNumber;
		String streetAddress;
		String city;
		String state;
		
		divider(true, "A D D  C O N T A C T");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("First Name: ");
		firstName = scanner.nextLine();
		
		System.out.print("Last Name: ");
		lastName = scanner.nextLine();
		
		System.out.print("Phone Number: ");
		phoneNumber = scanner.nextLine();
		
		System.out.print("Street Address: ");
		streetAddress = scanner.nextLine();
		
		System.out.print("City: ");
		city = scanner.nextLine();
		
		System.out.print("State: ");
		state = scanner.nextLine();
		
		System.out.print("\nAre you sure you wish to add " + firstName + " " + lastName + " to your phonebook? (Y / N): ");
		char confirmAddContact = scanner.next().toUpperCase().charAt(0);
		
		if (confirmAddContact == 'Y')
		{
			Contact newContact = new Contact(firstName, lastName, phoneNumber, streetAddress, city, state);
			
			try 
			{
				System.out.print("\n" + contactData.addContact(contactData.getDirectory(), newContact) + "\n");
			}
			catch (Exception e)
			{
				System.out.println("Failed to store data for " + newContact + " please retry entry... (Exception: " + e.toString() + ")");
			}
			mainMenu();
		}
		else
		{
			mainMenu();
		}
	}
	
	// METHOD :: Removes Object from Object[] (Array)
	public void removeContact()
	{
		System.out.print("\nWhat index would you like to remove? (1, 2, 3, Etc.): ");
		Scanner scanner = new Scanner(System.in);
		int indexToRemove = scanner.nextInt();
		
		Contact[] directory = contactData.getDirectory();
		
		System.out.print("\nAre you sure you wish to remove " + directory[indexToRemove].getFirstName() + " " + directory[indexToRemove].getLastName() + " from your phonebook? (Y / N): ");
		char confirmRemoveContact = scanner.next().toUpperCase().charAt(0);
		
		if (confirmRemoveContact == 'Y')
		{
			try 
			{
				contactData.removeContact(directory, indexToRemove);
			}
			catch (Exception e)
			{
				System.out.println("Failed to remove data for " + directory[indexToRemove].getFirstName() + " please retry removal... (Exception: " + e.toString() + ")");
			}
			mainMenu();
		}
		else
		{
			mainMenu();
		}
	}
	
	// Runs through each object within the "database" (array of contact objects) and gets each objects data.
	public void browseContacts()
	{
		
		Contact[] contactsToBrowse = contactData.getDirectory();
		
		if (contactsToBrowse.length == 0 || contactsToBrowse == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		for (int i = 0; i < contactsToBrowse.length; i++)
		{
			System.out.print("\nContact Data [" + i + "]: " + contactsToBrowse[i].getFirstName() + " " + contactsToBrowse[i].getLastName());
		}
		
		// Empty Line for UI/UX Functionality/Clarity & Return to Main Menu
		System.out.println("");
		mainMenu();
	}
	
	// Terminates the application runtime.
	public void exitApplication()
	{
		Runtime.getRuntime().exit(0);
	}
}
