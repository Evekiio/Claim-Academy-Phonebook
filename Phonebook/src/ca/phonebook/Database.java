package ca.phonebook;

public class Database
{
	private Contact[] directory = new Contact[0];

	public Database()
	{
		super();
	}

	public void addContact(Contact[] oldDirectory, Contact newContact)
	{
		// Create a new object array that has room for the new contact :: Old Array Size + 1
		Contact[] newDirectory = new Contact[oldDirectory.length + 1];
		
		// Copy all object references from old array to the new array.
		for (int i = 0; i < oldDirectory.length; i++)
		{
			newDirectory[i] = oldDirectory[i];
		}
		
		// Add the new contact in the last index of new array. 
		newDirectory[oldDirectory.length] = newContact;
		
		// Update reference for directory. 
		directory = newDirectory;
	}
	
	public void removeContact()
	{
		
	}

	public Contact[] getDirectory()
	{
		return directory;
	}

	public void setDirectory(Contact[] directory)
	{
		this.directory = directory;
	}
	
	
}
