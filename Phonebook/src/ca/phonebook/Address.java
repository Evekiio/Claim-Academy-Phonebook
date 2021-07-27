package ca.phonebook;

public class Address 
{
	private String addressStreet;
	private String addressCity;
	private String addressState;
	private String addressZipCode;
	
	
	public Address(String addressStreet, String addressCity, String addressState, String addressZipCode)
	{
		super();
		
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZipCode = addressZipCode;
	}

	public String getAddressStreet()
	{
		return addressStreet;
	}


	public void setAddressStreet(String addressStreet)
	{
		this.addressStreet = addressStreet;
	}


	public String getAddressCity()
	{
		return addressCity;
	}


	public void setAddressCity(String addressCity)
	{
		this.addressCity = addressCity;
	}


	public String getAddressState()
	{
		return addressState;
	}


	public void setAddressState(String addressState)
	{
		this.addressState = addressState;
	}


	public String getAddressZipCode()
	{
		return addressZipCode;
	}


	public void setAddressZipCode(String addressZipCode)
	{
		this.addressZipCode = addressZipCode;
	}
	
	

}


