package client;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import entities.Access;
@Entity 
@Table(name="customer")
public class Customer implements Person
{
	@Id
	private String email;
	
	private String password;
	private String phone;
	
	@OneToMany
	@JoinColumn(name = "customer_email", referencedColumnName="email")
	private List<Address> adresses;
	
	@ManyToOne
	@JoinColumn(name="access_id", referencedColumnName="id")

	private Access access;
	
	@Column(name="birth_day")
	private Date birthDay;
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
//	public int getAccessId()
//	{
//		return accessId;
//	}
	
	public Access getAccess() {
		return this.access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}
	
	public Date getBirthDay()
	{
		return birthDay;
	}
	
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	@Override
	public String toString()
	{
		return "Customer [email=" + email + ", password=" + password + ", phone=" + phone + ", accessLevel=" + access.getAccessLevel() + ", accessID= " + access.getId()
				+ ", birthDay=" + birthDay + "]";
	}
	
}
