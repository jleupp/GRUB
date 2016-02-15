package client;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address
{
	@Column(name="address_tag")
	private String addressTag;
	@Column(name="street_address")
	private String streetAddress;
	private String city;
	private String state;
	@Column(name="zip_code")
	private String zipCode;
	@Column(name="customer_email")
	private String customerEmail;
	
	public void setAddressTag(String addressTag)
	{
		this.addressTag = addressTag;
	}
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
	@Override
	public String toString()
	{
		return "Address [addressTag=" + addressTag + ", streetAddress=" + streetAddress + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", customerEmail=" + customerEmail + "]";
	}
	
	

}
