package ca.phonebook;

import java.util.Scanner;

public class Menu
{
	
	private int userSelection = 0;
	Scanner scanner = new Scanner(System.in);
	
	// MAIN MENU ARTWORK
	public void menuTitleArt()
	{
		// Basic Graphical Artwork : Simply Esthetic
		System.out.println("--------------------------------------------------------------------------------\n");
		System.out.println("  ####### ##   ##  ######  ###    ## ####### ######   ######   ######  ##   ##  ");	 
		System.out.println("  ##   ## ##   ## ##    ## ####   ## ##      ##   ## ##    ## ##    ## ##  ##   ");
		System.out.println("  ####### ####### ##    ## ## ##  ## #####   ######  ##    ## ##    ## #####    ");   
		System.out.println("  ##      ##   ## ##    ## ##  ## ## ##      ##   ## ##    ## ##    ## ##  ##   ");  
		System.out.println("  ##      ##   ##  ######  ##   #### ####### ######   ######   ######  ##   ##  ");                                                                                                                
	}
	
	// MAIN MENU (SELECTIONS)
	public void menuSelections()
	{
		System.out.println("\n--------------------------------------------------------------------------------");
		System.out.println("     ++++ M A I N  M E N U ++++");
		System.out.println("");
		System.out.println("     Please select from the following choices...");
		System.out.println("     1. ADD NEW CONTACT");
		System.out.println("     2. REMOVE CONTACT");
		System.out.println("     3. UPDATE CONTACT");
		System.out.println("     4. SEARCH DIRECTORY FOR CONTACT");
		System.out.println("     5. EXIT/CLOSE PHONEBOOK");
		
		System.out.print("\n     Enter selection: ");
			
		userSelection = scanner.nextInt();
		
		System.out.println("\n--------------------------------------------------------------------------------");
		
		
		// Switch Statement to Control Menu Flow
		switch (userSelection)
		{
		case 1: 
			menuAdd();
			break;
		case 2: 
			menuRemove();
			break;
		case 3: 
			menuUpdate();
			break;
		case 4:
			menuSearch();
			break;
		case 5:
			exitApplication();
			break;
		case 6:
			Database.databaseConnection();
		default:
			System.out.println("Invalid selection. Please enter a number 1-5 to make a selection...");
			menuSelections();
		}
	}
	
	// ADD NEW CONTACT MENU
	public void menuAdd()  
	{
		
		System.out.println("     ++++ A D D  C O N T A C T ++++");
		
		System.out.print("\n     First Name: ");
		String contactFirstName = scanner.next();
		
		System.out.print("     Last Name: ");
		String contactLastName = scanner.next();
		
		System.out.print("     Telephone: ");
		String contactTelephone = scanner.next();
		
		System.out.print("     Street Address: ");
		String contactStreet = scanner.next();
		
		System.out.print("     City: ");
		String contactCity = scanner.next();
		
		System.out.print("     State: ");
		String contactState = scanner.next();
		
		System.out.print("\n     Are you sure you wish to add this contact to your phonebook? (Y or N):  ");
		String contactAddConfirm = scanner.next();
		
		if (contactAddConfirm.charAt(0) == 'Y')
		{
			Contact contact = new Contact(contactFirstName, contactLastName, contactTelephone, contactStreet, contactCity, contactState);
			System.out.print("\n     " + contact.getFirstName() + " " + contact.getLastName() + " added to phonebook!\n");
		}
		
		// TODO: Add data validation to verify the char input is either Y or N.
			
		menuSelections();
	}
	
	// DELETE/REMOVE CONTACT MENU
	public void menuRemove()
	{
		System.out.println("     ++++ R E M O V E  C O N T A C T ++++");
		
		System.out.print("\n     Telephone Number: ");
		String input = scanner.next();
		
		if (input.contentEquals("back"))
		{
			menuSelections();
		}
		
	}
	
	// UPDATE CONTACT MENU
	public void menuUpdate()
	{
		System.out.println("     ++++ U P D A T E  C O N T A C T ++++");
		
		System.out.print("\n     Telephone Number: ");
		String input = scanner.next();
		
		if (input.contentEquals("back"))
		{
			menuSelections();
		}
	}
	
	// SEARCH DIRECTORIES MENU
	public void menuSearch()
	{
		System.out.println("     ++++ S E A R C H  D I R E C T O R Y ++++");
		
		System.out.print("\n     Telephone Number: ");
		String input = scanner.next();
		
		if (input.contentEquals("back"))
		{
			menuSelections();
		}
	}
	
	// EXIT APPLICATION (TERMINATE RUNTIME)
	public void exitApplication()
	{
		Runtime.getRuntime().exit(0);
	}
	
	public void clearConsole() 
	{
	  // FIXME: Figure out why java clear console doesn't work...
	}
}



