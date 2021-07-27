package ca.phonebook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{
	// Instantiate Database Object (Used for storing / maintaining contact data)
	Database contactData = new Database();
	
	//########### R E M O V E  T H I S  B E F O R E  R E L E A S I N G  A P P L I C A T I O N #######
	public void testingOnly() 
	{
	System.out.print("\n");
	Contact[] contacts = contactData.getDirectory();
	Contact user1 = new Contact("Sanders", "Riddle", "1111111111", "2121 Testers Lane", "Olympia", "Washington", "98557");
	System.out.println(contactData.addContact(contacts, user1));
	
	contacts = contactData.getDirectory();
	Contact user2 = new Contact("Tester", "Test", "2222222222", "8080 Bruce Court", "Mountain Home", "Idaho", "83648");
	System.out.println(contactData.addContact(contacts, user2));
	
	contacts = contactData.getDirectory();
	Contact user3 = new Contact("Bob", "Smith", "1111111111", "1111 Testing Avenue", "Boise", "Idaho", "83701");
	System.out.println(contactData.addContact(contacts, user3));
	
	mainMenu();
	}
	//###############################################################################################
	
	// A divider for menu UI/UX element (Esthetic Readability Support)
	public void divider(boolean isHeader, String header)
	{
		if (isHeader) 
		{
			System.out.println("\n ==[ " + header + " ]===============================\n");	
		}
		else
		{
			System.out.println("\n ===================================================\n");	
		}
	}
	
	// Displays and prompts the user with the main menu for navigation.
	public void mainMenu()
	{ 
		// PRINTS OUT ARTWORK FOR MAIN MENU
		System.out.println("__     __  _ _                 _____                      "); 
		System.out.println("\\ \\   / / | | |               |  __ \\                     "); 
		System.out.println(" \\ \\_/ /__| | | _____      __ | |__) |_ _  __ _  ___  ___ "); 
		System.out.println("  \\   / _ \\ | |/ _ \\ \\ /\\ / / |  ___/ _` |/ _` |/ _ \\/ __|"); 
		System.out.println("   | |  __/ | | (_) \\ V  V /  | |  | (_| | (_| |  __/\\__ \\"); 
		System.out.println("   |_|\\___|_|_|\\___/ \\_/\\_/   |_|   \\__,_|\\__, |\\___||___/"); 
		System.out.println(" ==========================================__/ |=========="); 
		System.out.println("                                          |___/");     
				
		// UPDATE MENU BEFORE RELEASING APPLICATION
		System.out.print(""
				+ "\n   1. Add Contact"
				+ "\n   2. Remove Contact"
				+ "\n   3. Update Contact"
				+ "\n   4. Search Contacts"
				+ "\n   5. Browse Sorted Contacts"
				+ "\n   6. Exit Application"
				+ "\n\n   ##### TESTING ONLY #####"
				+ "\n   7. Fast Add Contacts (Testing Only)"
				+ "\n\n   Please input a menu selection: ");
		
		Scanner scanner = new Scanner(System.in);
		int userSelection  = 0;
		
		// 57::71 Get user input for menu selection, if selection is text, == 0, or > 7... (Anything outside of 1-7) print out error message and return to the main menu. 
		try 
		{
			userSelection = scanner.nextInt();
			
			if (userSelection == 0 || userSelection > 7)
			{
				System.out.println("\n   You made an invalid menu selection... please enter a whole number 1-7:");
				mainMenu();
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("\n   You made an invalid menu selection... please enter a whole number 1-7:");
			mainMenu();
		}
		
		// 74::101 Switch Statement to navigate to the next menu based on user input on line 59.
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
			searchContacts();
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
	
	// MENU SELECTION: 1 - Prompts user for contact information, creates the contact object with the given information, and stores it in the array of contacts.
	public void addContact()
	{
		
		// Declare the Variables to Pass to the New Contact
		String firstName;
		String lastName;
		String phoneNumber = null;
		String addressStreet;
		String addressCity;
		String addressState;
		String addressZipCode;
		
		divider(true, "A D D  C O N T A C T");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("   First Name: ");
		firstName = scanner.nextLine();
		
		System.out.print("   Last Name: ");
		lastName = scanner.nextLine();
		
		try 
		{
			System.out.print("   Phone Number: ");
			phoneNumber = scanner.nextLine();
		}
		
		catch (Exception e)
		{
			System.out.print("   That was not a valid phone number... Please enter a valid 10-digit US phone number... (Example: 111-111-1111 / 1111111111): ");
		}
		
		System.out.print("   Street Address: ");
		addressStreet = scanner.nextLine();
		
		System.out.print("   City: ");
		addressCity = scanner.nextLine();
		
		System.out.print("   State: ");
		addressState = scanner.nextLine();
		
		System.out.print("   Zip Code: ");
		addressZipCode = scanner.nextLine();
		
		System.out.print("\n   Are you sure you wish to add " + firstName + " " + lastName + " to your phonebook? (Y / N): ");
		char confirmAddContact = scanner.next().toUpperCase().charAt(0);
		
		if (confirmAddContact == 'Y')
		{
			Contact newContact = new Contact(firstName, lastName, phoneNumber, addressStreet, addressCity, addressState, addressZipCode);
			
			try 
			{
				System.out.print("\n   " + contactData.addContact(contactData.getDirectory(), newContact) + "\n");
			}
			catch (Exception e)
			{
				System.out.println("\n   Failed to store data for " + newContact + " please retry entry... (Exception: " + e.toString() + ")");
			}
			
			mainMenu();
		}
		else
		{
			System.out.println("\n   Failed to store data, Please try again and confirm with 'Y' or 'N'");
			mainMenu();
		}
	}
	
	// MENU SELECTION: 2 - Removes Object from Object[] (Array)
	public void removeContact()
	{
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		divider(true, "R E M O V E  C O N T A C T");
		
		for (int i = 0; i < directory.length; i++)
		{
			System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
															  directory[i].getLastName() + " | " + 
															  directory[i].getPhoneNumber() + " | " + 
															  directory[i].getAddressStreet() + " " + 
															  directory[i].getAddressCity() + " " + 
															  directory[i].getAddressState() + ", " +
															  directory[i].getAddressZipCode());
		}
		
		// Empty Line for UI/UX Functionality/Clarity & Return to Main Menu
		System.out.println("");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nWhat index would you like to remove? (1, 2, 3, Etc.): ");
		
		try 
		{
			int indexToRemove = scanner.nextInt();
			
			if (indexToRemove < 0 || indexToRemove > directory.length)
			{
				System.out.print("\nThat was not a valid index...");
				removeContact();
			}
			
			try 
			{
				System.out.print("\nAre you sure you wish to remove " + directory[indexToRemove].getFirstName() + " " + directory[indexToRemove].getLastName() + " from your phonebook? (Y / N): ");
				char confirmRemoveContact = scanner.next().toUpperCase().charAt(0);
				
				if (confirmRemoveContact == 'Y')
				{
					contactData.removeContact(directory, indexToRemove);
					mainMenu();
				}
				else if (confirmRemoveContact == 'N')
				{
					System.out.println("\n" + directory[indexToRemove].getFirstName() + " " + directory[indexToRemove].getLastName() + " was not removed.");
					mainMenu();
				}	
				
				else
				{
					System.out.println("\nThat was not a valid input... please enter 'Y' for Yes or 'N' for No");
					removeContact();
				}
			}
			
			catch (Exception e)
			{
				System.out.println("\nSystem Error: " + e.getMessage());
				removeContact();
			}

		}
		
		catch (Exception e)
		{
			System.out.println("\nThat was not a valid index...");
			removeContact();
		}

	}
	
	// MENU SELECTION: 3 - Runs through each object within the "database" (array of contact objects) and gets each objects data.
	public void updateContact()
	{
		
		Contact[] directory = contactData.getDirectory();
		
		String newPhoneNumber;
		String phoneNumber = null;
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		else 
		{
			for (int i = 0; i < directory.length; i++)
			{
				System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																  directory[i].getLastName() + " | " + 
																  directory[i].getPhoneNumber() + " | " + 
																  directory[i].getAddressStreet() + " " + 
																  directory[i].getAddressCity() + " " + 
																  directory[i].getAddressState() + ", " +
																  directory[i].getAddressZipCode());
			}
			
			// Prompt user for phone number of existing contact
			System.out.println("\n\nPlease input the phone number of the contact you wish to update... Example: 429-155-1313");
			
			// Read from the input stream to initialize "userSelection"
			@SuppressWarnings("resource")
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
				System.out.println("\n\nEnter the corrosponding index number you would like to update...");
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
					
					
					try 
					{
						newPhoneNumber = scanner.next();
						
						if (newPhoneNumber.contains("-"))
						{
							newPhoneNumber.replace("-", "");
						}
						
				
					}
					
					catch (Exception e)
					{
						System.out.print("That was not a valid phone number... Please enter a valid 10-digit US phone number... (Example: 111-111-1111 / 1111111111): ");
					}
					
					
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getPhoneNumber() + " with " + phoneNumber + "? ( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setPhoneNumber(phoneNumber);
						System.out.print("\n" + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + " has been successfully updated.\n");
						mainMenu();
					}
					
					else
					{
						mainMenu();	
					}
				case 4:
					scanner.nextLine();
					
					System.out.print("\nPlease enter the street address you would like for " + directory[indexOfContact].getFirstName() + " " +  directory[indexOfContact].getLastName() + ": ");
					String newStreet = scanner.nextLine();
					
					System.out.print("\nPlease enter the city you would like for " + directory[indexOfContact].getAddressCity() + ": ");
					String newCity = scanner.nextLine();
					
					System.out.print("\nPlease enter the state you would like for " + directory[indexOfContact].getAddressState() + ": ");
					String newState = scanner.nextLine();
					
					System.out.print("\nPlease enter the zip code you would like to replace " + directory[indexOfContact].getAddressZipCode() + ": ");
					String newZipCode = scanner.nextLine();
					
					System.out.print("\nAre you sure you want to update " + directory[indexOfContact].getFirstName() + " " + directory[indexOfContact].getLastName() + " with... \n\nStreet Address: " + newStreet + "\nCity: " + newCity + "\nState: " + newState + "\nZip Code: " + newZipCode + "\n\n( Y / N ): ");
					confirmed = scanner.next().toUpperCase();
					
					
					if (confirmed.equals("Y"))
					{
						directory[indexOfContact].setAddressStreet(newStreet);
						directory[indexOfContact].setAddressCity(newCity);
						directory[indexOfContact].setAddressState(newState);
						directory[indexOfContact].setAddressZipCode(newZipCode);
						
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

	// MENU SELECTION: 4 - Search Functionality
	public void searchContacts()
	{
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\nYour phonebook has 0 total contacts.");
			mainMenu();
		}
		
		else 
		{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String userSearchQuery;
			int userSelection = 0;
			boolean isValid = false;
	
			
			while (isValid == false)
			{
				System.out.println("\nPlease select what you would like to search by...\n\n1. First Name\n2. Last Name\n3. Phone Number\n4. Street Address\n5. City\n6. State\n7. Zip Code\n\nPlease make a selection (1-7): ");
				try 
				{
					userSelection = scanner.nextInt();
					
					if (userSelection > 0 && userSelection <= 7)
					{
						isValid = true;
					}
					
					else
					{
						isValid = false;
					}
				}
				catch (Exception e)
				{
					System.out.print("Incorrect Input: Please enter a whole number 1-7...");
					searchContacts();
				}
			}
					
			// SWITCH STATEMENT
			switch (userSelection)
			{
			case 1:
				try
				{
					System.out.println("Please enter the first name of the contact you're looking for: ");
					userSearchQuery = scanner.next();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				
				break;
			case 2:
				try
				{
					System.out.println("Please enter the last name of the contact you're looking for: ");
					userSearchQuery = scanner.next();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			case 3:
				try
				{
					System.out.println("Please enter the phone number of the contact you're looking for: ");
					userSearchQuery = scanner.next();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			case 4:
				try
				{
					System.out.println("Please enter the street of the contact you're looking for: ");
					scanner.nextLine();
					userSearchQuery = scanner.nextLine();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			case 5:
				try
				{
					System.out.println("Please enter the city of the contact you're looking for: ");
					scanner.nextLine();
					userSearchQuery = scanner.nextLine();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			case 6:
				try
				{
					System.out.println("Please enter the state of the contact you're looking for: ");
					userSearchQuery = scanner.next();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			case 7:
				try
				{
					System.out.println("Please enter the zip code of the contact you're looking for: ");
					userSearchQuery = scanner.next();
					contactData.searchContacts(userSearchQuery, userSelection);
					System.out.print("\n");
					mainMenu();
				}
				
				catch (Exception e)
				{
					System.out.println("Search Failed: Please try again...");
					searchContacts();
				}
				break;
			}
		}
	}
	
	// MENU SELECTION: 5 - Runs through each object within the "database" (array of contact objects) and gets each objects data.
	public void browseContacts()
	{
		
		
		// FIXME: ADD ASC / DSC OPTIONS
		Contact[] directory = contactData.getDirectory();
		
		if (directory.length == 0 || directory == null)
		{
			System.out.println("\n   Your phonebook has 0 total contacts.");
			mainMenu();
		}
		
		// Tells the database class to sort the directory using the un-efficient method of comparing the ASCII values of the first characters in first name.
		contactData.sortDirectory(contactData.getDirectory());
		
		for (int i = 0; i < directory.length; i++)
		{
			System.out.print("\n   Contact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
															  directory[i].getLastName() + " | " + 
															  directory[i].getPhoneNumber() + " | " + 
															  directory[i].getAddressStreet() + " " + 
															  directory[i].getAddressCity() + " " + 
															  directory[i].getAddressState() + ", " +
															  directory[i].getAddressZipCode());
		}
		
		// Empty Line for UI/UX Functionality/Clarity & Return to Main Menu
		System.out.println("");
		mainMenu();
	}
	
	// MENU SELECTION: 6 - Terminates the application runtime.
	public void exitApplication()
	{
		Runtime.getRuntime().exit(0);
	}
}
