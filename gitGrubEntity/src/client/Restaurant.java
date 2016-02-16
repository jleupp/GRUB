package client;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity @Table(name="restaurant")
public class Restaurant
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="category_id")
	private String categoryId;
	private String name;
	
	@Column(name="open_time")
	private Date openTime;
	@Column(name="close_time")
	private Date closeTime;
	@Embedded
	private Address address;
//	@Column(name="street_address")
//	private String streetAddress;
//	private String city;
//	private String state;
//	private String zipcode;
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
	public Date getOpenTime()
	{
		return openTime;
	}
	public void setOpenTime(Date  openTime)
	{
		this.openTime = openTime;
	}
	public Date getCloseTime()
	{
		return closeTime;
	}
	public void setCloseTime(Date closeTime)
	{
		this.closeTime = closeTime;
	}
	public Address getAddress(){
		return address;
	}
	
//	public String getStreetAddress()
//	{
//		return streetAddress;
//	}
//	public void setStreetAddress(String streetAddress)
//	{
//		this.streetAddress = streetAddress;
//	}
//	public String getCity()
//	{
//		return city;
//	}
//	public void setCity(String city)
//	{
//		this.city = city;
//	}
//	public String getState()
//	{
//		return state;
//	}
//	public void setState(String state)
//	{
//		this.state = state;
//	}
//	public String getZipcode()
//	{
//		return zipcode;
//	}
//	public void setZipcode(String zipcode)
//	{
//		this.zipcode = zipcode;
//	}
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
		//toDo add in to string for address.getCity() 
		return "Restaurant [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", phone=" + phone + ", managerEmail=" + managerEmail
				+ ", tableCount=" + tableCount + "]";
	}
	
	
	

}
