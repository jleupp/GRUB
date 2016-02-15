package client;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="manager")
public class Manager implements Person
{
	@Id
	private String email;
	private String password;
	private String phone;
	@Column(name="access_id")
	private int accessId;
	//relationship with restaurants 
	private Collection<Restaurant>restaurants;
	
	public Collection<Restaurant> getRestaurants(){
		return restaurants;
	}
	//do we need a setter for collection restaurants?
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public int getAccessId()
	{
		return accessId;
	}
	public void setAccessId(int accessId)
	{
		this.accessId = accessId;
	}
	@Override
	public String toString()
	{
		return "Manager [email=" + email + ", password=" + password + ", phone=" + phone + ", accessId=" + accessId
				+ "]";
	}
}
