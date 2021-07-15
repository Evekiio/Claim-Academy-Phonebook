package ca.phonebook;

public class Menu
{
	public void mainMenu()
	{
		System.out.print("Welcome to the Phonebook\n1. Add Contact\n2. Remove Contact\n3. Search Directory\n4. Exit Phonebook");	
	}
	
	public void exitApplication()
	{
		Runtime.getRuntime().exit(0);
	}
}
