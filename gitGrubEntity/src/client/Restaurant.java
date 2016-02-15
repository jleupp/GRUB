package client;

import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="restaurant")
public class Restaurant
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="category_id")
	private String categoryId;
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name="open_time")
	private Calendar openTime;
	@Temporal(TemporalType.DATE)
	@Column(name="close_time")
	private Calendar closeTime;
	@Column(name="street_address")
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	
	//relationship to manager
	@Column(name="manager_email")
	private String managerEmail;
	@Column(name="table_count")
	private int tableCount;
	public String getCategoryId()
	{
		return categoryId;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Calendar getOpenTime()
	{
		return openTime;
	}
	public void setOpenTime(Calendar  openTime)
	{
		this.openTime = openTime;
	}
	public Calendar getCloseTime()
	{
		return closeTime;
	}
	public void setCloseTime(Calendar closeTime)
	{
		this.closeTime = closeTime;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZipcode()
	{
		return zipcode;
	}
	public void setZipcode(String zipcode)
	{
		this.zipcode = zipcode;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getManagerEmail()
	{
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail)
	{
		this.managerEmail = managerEmail;
	}
	public int getTableCount()
	{
		return tableCount;
	}
	public void setTableCount(int tableCount)
	{
		this.tableCount = tableCount;
	}
	public int getId()
	{
		return id;
	}
	@Override
	public String toString()
	{
		return "Restaurant [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", streetAddress=" + streetAddress + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", phone=" + phone + ", managerEmail=" + managerEmail
				+ ", tableCount=" + tableCount + "]";
	}
	
	
	

}
