package ca.phonebook;

public class Database
{
	private Contact[] directory = new Contact[0];
	
	public Database()
	{
		super();
	}

	public Contact[] getDirectory()
	{
		return directory;
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
		return ("   " + newContact.getFirstName() + " " + newContact.getLastName() + " was stored successfully!");
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
		
	public void searchContacts(String searchInput, int searchBySelection)
	{
		int count = 0;
		
		switch (searchBySelection)
		{
		case 1:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getFirstName().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 2:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getLastName().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 3:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getPhoneNumber().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 4: 
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getAddressStreet().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 5:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getAddressCity().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 6:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getAddressState().equals(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		case 7:
			for (int i = 0; i < directory.length; i++)
			{
				if (directory[i].getAddressZipCode() == Integer.parseInt(searchInput))
				{
					System.out.print("\nContact Data [" + i + "]: " + directory[i].getFirstName() + " " + 
																	  directory[i].getLastName() + " | " + 
																	  directory[i].getPhoneNumber() + " | " + 
																	  directory[i].getAddressStreet() + " " + 
																	  directory[i].getAddressCity() + " " + 
																	  directory[i].getAddressState() + ", " +
																	  directory[i].getAddressZipCode());
				
				count++;
				}
			}
			
			if (count == 0)
			{
				System.out.println("\nNo contacts found matching your criteria...");
			}
			break;
		}
	}
	
	public void setDirectory(Contact[] directory)
	{
		this.directory = directory;
	}	

	public void sortDirectory(Contact[] directory)
	{
		Contact tempContact = new Contact(null, null, null, null, null, null, 0);
		
		for (int i = 0; i < directory.length; i++)
		{
			for (int j = i + 1; j < directory.length; j++)
			{
				if (directory[i].getFirstName().charAt(0) > directory[j].getFirstName().charAt(0))
				{
					tempContact = directory[i];
					directory[i] = directory[j];
					directory[j] = tempContact;
				}
				else if (directory[i].getFirstName().charAt(0) == directory[j].getFirstName().charAt(0))
				{
					if (directory[i].getFirstName().charAt(1) > directory[j].getFirstName().charAt(1))
					{
						tempContact = directory[i];
						directory[i] = directory[j];
						directory[j] = tempContact;
					}
				}
				else 
				{
					
				}
			}
		}
	}
}
