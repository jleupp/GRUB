package client;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="menu")
public class Menu
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private int menuId;
	private String type;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
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
	public Date getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	public Date getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Date endTime)
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
