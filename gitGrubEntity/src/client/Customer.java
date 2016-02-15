package client;

import javax.persistence.*;

import java.util.*;
@Entity @Table(name="customer")
public class Customer implements Person
{
	@Id
	private String email;
	private String password;
	private String phone;
	@Column(name="access_id")
	private int accessId;
	@Column(name="birth_day")
	@Temporal(TemporalType.DATE)
	private Calendar birthDay;
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
	public Calendar getBirthDay()
	{
		return birthDay;
	}
	@Override
	public String toString()
	{
		return "Customer [email=" + email + ", password=" + password + ", phone=" + phone + ", accessId=" + accessId
				+ ", birthDay=" + birthDay + "]";
	}
	
}
