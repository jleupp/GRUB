package entities;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private int menuId;
	
	private String type;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id", referencedColumnName="id")
	private Restaurant restaurant;
	
	@OneToMany(mappedBy="menu")
	private List<MenuItem> items;
	
	
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public Time getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Time startTime)
	{
		this.startTime = startTime;
	}
	public Time getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Time endTime)
	{
		this.endTime = endTime;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	public int getMenuId()
	{
		return menuId;
	}
	@Override
	public String toString()
	{
		return "Menu [menuId=" + menuId + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", restaurantId=" + restaurant.getName() + " " + restaurant.getManager().getEmail() + "]";
	}
	public List<MenuItem> getItems() {
		return items;
	}
	
	public void addMenuItem(MenuItem item) {
		this.items.add(item);
	}
	
}
