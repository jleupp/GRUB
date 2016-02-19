package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import client.Person;
@Entity 
@Table(name="customer")
public class Customer implements Person
{
	@Id
	private String email;
	
	private String password;
	private String phone;
	
	@Transient
	private Order pendingOrder;
	
	@ManyToMany
	@JoinTable(name="order_history", joinColumns = @JoinColumn(name="customer_id"), inverseJoinColumns = @JoinColumn(name="restaurant_id"))
	private List<Restaurant> restaurants;
	
	@OneToMany
	@JoinColumn(name = "email", referencedColumnName="email")
	private List<Address> adresses;
	
	@ManyToOne
	@JoinColumn(name="access_id", referencedColumnName="id")
	private Access access;
	
	@Column(name="birth_day")
	private Date birthDay;
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.REMOVE)
	private List<Order> orders;
	
	public List<Order> getActiveOrders() {
		List<Order> actOrd = new ArrayList<>();
		for (Order order : this.orders) {
			if(order.getStatus().equals("submitted")) {
				actOrd.add(order);
			}
		}
		return actOrd;
	}
	
	public void addPendingOrder(Order order) {
		System.out.println("IN CUSTOMER addPending " + order.getDateOrdered());
		this.pendingOrder = order;
	}
	
	public Order getPendingOrder() {
		return this.pendingOrder;
	}
	
	public void addNewRestaurant(Order order) {
		Restaurant rest = order.getOrderDetails().get(0).getMenuItem().getMenu().getRestaurant();
		if (!restaurants.contains(rest)) {
			this.restaurants.add(rest);
			System.out.println("CUSTOMERS RESTAURANT LIST DIDN'T HAVE " + rest.getName() + "SO ADDED TO LIST");
		} else {
			System.out.println("CUSTOMERS RESTAURANT LIST ALREADY CONTAINED " + rest.getName() + "SO DID NOT ADD TO LIST");
		}
	}
	
	public String getEmail()
	{
		return this.email;
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
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public void addOrder(Order order) {
		System.out.println("IN CUSTOMER addOrder " + order.getDateOrdered());
		this.orders.add(order);
	}
	
	public void removeCustomersOrders() {
		for (Order order : this.orders) {
			System.out.println("REMOVING ORDER FROM CUSTOMER " + this.email);
			order.removeOrderItems();
		}
	}
	
}
