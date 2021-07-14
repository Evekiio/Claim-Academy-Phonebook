package ca.phonebook;

import java.io.IOException;
import java.util.Scanner;

public class Menu
{
	
	// MAIN MENU ARTWORK
	public void menuTitleArt()
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("  ####### ##   ##  ######  ###    ## ####### ######   ######   ######  ##   ##  ");	 
		System.out.println("  ##   ## ##   ## ##    ## ####   ## ##      ##   ## ##    ## ##    ## ##  ##   ");
		System.out.println("  ####### ####### ##    ## ## ##  ## #####   ######  ##    ## ##    ## #####    ");   
		System.out.println("  ##      ##   ## ##    ## ##  ## ## ##      ##   ## ##    ## ##    ## ##  ##   ");  
		System.out.println("  ##      ##   ##  ######  ##   #### ####### ######   ######   ######  ##   ##  ");
		System.out.println("--------------------------------------------------------------------------------");                                                                                                                        
	}
	
	// MAIN MENU (SELECTIONS)
	public void menuSelections()
	{
		System.out.println("     W E L C O M E  T O  Y O U R  P H O N E B O O K  A P P L I C A T I O N");
		System.out.println("");
		System.out.println("     Please select from the following choices...");
		System.out.println("     1. ADD NEW CONTACT");
		System.out.println("     2. REMOVE CONTACT");
		System.out.println("     3. UPDATE CONTACT");
		System.out.println("     4. SEARCH DIRECTORY FOR CONTACT");
		System.out.println("     5. EXIT/CLOSE PHONEBOOK");
		
		
		System.out.print("\n     Enter selection: ");
		Scanner scanner = new Scanner(System.in);
		int userSelection = scanner.nextInt();
	
		System.out.println("\n--------------------------------------------------------------------------------");
		
		// Switch Statement to Control Menu Flow
		switch (userSelection)
		{
		case 1: 
			menuAdd();
			break;
		case 5:
			exitApplication();
			break;
		}
		
	}
	
	// ADD NEW CONTACT MENU
	public void menuAdd()  
	{
		Scanner addContactScanner = new Scanner(System.in);
		
		System.out.println("\n     A D D  N E W  C O N T A C T  I N F O R M A T I O N");
		
		System.out.print("     First Name: ");
		String contactFirstName = addContactScanner.next();
		
		System.out.print("     Last Name: ");
		String contactLastName = addContactScanner.next();
		
		System.out.print("     Telephone: ");
		String contactTelephone = addContactScanner.next();
		
		System.out.print("     City: ");
		String contactCity = addContactScanner.next();
		
		System.out.print("     State: ");
		String contactState = addContactScanner.next();
		
		System.out.print("\n     Are you sure you wish to add this contact to your phonebook? (Y or N):  ");
		String contactAddConfirm = addContactScanner.next();
		System.out.println("\n--------------------------------------------------------------------------------");
		
		addContactScanner.close();

	}
	
	// DELETE/REMOVE CONTACT MENU
	public void menuRemove()
	{
		
	}
	
	// UPDATE CONTACT MENU
	public void menuUpdate()
	{
		
	}
	
	// SEARCH DIRECTORIES MENU
	public void menuSearch()
	{
		
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



