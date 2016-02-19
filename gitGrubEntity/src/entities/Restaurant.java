package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="restaurant")
public class Restaurant
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "restaurants")
	private List<Customer> customers;
	
	@Column(name="category_id")
	private String categoryId;
	
	private String name;
	
	@Column(name="open_time")
	private Date openTime;
	@Column(name="close_time")
	private Date closeTime;

	@Column(name="street_address")
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	private String phone;
	
	//relationship to manager
	@OneToOne
	@JoinColumn(name="manager_email")
	private Manager manager;
	
	@Column(name="table_count")
	private int tableCount;
	
	@OneToMany(mappedBy="restaurant")
	private List<Menu> menus;

	public Menu getMenu(String s) {
		
		for (Menu menu :this.getMenus()) {
			if(menu.getType().equals(s)) {
				return menu;
			} else continue;
		}
		return null;
	}
	public String getCategoryId()
	{
		return categoryId;
	}
	
	public void setCategoryId(String category) {
		this.categoryId = category;
	}
	
	
	public List<Menu> getMenus() {
		return menus;
	}
	
	public void addMenu(Menu menu) {
		this.menus.add(menu);
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
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
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
				+ ", closeTime=" + closeTime + ", phone=" + phone + ", managerEmail=" + manager.getEmail()
				+ ", tableCount=" + tableCount + "]";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public List<Order> getSubmittedOrders() {
		List<Order> submittedOrders = new ArrayList<>();
		for (Customer cust : this.customers) {
			for (Order order : cust.getOrders()) {
				if(order.getStatus().equals("submitted") && !submittedOrders.contains(order) && order.getOrderDetails().get(0).getMenuItem().getRestId() == this.id) {
					submittedOrders.add(order);
					System.out.println("ORDER SUBMITTED SUCCESS");
				} else continue;
			}				
		}
		if(!(submittedOrders.size()>0)) {
			System.out.println("SORRY NO SUBBMITTED ORDERS in " + this.name);
		}
		return submittedOrders;
	}
	
	
	

}
