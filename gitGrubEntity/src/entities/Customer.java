package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import client.Person;
@Entity 
@Table(name="customer")
public class Customer implements Person
{
	@Id
	private String email;
	
	private String password;
	private String phone;
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
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
	
	public void addPendingOrder(Order order) {
		this.pendingOrder = order;
	}
	
	public void addNewRestaurant(Order order) {
		Restaurant rest = order.getOrderDetails().get(0).getMenuItem().getMenu().getRestaurant();
		restaurants.add(rest);
		rest.addCustomer(this);
		
	}
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
		this.orders.add(order);
	}
	
}
