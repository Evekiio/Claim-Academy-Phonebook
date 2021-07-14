package ca.phonebook;

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
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n     Enter selection: ");
		
		int userSelection = scanner.nextInt();
		scanner.close();
		
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
	
}


