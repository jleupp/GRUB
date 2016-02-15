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

@Entity @Table(name="menu")
public class Menu
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private int menuId;
	private String type;
	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Calendar startTime;
	@Temporal(TemporalType.DATE)
	@Column(name="end_time")
	private Calendar endTime;
	@Column(name="restaurant_id")
	private int restaurantId;
	
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public Calendar getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Calendar startTime)
	{
		this.startTime = startTime;
	}
	public Calendar getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Calendar endTime)
	{
		this.endTime = endTime;
	}
	public int getRestaurantId()
	{
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId)
	{
		this.restaurantId = restaurantId;
	}
	public int getMenuId()
	{
		return menuId;
	}
	@Override
	public String toString()
	{
		return "Menu [menuId=" + menuId + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", restaurantId=" + restaurantId + "]";
	}
	
}
