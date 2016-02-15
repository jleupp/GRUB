package client;

import javax.persistence.*;

@Entity @Table(name="menu_item")
public class MenuItem
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double price;
	private String description;
	@Column(name="rest_id")
	private int restId;
	@Column(name="temp_id")
	private int tempId;
	@Column(name="menusection_id")
	private int menuSectionId;
	@Column(name="menu_id")
	private int menuId;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public int getRestId()
	{
		return restId;
	}
	public void setRestId(int restId)
	{
		this.restId = restId;
	}
	public int getTempId()
	{
		return tempId;
	}
	public void setTempId(int tempId)
	{
		this.tempId = tempId;
	}
	public int getMenuSectionId()
	{
		return menuSectionId;
	}
	public void setMenuSectionId(int menuSectionId)
	{
		this.menuSectionId = menuSectionId;
	}
	public int getMenuId()
	{
		return menuId;
	}
	public void setMenuId(int menuId)
	{
		this.menuId = menuId;
	}
	public int getId()
	{
		return id;
	}
	@Override
	public String toString()
	{
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", restId=" + restId + ", tempId=" + tempId + ", menuSectionId=" + menuSectionId + ", menuId="
				+ menuId + "]";
	}
}
