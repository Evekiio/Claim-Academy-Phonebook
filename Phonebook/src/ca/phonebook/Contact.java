package ca.phonebook;

public class Contact extends Address
{
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	public Contact (String firstNameInput, String lastNameInput, String phoneNumberInput, String streetAddressInput, String cityAddressInput, String stateAddressInput)
	{
		super(streetAddressInput, cityAddressInput, stateAddressInput);
		this.firstName = firstNameInput;
		this.lastName = lastNameInput;
		this.phoneNumber = phoneNumberInput;
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
