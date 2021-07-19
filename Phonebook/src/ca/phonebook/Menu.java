package ca.phonebook;

import java.util.Scanner;
//import java.util.Arrays;

public class Menu
{
	// Instantiate Database Object (Used for storing / maintaining contact data)
	Database contactData = new Database();

	
	//########### R E M O V E  T H I S  B E F O R E  R E L E A S I N G  A P P L I C A T I O N #######
	public void testingOnly() 
	{
	System.out.print("\n");
	Contact[] contacts = contactData.getDirectory();
	Contact user1 = new Contact("Sanders", "Riddle", "360-470-9231", "8010 Andrews Court", "Mountain Home AFB", "Idaho");
	System.out.println(contactData.addContact(contacts, user1));
	
	contacts = contactData.getDirectory();
	Contact user2 = new Contact("Kelsey", "Riddle", "850-585-9750", "8010 Andrews Court", "Mountain Home AFB", "Idaho");
	System.out.println(contactData.addContact(contacts, user2));
	
	mainMenu();
	
	}
	//###############################################################################################
	
	// A divider for menu UI/UX element (Esthetic Readability Support)
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
		
		// UPDATE MENU BEFORE RELEASING APPLICATION
		System.out.print("Welcome to the Phonebook\n1. Add Contact\n2. Remove Contact\n3. Update Contact\n4. Search Contacts \n5. Browse Contacts \n6. Exit Application\n\n##### TESTING ONLY #####\n7. FAST ADD CONTACTS TO DIRECTORY\n\nPlease input a menu selection: ");
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
			updateContact();
			break;
		case 4:
			System.out.print("\nSearch Functionality Coming Soon...\n");
			searchContacts();
			mainMenu();
			break;
		case 5:
			browseContacts();
			break;
		case 6:
			exitApplication();
			break;
		//########### R E M O V E  T H I S  B E F O R E  R E L E A S I N G  A P P L I C A T I O N #######
		case 7:
			testingOnly();
			break;
		//###############################################################################################
		}
		scanner.close();
	}
	
	// Prompts user for contact information, creates the contact object with the given information, and stores it in the array of contacts.
	public void addContact()
	{
		
		// Declare the Variables to Pass to the New Contact
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
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		for (int i = 0; i < directory.length; i++)
		{
			System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
															  directory[i].getLastName() + " | " + 
															  directory[i].getPhoneNumber() + " | " + 
															  directory[i].getStreetAddress() + " " + 
															  directory[i].getCity() + " " + 
															  directory[i].getState());
		}
		
		// Empty Line for UI/UX Functionality/Clarity & Return to Main Menu
		System.out.println("");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nWhat index would you like to remove? (1, 2, 3, Etc.): ");
		int indexToRemove = scanner.nextInt();
		
		System.out.print("\nAre you sure you wish to remove " + directory[indexToRemove].getFirstName() + " " + directory[indexToRemove].getLastName() + " from your phonebook? (Y / N): ");
		char confirmRemoveContact = scanner.next().toUpperCase().charAt(0);
		
		if (confirmRemoveContact == 'Y')
		{
			contactData.removeContact(directory, indexToRemove);
			mainMenu();
		}
		else
		{
			mainMenu();
		}
	}
	
	// TODO - FIX THE SCANNER INCONSISTANCIES DURING STREET ADDRESS UPDATES
	// Runs through each object within the "database" (array of contact objects) and gets each objects data.
	public void updateContact()
	{
		
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		else 
		{
			// Prompt user for phone number of existing contact
			System.out.println("\nPlease input the phone number for the contact you wish to update... Example: 429-155-1313");
			
			// Read from the input stream to initialize "userSelection"
			Scanner scanner = new Scanner(System.in);
			String userSelection = scanner.next();
			int contactFoundCount = 0;
			
			
			for (int i = 0; i < directory.length; i++)
			{
				if (userSelection.equals(directory[i].getPhoneNumber()))
					{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + directory[i].getLastName());
					contactFoundCount++;
					}
			}
			
			if (contactFoundCount > 0)
			{
				System.out.println("\n\nEnter the corrosponding contact number you would like to update...");
				int indexOfContact = scanner.nextInt();
				
				System.out.print("\nWhat would you like to modify?\n1. First Name\n2. Last Name\n3. Phone Number\n4. Address\n\n");
				int userSelectToUpdate = scanner.nextInt();
				String confirmed ="";
				
				
				// Read user input to control flow for updating the identified contact object.
				switch(userSelectToUpdate)
				{
				case 1:
					System.out.print("\nPlease enter the First Name you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newFirstName = scanner.next();
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getFirstName() + " with " + newFirstName + "? ( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setFirstName(newFirstName);
						System.out.print("\n" + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + " has been successfully updated.\n");
						mainMenu();
					}
					
					else
					{
						mainMenu();	
					}
				case 2: 
					System.out.print("\nPlease enter the Last Name you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newLastName = scanner.next();
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getLastName() + " with " + newLastName + "? ( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setLastName(newLastName);
						System.out.print("\n" + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + " has been successfully updated.\n");
						mainMenu();
					}
					
					else
					{
						mainMenu();	
					}
				case 3:
					System.out.print("\nPlease enter the Phone Number you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newPhoneNumber = scanner.next();
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getPhoneNumber() + " with " + newPhoneNumber + "? ( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setPhoneNumber(newPhoneNumber);
						System.out.print("\n" + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + " has been successfully updated.\n");
						mainMenu();
					}
					
					else
					{
						mainMenu();	
					}
				case 4:
					System.out.print("\nPlease enter the street address you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newStreet = scanner.next();
					
					System.out.print("\nPlease enter the city you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newCity = scanner.next();
					
					System.out.print("\nPlease enter the state you would like for " + directory[indexOfContact].getPhoneNumber() + ": ");
					String newState = scanner.next();
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getFirstName() + " with... \nStreet: " + newStreet + "\nCity: " + newCity + "\nState: " + newState + "\n( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setStreetAddress(newStreet);
						directory[indexOfContact].setCity(newCity);
						directory[indexOfContact].setState(newState);
						
						System.out.print("\n" + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + " has been successfully updated.\n");
						
						
						mainMenu();
					}
					
					else
					{
					
						mainMenu();	
					}
				}
			}
			else
			{
				System.out.println("\n0 contacts were found matching that number...");
				mainMenu();
			}
		}
		
		for (int i = 0; i < directory.length; i++)
		{
			
		}
		
		// Empty Line for UI/UX Functionality/Clarity & Return to Main Menu
		System.out.println("");
		mainMenu();
	}

	// TODO - NOT STARTED
	// Search Functionality
	public void searchContacts()
	{
		
	}
	
	// TODO - CLEAN UP UI/UX 
	// Runs through each object within the "database" (array of contact objects) and gets each objects data.
	public void browseContacts()
	{
		
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		for (int i = 0; i < directory.length; i++)
		{
			System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
															  directory[i].getLastName() + " | " + 
															  directory[i].getPhoneNumber() + " | " + 
															  directory[i].getStreetAddress() + " " + 
															  directory[i].getCity() + " " + 
															  directory[i].getState());
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
