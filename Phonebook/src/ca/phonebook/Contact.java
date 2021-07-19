package ca.phonebook;

public class Contact extends Address
{
	
	// Declare Variables
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Contact(String firstName, String lastName, String phoneNumber, String addressStreet, String addressCity, String addressState, int addressZipCode)
	{
		super(addressStreet, addressCity, addressState, addressZipCode);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
