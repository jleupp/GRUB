package entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public List<MenuSection> getMenuSections() {
		List<MenuSection> sections = new ArrayList<>();
		for (MenuItem mi : this.getItems()) {
			if(!sections.contains(mi.getSection())) {
				sections.add(mi.getSection());
			} else {
				System.out.println(mi.getSection() + "IS ALREADY IN SECTION LIST");
			}
		}
//		this.getRestaurant().getName()
		Collections.sort(sections);
		return sections;
	}
	
	public MenuItem getMenuItemByID(int i) {
		for (MenuItem mi : this.items) {
			if(mi.getId() == i) {
				return mi;
			} else continue;
		}
		System.out.println("DID NOT MATCH MENU ITEM BY ID IN MENU.class");
		return null;
	}
	
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
