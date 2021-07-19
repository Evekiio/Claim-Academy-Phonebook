package ca.phonebook;

public class Database
{
	private Contact[] directory = new Contact[0];
	Validation validator = new Validation();
	
	public Database()
	{
		super();
	}

	public String addContact(Contact[] oldDirectory, Contact newContact)
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
		return (newContact.getFirstName() + " " + newContact.getLastName() + " was stored successfully!");
	}
	
	public void removeContact(Contact[] oldDirectory, int contactIndexToRemove)
	{
		// Create a new object array that has less space so we can remove the contact object :: Old Array Size - 1
		Contact[] newDirectory = new Contact[oldDirectory.length - 1];
		int trackedRemoval = 0;
		// Copy all object references from old array to the new array, but skip the object index that we wish to remove.
		for (int i = 0; i < oldDirectory.length; i++)
		{
			if (i == contactIndexToRemove)
			{
				System.out.println("\nContact Index[" + contactIndexToRemove + "]:" + oldDirectory[contactIndexToRemove].getFirstName() + " " + oldDirectory[contactIndexToRemove].getLastName() + " has been removed from the directory.");
			}
			else 
			{
				newDirectory[trackedRemoval] = oldDirectory[i];
				// System.out.println("\n[New Contact Copied]: " + oldDirectory[i].getFirstName());
				trackedRemoval++;
			}
		}
		
		// Update reference for directory. 
		directory = newDirectory;	
	}
		
	public Contact[] getDirectory()
	{
		return directory;
	}

	public void setDirectory(Contact[] directory)
	{
		this.directory = directory;
	}
	
	public void checkIncomingData(String input)
	{
		validator.isValidString(input);
	}
}
