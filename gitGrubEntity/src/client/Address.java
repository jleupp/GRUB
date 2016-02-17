package client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@IdClass(Address_PK.class)
public class Address
{
	@Id
	@Column(name="address_tag")
	private String addressTag;
	@Column(name="street_address")
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	@Id
	@Column(name="email")
	private String email;
	
	
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
	
	@Override
	public String toString()
	{
		return "Address [addressTag=" + addressTag + ", streetAddress=" + streetAddress + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", customerEmail=" + email + "]";
	}
	public String getCustomerEmail() {
		return email;
	}
	public void setCustomerEmail(String customerEmail) {
		this.email = customerEmail;
	}
	public String getAddressTag() {
		return addressTag;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getEmail() {
		return email;
	}

}
