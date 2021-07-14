package ca.phonebook;

public class Address 
{
	private String streetAddress;
	private String cityAddress;
	private String stateAddress;
	
	public Address (String streetAddressInput, String cityAddressInput, String stateAddressInput) 
	{
		this.streetAddress = streetAddressInput;
		this.cityAddress = cityAddressInput;
		this.stateAddress = stateAddressInput;
	}

	public String getStreetAddress()
	{
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}

	public String getCityAddress()
	{
		return cityAddress;
	}

	public void setCityAddress(String cityAddress)
	{
		this.cityAddress = cityAddress;
	}

	public String getStateAddress()
	{
		return stateAddress;
	}

	public void setStateAddress(String stateAddress)
	{
		this.stateAddress = stateAddress;
	}
}
