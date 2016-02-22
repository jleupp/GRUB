package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import client.Person;

@Entity
@Table(name="manager")
public class Manager implements Person
{
	@Id
	private String email;
	
	private String password;
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="access_id", referencedColumnName="id")
	private Access access;

	//relationship with restaurants This manager has a restaurant - "restaurant"
	@OneToOne(mappedBy="manager")
	private Restaurant restaurant;
	
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
	public Access getAccess()
	{
		return access;
	}
	public void setAccess(Access access)
	{
		this.access = access;
	}
	@Override
	public String toString()
	{
		return "Manager [email=" + email + ", password=" + password + ", phone=" + phone + ", accessLevel=" + access.getAccessLevel()
				+ "]";
	}
	@Override
	public Order getPendingOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
